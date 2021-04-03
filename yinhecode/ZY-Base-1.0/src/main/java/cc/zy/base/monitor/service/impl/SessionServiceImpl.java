package cc.zy.base.monitor.service.impl;

import cc.zy.base.businesses.entity.Student;
import cc.zy.base.businesses.entity.StudentPool;
import cc.zy.base.common.utils.AddressUtil;
import cc.zy.base.common.utils.DateUtil;
import cc.zy.base.monitor.entity.ActiveUser;
import cc.zy.base.monitor.service.ISessionService;
import cc.zy.base.system.entity.User;
import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static cc.zy.base.monitor.entity.ActiveUser.OFFLINE;
import static cc.zy.base.monitor.entity.ActiveUser.ONLINE;

/**
 * @author MrBird
 */
@Service
@RequiredArgsConstructor
public class SessionServiceImpl implements ISessionService {

    private final SessionDAO sessionDAO;

    @Override
    public List<ActiveUser> list(String username) {
        String currentSessionId = (String) SecurityUtils.getSubject().getSession().getId();

        List<ActiveUser> list = new ArrayList<>();
        Collection<Session> sessions = sessionDAO.getActiveSessions();
        for (Session session : sessions) {
            ActiveUser activeUser = new ActiveUser();
            User user;
            SimplePrincipalCollection principalCollection;
            Student stu = new Student();
            StudentPool stuPool = new StudentPool();
            if (session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY) == null) {
                continue;
            } else {
                principalCollection = (SimplePrincipalCollection) session
                        .getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);

                if(principalCollection.getPrimaryPrincipal().getClass() != stu.getClass() && principalCollection.getPrimaryPrincipal().getClass() != stuPool.getClass())
                {
                    user = (User) principalCollection.getPrimaryPrincipal();
                    activeUser.setUsername(user.getUsername());
                    activeUser.setUserId(user.getUserId().toString());
                }
            }
            if(principalCollection.getPrimaryPrincipal().getClass() != stu.getClass() && principalCollection.getPrimaryPrincipal().getClass() != stuPool.getClass()) {
                activeUser.setId((String) session.getId());
                activeUser.setHost(session.getHost());
                activeUser.setStartTimestamp(DateUtil.getDateFormat(session.getStartTimestamp(), DateUtil.FULL_TIME_SPLIT_PATTERN));
                activeUser.setLastAccessTime(DateUtil.getDateFormat(session.getLastAccessTime(), DateUtil.FULL_TIME_SPLIT_PATTERN));
                long timeout = session.getTimeout();
                activeUser.setStatus(timeout == 0L ? OFFLINE : ONLINE);
                String address = AddressUtil.getCityInfo(activeUser.getHost());
                activeUser.setLocation(address);
                activeUser.setTimeout(timeout);
                if (StringUtils.equals(currentSessionId, activeUser.getId())) {
                    activeUser.setCurrent(true);
                }
                if (StringUtils.isBlank(username)
                        || StringUtils.equalsIgnoreCase(activeUser.getUsername(), username)) {
                    list.add(activeUser);
                }
            }
        }
        return list;
    }

    @Override
    public void forceLogout(String sessionId) {
        Session session = sessionDAO.readSession(sessionId);
        session.setTimeout(0);
        session.stop();
        sessionDAO.delete(session);
    }

    @Override
    public List<SimplePrincipalCollection> getPrincipals(@NonNull Long userId) {
        List<SimplePrincipalCollection> collections = Lists.newArrayList();
        Collection<Session> sessions = sessionDAO.getActiveSessions();
        for (Session session : sessions) {
            if (session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY) != null) {
                SimplePrincipalCollection simplePrincipalCollection = (SimplePrincipalCollection) session
                        .getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
                if (simplePrincipalCollection != null) {
                    User user = (User) simplePrincipalCollection.getPrimaryPrincipal();
                    if (userId.equals(user.getUserId())) {
                        collections.add(simplePrincipalCollection);
                    }
                }
            }
        }
        return collections;
    }
}

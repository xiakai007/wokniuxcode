package cc.zy.base.businesses.service.impl;

import cc.zy.base.businesses.entity.Notice;
import cc.zy.base.businesses.mapper.NoticAddMapper;
import cc.zy.base.businesses.mapper.NoticeMapper;
import cc.zy.base.businesses.service.INoticAddService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
@Slf4j
public class NoticAddServiceImpl implements INoticAddService{
    private final NoticAddMapper noticeAddMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertNotice(Notice notice) {
        List<String> userIds = notice.getUserIds();
        Set<String> set = new HashSet();
        for (String userId : userIds) {
            set.add(userId);
        }
        if(userIds != null && userIds.size()>0){
            noticeAddMapper.insertNotice(notice);
            log.info("插入完成后，获取的主键id为："+notice.getId());
            for (String userIdTemp : set) {
                notice.setUserId(userIdTemp);
                noticeAddMapper.insertNoticeUser(notice);
            }
        }
    }

    @Override
    public void insertNoticeTemp(Notice notice) {
        List<String> userIds = notice.getUserIds();
        Set<String> set = new HashSet();
        for (String userId : userIds) {
            set.add(userId);
        }
        if(userIds != null && userIds.size()>0) {
            noticeAddMapper.insertNoticeTemp(notice);
            log.info("插入完成后，获取的主键id为：" + notice.getId());
            for (String userIdTemp : set) {
                notice.setUserId(userIdTemp);
                noticeAddMapper.insertNoticeUser(notice);
            }
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void sendNotice(Integer id) {
        log.info("进来了"+id);
        noticeAddMapper.sendNotice(id);
    }
}

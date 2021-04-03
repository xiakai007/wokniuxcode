package cc.zy.base.businesses.service.impl;


import cc.zy.base.businesses.entity.NoticeUser;
import cc.zy.base.businesses.mapper.NoticeUserMapper;
import cc.zy.base.businesses.service.INoticeUserService;
import cc.zy.base.common.entity.FebsConstant;
import cc.zy.base.common.entity.QueryRequest;
import cc.zy.base.common.utils.SortUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 通知人表 Service实现
 *
 * @author guozhikun
 * @date 2021-01-27 14:14:52
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class NoticeUserServiceImpl extends ServiceImpl<NoticeUserMapper, NoticeUser> implements INoticeUserService {
    @Resource
    private final NoticeUserMapper noticeUserMapper;

    @Override
    public IPage<NoticeUser> findNoticeUsers(QueryRequest request, NoticeUser noticeUser,Integer noticeId) {
        Page<NoticeUser> page = new Page<>(request.getPageNum(), request.getPageSize());
        page.setSearchCount(false);
        page.setTotal(baseMapper.countNoticeUserDetail(noticeId));
        SortUtil.handlePageSort(request,page,"readStatusId", FebsConstant.ORDER_ASC, true);

        return this.baseMapper.findNoticeUserByNoticeIdPage(page,noticeUser,noticeId);
    }

    @Override
    public List<NoticeUser> findNoticeUsers(NoticeUser noticeUser) {
	    LambdaQueryWrapper<NoticeUser> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createNoticeUser(NoticeUser noticeUser) {
        this.save(noticeUser);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateNoticeUser(NoticeUser noticeUser) {
        this.saveOrUpdate(noticeUser);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteNoticeUser(NoticeUser noticeUser) {
        LambdaQueryWrapper<NoticeUser> wrapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    this.remove(wrapper);
	}

    @Override
    public long countNoticeUser(Integer noticeId) {
        return noticeUserMapper.countNoticeUserDetail(noticeId);
    }

    @Override
    public int countNoticeUserRead(Integer noticeId) {
        return noticeUserMapper.countNoticeUserRead(noticeId);
    }

    @Override
    public int updateNoticeUserRead(Integer noticeId, String openId) {
        int id = noticeUserMapper.findStudentIdByOpenId(openId);

        return noticeUserMapper.updateNoticeUserRead(noticeId, id);
    }


    /**
     * 修改通知之删除通知
     */
    @Override
    public int delectNoticeUserByNoticeId(Integer noticeId) {
        return noticeUserMapper.delectNoticeUserByNoticeId(noticeId);
    }

    /**
     * 修改通知之增加通知
     */
    @Override
    public int insertNoticeUserByNoticeId(NoticeUser noticeUser) {
        return noticeUserMapper.insertNoticeUserByNoticeId(noticeUser);
    }

    @Override
    public List<NoticeUser> findNoticeUserList() {
        return noticeUserMapper.findNoticeUserList();
    }

}

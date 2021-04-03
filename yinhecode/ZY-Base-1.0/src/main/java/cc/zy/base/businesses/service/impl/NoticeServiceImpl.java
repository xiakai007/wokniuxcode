package cc.zy.base.businesses.service.impl;


import cc.zy.base.businesses.entity.Notice;
import cc.zy.base.businesses.entity.NoticeUser;
import cc.zy.base.businesses.mapper.NoticeMapper;
import cc.zy.base.businesses.service.INoticeService;
import cc.zy.base.common.entity.FebsConstant;
import cc.zy.base.common.entity.QueryRequest;
import cc.zy.base.common.utils.SortUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
import lombok.RequiredArgsConstructor;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

/**
 * 通知表 Service实现
 *
 * @author 杨东豪
 * @date 2021-01-26
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements INoticeService {

    private final NoticeMapper noticeMapper;

    @Override
    public IPage<Notice> findNotices(QueryRequest request, Notice notice) {
        Page<Notice> page = new Page<>(request.getPageNum(), request.getPageSize());
        page.setSearchCount(false);
        page.setTotal(baseMapper.countNoticeDetail(notice));
        return this.baseMapper.findNoticeDetailPage(page, notice);
    }

    /**
     * 查询（分页）
     * @param notice
     * @param request
     * @return
     */
    @Override
    public IPage<Notice> findNoticesDetailList(Notice notice, QueryRequest request) {
        if(notice!=null && notice.getTitle()!=null){
            notice.setTitle(notice.getTitle().trim());
        }
        Page<Notice> page = new Page<>(request.getPageNum(), request.getPageSize());
        page.setSearchCount(false);
        page.setTotal(baseMapper.countNoticeDetail(notice));
        SortUtil.handlePageSort(request, page, "id", FebsConstant.ORDER_ASC, false);
        return this.baseMapper.findNoticeDetailPage(page, notice);
    }

    @Override
    public List<Notice> findNotices(Notice notice) {
	    LambdaQueryWrapper<Notice> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createNotice(Notice notice) {
        this.save(notice);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateNotice(Notice notice) {
        this.saveOrUpdate(notice);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteNotice(Notice notice) {
        LambdaQueryWrapper<Notice> wrapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    this.remove(wrapper);
	}

    /**
     * 删除通知通过id
     */
    @Override
    public void deleteNoticeById(Integer noticeId) {
         baseMapper.deleteById(noticeId);
    }


    /**
     * 创建人查学生
     */
    @Override
    public List<Notice> findCreatIdByUserId(Integer noticeId) {
        return baseMapper.findCreatIdByUserId(noticeId);
    }

    @Override
    public List<Integer> findUserIdListByUserId(Integer noticeId) {
        return baseMapper.findUserIdsByUserId(noticeId);
    }

    /**
     * 查询通过id
     */
    @Override
    public Notice findNoticeById(Integer noticeId) {
        return baseMapper.findNoticeById(noticeId);
    }


    /**
     * 插入notice_user的表
     */
    @Override
    public void insertNoticeUser(NoticeUser noticeUser) {
        noticeMapper.insertNoticeUser(noticeUser);
    }

    /**
     * 修改通知
     */
    @Override
    public int UpdateNoticeByidy(Notice notice) {
        return noticeMapper.UpdateNoticeByidy(notice);
    }

}

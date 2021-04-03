package cc.zy.base.businesses.service;

import cc.zy.base.businesses.entity.Notice;


import cc.zy.base.businesses.entity.NoticeUser;
import cc.zy.base.common.entity.QueryRequest;
import cc.zy.base.system.entity.User;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 通知表 Service接口
 *
 * @author 杨东豪
 * @date 2021-01-26
 */
public interface INoticeService extends IService<Notice> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param notice notice
     * @return IPage<Notice>
     */
    IPage<Notice> findNotices(QueryRequest request, Notice notice);

    /**
     * 查询（分页）
     * @param notice
     * @param request
     * @return
     */
    IPage<Notice> findNoticesDetailList(Notice notice, QueryRequest request);
    /**
     * 查询（所有）
     *
     * @param notice notice
     * @return List<Notice>
     */
    List<Notice> findNotices(Notice notice);

    /**
     * 新增
     *
     * @param notice notice
     */
    void createNotice(Notice notice);

    /**
     * 修改
     *
     * @param notice notice
     */
    void updateNotice(Notice notice);

    /**
     * 删除
     *
     * @param notice notice
     */
    void deleteNotice(Notice notice);

    /**
     * 删除通知通过id
     */
    void deleteNoticeById(Integer noticeId);


    /**
     * 创建人查学生
     */
    List<Notice> findCreatIdByUserId(Integer noticeId);

    List<Integer> findUserIdListByUserId(Integer noticeId);

    /**
     * 查询通过id
     */
    Notice findNoticeById(Integer noticeId);


    /**
     * 插入notice_user的表
     */
    void insertNoticeUser(NoticeUser noticeUser);

    /**
     * 修改通知
     */
    int UpdateNoticeByidy(Notice notice);

}

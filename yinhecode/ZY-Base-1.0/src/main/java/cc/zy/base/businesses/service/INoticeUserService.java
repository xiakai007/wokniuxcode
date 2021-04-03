package cc.zy.base.businesses.service;

import cc.zy.base.businesses.entity.NoticeUser;


import cc.zy.base.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.aspectj.weaver.ast.Not;

import java.util.List;

/**
 * 通知人表 Service接口
 *
 * @author guozhikun
 * @date 2021-01-27 14:14:52
 */
public interface INoticeUserService extends IService<NoticeUser> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param noticeUser noticeUser
     * @return IPage<NoticeUser>
     */
    IPage<NoticeUser> findNoticeUsers(QueryRequest request, NoticeUser noticeUser, Integer noticeId);

    /**
     * 查询（所有）
     *
     * @param noticeUser noticeUser
     * @return List<NoticeUser>
     */
    List<NoticeUser> findNoticeUsers(NoticeUser noticeUser);

    /**
     * 新增
     *
     * @param noticeUser noticeUser
     */
    void createNoticeUser(NoticeUser noticeUser);

    /**
     * 修改
     *
     * @param noticeUser noticeUser
     */
    void updateNoticeUser(NoticeUser noticeUser);

    /**
     * 删除
     *
     * @param noticeUser noticeUser
     */
    void deleteNoticeUser(NoticeUser noticeUser);

    /**
     * 通知人数
     * @param noticeId
     * @return
     */
    long countNoticeUser(Integer noticeId);

    /**
     * 通知已读人数
     * @param noticeId
     * @return
     */
    int countNoticeUserRead(Integer noticeId);

    /**
     * 修改已读状态接口 ****
     * @param noticeId
     * @param openId
     * @return
     */
    int updateNoticeUserRead(Integer noticeId,String openId);


    /**
     * 修改通知之删除通知
     */
    int delectNoticeUserByNoticeId(Integer noticeId);

    /**
     * 修改通知之增加通知
     */
    int insertNoticeUserByNoticeId(NoticeUser noticeUser);

    /**
     * 导出 通知详情全部信息
     * @return
     */
    List<NoticeUser> findNoticeUserList();

}

package cc.zy.base.businesses.mapper;


import cc.zy.base.businesses.entity.NoticeUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;

/**
 * 通知人表 Mapper
 *
 * @author guozhikun
 * @date 2021-01-27 14:14:52
 */
public interface NoticeUserMapper extends BaseMapper<NoticeUser> {
    /**
     * 统计详情
     * @param page
     * @param noticeUser
     * @param noticeId
     * @return
     */
    <T> IPage<NoticeUser> findNoticeUserByNoticeIdPage(Page<T> page, @Param("noticeUser") NoticeUser noticeUser, @Param("noticeId") Integer noticeId);

    /**
     * 阅读详情总人数
     * @param noticeId
     * @return
     */
    long countNoticeUserDetail(@Param("noticeId") Integer noticeId);

    /**
     * 已读人数
     * @param noticeId
     * @return
     */
    int countNoticeUserRead(@Param("noticeId") Integer noticeId);

    /**
     * 根据openId(微信小程序)获取学生id
     * @param openId
     * @return
     */
    int findStudentIdByOpenId(@Param("openId")String openId);

    /**
     * 修改学生阅读状态为已读
     * @param noticeId
     * @param userId
     * @return
     */
    int updateNoticeUserRead(@Param("noticeId")Integer noticeId,@Param("userId")Integer userId);

    /**
     * 修改通知之删除通知
     */
    int delectNoticeUserByNoticeId(Integer noticeId);

    /**
     * 修改通知之增加通知
     */
    int insertNoticeUserByNoticeId(NoticeUser noticeUser);

    /**
     * 通知详情集合
     * @return
     */
    List<NoticeUser> findNoticeUserList();

}

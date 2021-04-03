package cc.zy.base.businesses.mapper;

import cc.zy.base.businesses.entity.Notice;
import org.apache.ibatis.annotations.Param;

/**
 * 用于创建通知的mapper
 * @author 赵佳伟
 * @date 2021/01/29
 */

public interface NoticAddMapper {

    /**
     * 查询字典表里通知的状态
     * @return 状态id
     */
    Integer findDicId();

    /**
     * 新建通知
     * @param notice
     */
    void insertNotice(@Param("notice")Notice notice);

    /**
     * 发送草稿
     * @param id 通知id
     */
    void sendNotice(@Param("id") Integer id);

    /**
     * 发送通知后添加学生
     * @param notice
     */
    void insertNoticeUser(@Param("notice") Notice notice);

    /**
     * 保存草稿
     * @param notice
     */
    void insertNoticeTemp(@Param("notice")Notice notice);

}

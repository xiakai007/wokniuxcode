package cc.zy.base.businesses.service;

import cc.zy.base.businesses.entity.Notice;
import org.springframework.stereotype.Service;

/**
 * 创建通知和保存草稿的service
 * @author zhaojw
 * @date 2021/01/29
 */
public interface INoticAddService {

    /**
     * 创建通知的方法
     */
    void insertNotice(Notice notice);

    /**
     * 保存草稿的方法
     */
    void insertNoticeTemp(Notice notice);

    /**
     * 草稿发布的方法
     */
    void sendNotice(Integer id);
}

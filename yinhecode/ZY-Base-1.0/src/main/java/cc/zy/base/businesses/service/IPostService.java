package cc.zy.base.businesses.service;

import cc.zy.base.businesses.entity.Post;


import cc.zy.base.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *  Service接口
 *
 * @author 杨东豪
 * @date 2021-01-22
 */
public interface IPostService extends IService<Post> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param post post
     * @return IPage<Post>
     */
    IPage<Post> findPosts(QueryRequest request, Post post);

    /**
     * 查询（所有）
     *
     * @param post post
     * @return List<Post>
     */
    List<Post> findPosts(Post post);

    /**
     * 新增
     *
     * @param post post
     */
    void createPost(Post post);

    /**
     * 修改
     *
     * @param post post
     */
    void updatePost(Post post);

    /**
     * 删除
     *
     * @param post post
     */
    void deletePost(Post post);
}

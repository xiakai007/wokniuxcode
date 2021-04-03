package cc.zy.base.businesses.service.impl;


import cc.zy.base.businesses.entity.Post;
import cc.zy.base.businesses.mapper.PostMapper;
import cc.zy.base.businesses.service.IPostService;
import cc.zy.base.common.entity.QueryRequest;
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
 *  Service实现
 *
 * @author 杨东豪
 * @date 2021-01-22
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements IPostService {

    private final PostMapper postMapper;

    @Override
    public IPage<Post> findPosts(QueryRequest request, Post post) {
        LambdaQueryWrapper<Post> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<Post> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<Post> findPosts(Post post) {
	    LambdaQueryWrapper<Post> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createPost(Post post) {
        this.save(post);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updatePost(Post post) {
        this.saveOrUpdate(post);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deletePost(Post post) {
        LambdaQueryWrapper<Post> wrapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    this.remove(wrapper);
	}
}

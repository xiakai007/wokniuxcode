package cc.zy.base.businesses.controller;


import cc.zy.base.businesses.entity.Post;
import cc.zy.base.businesses.service.IPostService;
import cc.zy.base.common.annotation.ControllerEndpoint;
import cc.zy.base.common.controller.BaseController;
import cc.zy.base.common.entity.FebsConstant;
import cc.zy.base.common.entity.FebsResponse;
import cc.zy.base.common.entity.QueryRequest;
import cc.zy.base.common.utils.FebsUtil;
import com.wuwenze.poi.ExcelKit;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 *  Controller
 *
 * @author 杨东豪
 * @date 2021-01-22
 */
@Slf4j
@Validated
@Controller
@RequiredArgsConstructor
@RequestMapping("post")
public class PostController extends BaseController {

    private final IPostService postService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "post")
    public String postIndex(){
        return FebsUtil.view("post/post");
    }

    @GetMapping("post")
    @ResponseBody
    @RequiresPermissions("post:list")
    public FebsResponse getAllPosts(Post post) {
        return new FebsResponse().success().data(postService.findPosts(post));
    }

    @GetMapping("list")
    @ResponseBody
    public FebsResponse postList(QueryRequest request, Post post) {
        Map<String, Object> dataTable = getDataTable(this.postService.findPosts(request, post));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增Post", exceptionMessage = "新增Post失败")
    @PostMapping("add")
    @ResponseBody
    @RequiresPermissions("post:add")
    public FebsResponse addPost(@Valid Post post) {
        this.postService.createPost(post);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除Post", exceptionMessage = "删除Post失败")
    @GetMapping("delete")
    @ResponseBody
    @RequiresPermissions("post:delete")
    public FebsResponse deletePost(Post post) {
        this.postService.deletePost(post);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改Post", exceptionMessage = "修改Post失败")
    @PostMapping("update")
    @ResponseBody
    @RequiresPermissions("post:update")
    public FebsResponse updatePost(Post post) {
        this.postService.updatePost(post);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改Post", exceptionMessage = "导出Excel失败")
    @PostMapping("excel")
    @ResponseBody
    @RequiresPermissions("post:export")
    public void export(QueryRequest queryRequest, Post post, HttpServletResponse response) {
        List<Post> posts = this.postService.findPosts(queryRequest, post).getRecords();
        ExcelKit.$Export(Post.class, response).downXlsx(posts, false);
    }
}

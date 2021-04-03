package cc.zy.base.businesses.controller;


import cc.zy.base.businesses.entity.Video;

import cc.zy.base.businesses.service.IVideoService;
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
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Map;

/**
 * Controller
 *
 * @author 夏凯
 * @date 2021-01-25 11:03:36
 */
@Slf4j
@Validated
@Controller
@RequiredArgsConstructor
@RequestMapping("video")
public class VideoController extends BaseController {
    @Resource
    private IVideoService videoService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "video")
    public String videoIndex() {
        return FebsUtil.view("video/video");
    }

    /**
     * @param video 在线视频对象
     * @return videoList 视频列表
     * @description 条件查询在线视频列表
     */
    @GetMapping("video")
    @ResponseBody
    @RequiresPermissions("video:list")
    public FebsResponse getAllVideos(Video video) {
        log.debug("视频查询参数：" + video);
        List<Video> videoList = videoService.findVideos(video);
        log.debug("返回视频列表：" + videoList);
        return new FebsResponse().success().data(videoList);
    }

    /**
     * @param video 视频对象查询参数
     * @return dataTable 视频列表
     * @description 条件查询在线视频列表，分页展示
     */
    @GetMapping("list")
    @ResponseBody
    public FebsResponse videoList(QueryRequest request, Video video) {
        log.debug("视频查询参数：" + video);
        if (video != null && video.getName() != null) {
            video.setName(video.getName().trim());
        }
        Map<String, Object> dataTable = getDataTable(this.videoService.findVideos(request, video));
        log.debug("视频列表：" + dataTable);
        return new FebsResponse().success().data(dataTable);
    }

    /**
     * @param video 添加视频对象参数
     * @return
     * @description 添加在线视频记录
     */
    @ResponseBody
    @PostMapping("add")
    @ControllerEndpoint(operation = "新增Video", exceptionMessage = "新增Video失败")
    public FebsResponse addVideo(@Valid Video video) {
        log.debug("视频添加对象：" + video);
        boolean flag = this.videoService.createVideo(video);
        if (flag) {
            return new FebsResponse().success();
        } else {
            return new FebsResponse().fail().message("请选择二级目录");
        }

    }

    /**
     * @param video 删除视频对象参数
     * @return
     * @description 根据条件删除视频记录
     */
    @ResponseBody
    @GetMapping("video/delete")
    @RequiresPermissions("video:delete")
    @ControllerEndpoint(operation = "删除Video", exceptionMessage = "删除Video失败")
    public FebsResponse deleteVideo(Video video) {
        log.debug("视频删除对象：" + video);
        this.videoService.deleteVideo(video);
        return new FebsResponse().success();
    }

    /**
     * @param video 视频对象参数
     * @return
     * @description 根据条件修改视频对象记录
     */
    @ResponseBody
    @PostMapping("update")
    @ControllerEndpoint(operation = "修改Video", exceptionMessage = "修改Video失败")
    public FebsResponse updateVideo(Video video) {
        log.debug("视频修改对象：" + video);
        boolean flag = this.videoService.updateVideo(video);
        if (flag) {
            return new FebsResponse().success();
        } else {
            return new FebsResponse().fail().message("请选择二级目录");
        }

    }

    /**
     * @param video
     * @description 导出视频列表
     */
    @ResponseBody
    @PostMapping("video/excel")
    @RequiresPermissions("video:export")
    @ControllerEndpoint(operation = "导出视频列表", exceptionMessage = "导出Excel失败")
    public void export(QueryRequest queryRequest, Video video, HttpServletResponse response) {
        List<Video> videos = this.videoService.findVideos(queryRequest, video).getRecords();
        ExcelKit.$Export(Video.class, response).downXlsx(videos, false);
    }

    /**
     * @param id 视频状态id
     * @return
     * @description 下架视频
     */
    @ResponseBody
    @GetMapping("updateByIdSatus")
    @ControllerEndpoint(operation = "修改成功", exceptionMessage = "修改失败")
    public FebsResponse updateByIdSatus(int id) {
        log.debug("视频状态id：" + id);
        this.videoService.updateByIdSatus(id);
        return new FebsResponse().success();
    }

    /**
     * @param id 视频状态id
     * @return
     * @description 上架视频
     */
    @ResponseBody
    @GetMapping("updateByIdSatusUp")
    @ControllerEndpoint(operation = "修改成功", exceptionMessage = "修改失败")
    public FebsResponse updateByIdSatusUp(int id) {
        log.debug("视频状态id：" + id);
        this.videoService.updateByIdSatusUp(id);
        return new FebsResponse().success();
    }

    /**
     * @param id    视频id
     * @param sort  视频位次
     * @param sort1 调整到位次
     * @return
     * @description 更改视频次序
     */
    @ResponseBody
    @GetMapping("updateBySort")
    @ControllerEndpoint(operation = "修改成功", exceptionMessage = "无效的序号")
    public FebsResponse updateBySort(int id, int sort, Integer sort1) {
        log.debug("视频id：" + id + "视频位次：" + sort + "调整到位次：" + sort1);
        if (sort1 == null) {
            return new FebsResponse().fail();
        }
        boolean flag = this.videoService.updateBySort(id, sort, sort1);
        if (flag) {
            return new FebsResponse().success();
        } else {
            return new FebsResponse().fail().message("不能与自身交换");
        }
    }

    /**
     * @param videoname 视频名称
     * @return
     * @description 检查视频是否存在
     */
    @ResponseBody
    @GetMapping("check")
    public boolean checkVideoName(String videoname) {
        log.debug("视频名称：" + videoname);
        return videoService.checkVideoName(videoname);
    }

    /**
     * @param videoname 视频名称
     * @param videoid   视频id
     * @return
     * @description 查找某视频名称是否存在-更新
     */
    @ResponseBody
    @GetMapping("checkupdate")
    public boolean checkVideoNameUpdate(String videoname, Integer videoid) {
        log.debug("视频名称：" + videoname + ",视频id：" + videoid);
        return videoService.checkVideoNameUpdate(videoname, videoid);
    }
}
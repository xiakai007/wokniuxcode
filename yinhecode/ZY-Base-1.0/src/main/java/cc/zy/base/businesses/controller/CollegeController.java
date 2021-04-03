package cc.zy.base.businesses.controller;

import cc.zy.base.businesses.entity.*;
import cc.zy.base.businesses.service.ICollegeService;
import cc.zy.base.common.annotation.ControllerEndpoint;
import cc.zy.base.common.controller.BaseController;
import cc.zy.base.common.entity.FebsConstant;
import cc.zy.base.common.entity.FebsResponse;
import cc.zy.base.common.entity.QueryRequest;
import cc.zy.base.common.exception.FebsException;
import cc.zy.base.common.utils.FebsUtil;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.wuwenze.poi.ExcelKit;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import net.sf.json.JSONArray;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Controller
 *
 * @author Jiangjinlin
 * @date 2021-01-18 10:51:13
 */
@Slf4j
@Validated
@Controller
@RequiredArgsConstructor
@RequestMapping("college")
public class CollegeController extends BaseController {
    @Resource
    private final ICollegeService collegeService;

    @GetMapping(FebsConstant.VIEW_BUS_PREFIX + "college")
    public String collegeIndex() {
        return FebsUtil.BusinessView("college/college");
    }

    @GetMapping("list")
    @ResponseBody
    @RequiresPermissions("college:view")
    public FebsResponse collegeList(QueryRequest request, College college) {
        log.debug("前台传来的对象是：" + college);
        Map<String, Object> dataTable = getDataTable(this.collegeService.findColleges(request, college));
        return new FebsResponse().success().data(dataTable);
    }

    @PostMapping("add")
    @ResponseBody
    @ControllerEndpoint(operation = "新增院校", exceptionMessage = "新增院校异常")
    public FebsResponse addCollege(@Valid College college) {
        log.info("前台传来的图片地址为+" + college.getImgurl());
        college.setCreateuserid(FebsUtil.getCurrentUser().getUserId());
        this.collegeService.createCollege(college);
        return new FebsResponse().success();
    }

    @PostMapping("collegeImgUpload")
    @ResponseBody
    @ControllerEndpoint(operation = "上传院校签章", exceptionMessage = "上传院校签章失败")
    public FebsResponse collegeImgUpload(@RequestParam("file") MultipartFile multipartFile) {

        if (multipartFile != null && multipartFile.getSize() > 0) {
            String filename = multipartFile.getOriginalFilename();
            String suffix = filename.substring(filename.lastIndexOf(".") + 1);
            String realPath = "D:\\\\info\\\\collegeImg\\\\" + new Date().getTime() + "." + suffix;
            File newfile = new File(realPath);
            try {
                multipartFile.transferTo(newfile);
                return new FebsResponse().message(realPath);
            } catch (IOException e) {
                e.printStackTrace();
                return new FebsResponse().message("上传院校签章失败");
            }

        } else {
            return new FebsResponse().message("上传院校签章,文件为空");
        }
    }

    @GetMapping("delete/{collegeIds}")
    @ControllerEndpoint(operation = "删除院校", exceptionMessage = "删除院校异常")
    @ResponseBody
    public FebsResponse deleteColleges(@NotBlank(message = "{required}") @PathVariable String collegeIds) {
        String[] ids = collegeIds.split(StringPool.COMMA);
        this.collegeService.deleteColleges(ids);
        return new FebsResponse().success();
    }

    @PostMapping("update")
    @ControllerEndpoint(operation = "修改院校", exceptionMessage = "修改院校信息异常")
    @ResponseBody
    public FebsResponse updateCollege(@Valid College college) {
        log.debug("修改院校id：" + college.getId());
        if (college.getId() == null) {
            throw new FebsException("院校ID为空");
        }
        college.setUpdateuserid(FebsUtil.getCurrentUser().getUserId());
        this.collegeService.updateCollege(college);
        return new FebsResponse().success();
    }


    @GetMapping("excel")
    @ControllerEndpoint(exceptionMessage = "导出Excel异常")
    public void export(HttpServletResponse response, College college) {
        log.debug("");
        List<College> colleges = this.collegeService.findCollageListNotPage(college);
        ExcelKit.$Export(College.class, response).downXlsx(colleges, false);
    }

    @GetMapping("findCollageListNotPage")
    @ResponseBody
    public FebsResponse findCollageListNotPage() {
        List<College> collageListNotPage = collegeService.findCollageListNotPage(null);
        return new FebsResponse().success().data(collageListNotPage);
    }

    /**
     * @return
     * @Description: 查询所有的院校
     * @author jiangjinlin
     * @date 2021-02-19 11:52:14
     */
    @GetMapping("findCollageListToJosn")
    @ResponseBody
    public String findCollageListToJosn() {

        List<College> Colleges = collegeService.findCollageListNotPage(new College());
        JSONArray obj = JSONArray.fromObject(Colleges);
        if (obj != null) {
            return obj.toString();
        } else {
            return "";
        }
    }

    /**
     * @return
     * @Description: 查询所有的院校
     * @author jiangjinlin
     * @date 2021-02-19 11:52:14
     */
    @GetMapping("findCollageToJosn")
    @ResponseBody
    public String findCollageToJosn() {

        College college = new College();
        college.setId(1);
        college.setName("西安交通大学");
        List<College> Colleges = collegeService.findCollageListNotPage(college);
        JSONArray obj = JSONArray.fromObject(Colleges);
        if (obj != null) {
            return obj.toString();
        } else {
            return "";
        }
    }

    /**
     * @param collegeId 院校id
     * @Description 查找院校简称
     * @author houweikang
     * @date 2021/2/3
     */
    @GetMapping("findById/{collegeId}")
    @ResponseBody
    public FebsResponse findById(@PathVariable Integer collegeId) {
        College college = this.collegeService.findById(collegeId);
        return new FebsResponse().success().data(college);
    }

    /**
     * @Description: 所有有效批次
     * @return: data：批次集合
     * @author: LiPeng
     * @date: 2021/2/1
     */
    @ResponseBody
    @GetMapping("batchSelect")
    public FebsResponse findBatchForSelect() {
        List<Batch> batchList = this.collegeService.findBatchForSelect();
        log.debug("查询到的结果-批次集合：" + batchList);
        return new FebsResponse().success().data(batchList);
    }

    /**
     * @Description: 所有院校
     * @return: data：院校集合
     * @author: LiPeng
     * @date: 2021/2/1
     */
    @ResponseBody
    @GetMapping("collegeSelect")
    public FebsResponse findCollegeForSelect() {
        List<College> collegeList = this.collegeService.findCollegeForSelect();
        log.debug("查询到的结果-院校集合：" + collegeList);
        return new FebsResponse().success().data(collegeList);
    }

    /**
     * @Description: 根据院校id查询层次
     * @Param: collegeId 院校id
     * @return: data：层次集合
     * @author: LiPeng
     * @date: 2021/2/1
     */
    @ResponseBody
    @GetMapping("levelSelect")
    public FebsResponse findLevelForSelect(Integer collegeId) {
        log.info("院校id：" + collegeId);
        List<Level> levelList = this.collegeService.findLevelForSelect(collegeId);
        log.debug("根据院校id查询到的层次集合：" + levelList);
        return new FebsResponse().success().data(levelList);
    }

    /**
     * @Description: 根据院校id、层次id查询专业
     * @Param: collegeId 院校id；levelId 层次id
     * @return: data：专业集合
     * @author: LiPeng
     * @date: 2021/2/1
     */
    @ResponseBody
    @GetMapping("majorSelect")
    public FebsResponse findMajorForSelect(Integer collegeId, Integer levelId) {
        log.info("院校id：" + collegeId + "，层次id：" + levelId);
        List<Major> majorList = this.collegeService.findMajorForSelect(collegeId, levelId);
        log.debug("根据院校id和层次id查询到的专业集合：" + majorList);
        return new FebsResponse().success().data(majorList);
    }

    /**
     * @description: 查询所有学习形式
     * @return: data：学习形式集合
     * @author: LiPeng
     * @date: 2021/3/4
     */
    @ResponseBody
    @GetMapping("studyTypeSelect")
    public FebsResponse findStudyTypeForSelect() {
        List<Dic> studyTypeList = this.collegeService.findStudyTypeForSelect();
        log.debug("查询到的学习形式集合：" + studyTypeList);
        return new FebsResponse().success().data(studyTypeList);
    }

    /**
     * 增加功能中，查询前台输入的全称或简称是否存在
     *
     * @param name
     * @param simplename
     * @return Boolean false为重复
     * true为不重复
     */
    @GetMapping("isRepetitive")
    @ResponseBody
    public Boolean isRepetitive(String name, String simplename) {
        return this.collegeService.isRepetitive(name, simplename);
    }
}
package com.isoftstone.humanresources.controller;

import com.github.pagehelper.PageInfo;
import com.isoftstone.humanresources.domain.GroupActivities;
import com.isoftstone.humanresources.domain.Result;
import com.isoftstone.humanresources.domain.Suggest;
import com.isoftstone.humanresources.domain.gather.*;
import com.isoftstone.humanresources.service.*;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/hr_manager/gather")
@Api(value = "融合管理API")
public class GatherController {
    private final static Logger logger = LoggerFactory.getLogger(GatherController.class);

    @Autowired
    private SuggestService suggestService;

    @Autowired
    private GroupActivitiesService groupActivitiesService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private ZanService zanService;

    @Autowired
    private KmsService kmsService;

    @Autowired
    private DepartmentNewsService departmentNewsService;

    @Autowired
    private NoticeService noticeService;

    /**
     * 新增意见建议信息
     * @param suggest
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/add_suggest", method = RequestMethod.POST)
    public ResponseEntity<Result> addSuggest(@RequestBody Suggest suggest) {
        if(null == suggest ){
             return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Result result = new Result();
        try {
            Integer saveNum = suggestService.save(suggest);
            if ( 1 > saveNum) {
                result.setSuccess(false);
                result.setMessage("问卷调查信息添加异常，请重试！");
                return new ResponseEntity<>(result, HttpStatus.FAILED_DEPENDENCY);
            }
        } catch (Exception e) {
            logger.error("问卷调查信息新增异常", e);
            result.setSuccess(false);
            result.setMessage("问卷信息添加异常，请重试！");
            return new ResponseEntity<>(result, HttpStatus.BAD_GATEWAY);
        }
        result.setSuccess(true);
        result.setMessage("问卷信息添加成功！感谢你对我们工作的支持！");
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    /**
     * 新增风采展示信息
     * @param groupActivities
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/add_group_activities", method = RequestMethod.POST)
    public ResponseEntity<Result> addGroupActivities(@RequestBody GroupActivities groupActivities) {
        if(null == groupActivities ){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Result result = new Result();
        try {
            Integer saveNum = groupActivitiesService.save(groupActivities);
            if ( 1 > saveNum) {
                result.setSuccess(false);
                result.setMessage("风采展示信息添加异常，请重试！");
                return new ResponseEntity<>(result, HttpStatus.FAILED_DEPENDENCY);
            }
        } catch (Exception e) {
            logger.error("风采展示信息新增异常", e);
            result.setSuccess(false);
            result.setMessage("添加异常，请重试！");
            return new ResponseEntity<>(result, HttpStatus.BAD_GATEWAY);
        }
        result.setSuccess(true);
        result.setMessage("风采展示信息添加成功！");
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 修改风采展示信息
     * @param groupActivities
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/update_group_activities", method = RequestMethod.POST)
    public ResponseEntity<Result> updateGroupActivities(@RequestBody GroupActivities groupActivities) {
        if(null == groupActivities || null == groupActivities.getId()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Result result = new Result();
        try {
            Integer saveNum = groupActivitiesService.edit(groupActivities);
            if ( 1 > saveNum) {
                result.setSuccess(false);
                result.setMessage("修改异常，请重试！");
                return new ResponseEntity<>(result, HttpStatus.FAILED_DEPENDENCY);
            }
        } catch (Exception e) {
            logger.error("修改风采展示信息异常", e);
            result.setSuccess(false);
            result.setMessage("修改异常，请重试！");
            return new ResponseEntity<>(result, HttpStatus.BAD_GATEWAY);
        }
        result.setSuccess(true);
        result.setMessage("修改成功！");
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 风采展示列表查询
     * @param groupActivities
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/query_group_activities", method = RequestMethod.POST)
    public ResponseEntity<List<GroupActivities>> queryGroupActivities(@RequestBody GroupActivities groupActivities) {
        List<GroupActivities> groupActivitiesList = null;
        try {
            groupActivitiesList = groupActivitiesService.queryListGroupActivities(groupActivities , null);
        } catch (Exception e) {
            logger.error("获取风采展示信息异常", e);
        }
        return new ResponseEntity<>(groupActivitiesList, HttpStatus.OK);
    }

    /**
     * 风采展示列表查询,分页
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/query_page_group_activities", method = RequestMethod.GET)
    public ResponseEntity<PageInfo<GroupActivities>> queryPageGroupActivities(@RequestParam Integer page,@RequestParam Integer pageSize) {
        PageInfo<GroupActivities> groupActivitiesList = null;
        try {
            groupActivitiesList = groupActivitiesService.queryGroupActivitiesPage(page , pageSize);
        } catch (Exception e) {
            logger.error("获取风采展示信息异常", e);
        }
        return new ResponseEntity<>(groupActivitiesList, HttpStatus.OK);
    }

    /**
     * 获取单个风采展示信息
     * @param id
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/query_single_group_activities", method = RequestMethod.GET)
    public ResponseEntity<GroupActivities> querySingleGroupActivities(@RequestParam(name="ID") Integer id) {
        GroupActivities groupActivities = null;
        if (null == id) {
            logger.error("request param is null !");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            groupActivities = groupActivitiesService.querySingleGroupActivities(id);
        } catch (Exception e) {
            logger.error("获取风采展示信息异常", e);
        }
        return new ResponseEntity<>(groupActivities, HttpStatus.OK);
    }

    /**
     * 删除风采展示
     * @param ID
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/delete_group_activities", method = RequestMethod.DELETE)
    public ResponseEntity<Result> deleteGa(@RequestParam("ID") Integer ID) {
        Result result= new Result();
        try {
            if (null == ID) {
                logger.error("request param is null !");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            //调用删除员工风险接口查询用户列表
            int delNum = groupActivitiesService.removeGroupActivitiesById( ID);
            if (1 > delNum) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("删除员工风险异常", e);
            return new ResponseEntity<>(result, HttpStatus.BAD_GATEWAY);
        }
        logger.info("- - -删除员工风险的结果- - -{}", result);
        result.setSuccess(true);
        result.setMessage("删除成功！");
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * -----------------------------------------------------------
     * 评论
     * -----------------------------------------------------------
     */

    /**
     * 新增评论信息
     * @param commentModel
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/add_comment", method = RequestMethod.POST)
    public ResponseEntity<Result> addComment(@RequestBody CommentModel commentModel) {
        if(null == commentModel ){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Result result = new Result();
        try {
            Integer saveNum = commentService.save(commentModel);
            if ( 1 > saveNum) {
                result.setSuccess(false);
                result.setMessage("添加评论异常，请重试！");
                return new ResponseEntity<>(result, HttpStatus.FAILED_DEPENDENCY);
            }
        } catch (Exception e) {
            logger.error("新增评论信息异常", e);
            result.setSuccess(false);
            result.setMessage("添加评论异常，请重试！");
            return new ResponseEntity<>(result, HttpStatus.BAD_GATEWAY);
        }
        result.setSuccess(true);
        result.setMessage("添加评论成功！");
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    /**
     * 新增点赞信息
     * @param zanModel
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/add_zan", method = RequestMethod.POST)
    public ResponseEntity<Result> addZan(@RequestBody ZanModel zanModel) {
        if(null == zanModel ){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Result result = new Result();
        try {
            Integer saveNum = zanService.save(zanModel);
            if ( 1 > saveNum) {
                result.setSuccess(false);
                result.setMessage("添加异常，请重试！");
                return new ResponseEntity<>(result, HttpStatus.FAILED_DEPENDENCY);
            }
        } catch (Exception e) {
            logger.error("新增风采展示信息异常", e);
            result.setSuccess(false);
            result.setMessage("添加异常，请重试！");
            return new ResponseEntity<>(result, HttpStatus.BAD_GATEWAY);
        }
        result.setSuccess(true);
        result.setMessage("添加成功！");
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    /**
     * 删除点赞
     * @param ID
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/delete_zan", method = RequestMethod.DELETE)
    public ResponseEntity<Result> deleteZan(@RequestParam("ID") Long ID) {
        Result result= new Result();
        try {
            if (null == ID) {
                logger.error("request param is null !");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            //调用删除员工风险接口查询用户列表
            int delNum = zanService.removeZanById(ID);
            if (1 > delNum) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("删除点赞异常", e);
            return new ResponseEntity<>(result, HttpStatus.BAD_GATEWAY);
        }
        logger.info("- - -删除点赞的结果- - -{}", result);
        result.setSuccess(true);
        result.setMessage("删除成功！");
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * -----------------------------------------------------------
     * 知识管理
     * -----------------------------------------------------------
     */

    /**
     * 新增知识管理信息
     * @param kmsModel
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/add_kms", method = RequestMethod.POST)
    public ResponseEntity<Result> addKms(@RequestBody KmsModel kmsModel) {
        if(null == kmsModel ){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Result result = new Result();
        try {
            Integer saveNum = kmsService.save(kmsModel);
            if ( 1 > saveNum) {
                result.setSuccess(false);
                result.setMessage("添加异常，请重试！");
                return new ResponseEntity<>(result, HttpStatus.FAILED_DEPENDENCY);
            }
        } catch (Exception e) {
            logger.error("新增知识管理信息异常", e);
            result.setSuccess(false);
            result.setMessage("添加异常，请重试！");
            return new ResponseEntity<>(result, HttpStatus.BAD_GATEWAY);
        }
        result.setSuccess(true);
        result.setMessage("添加成功！");
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 修改知识管理信息
     * @param kmsModel
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/update_kms", method = RequestMethod.POST)
    public ResponseEntity<Result> updateKms(@RequestBody KmsModel kmsModel) {
        if(null == kmsModel || null == kmsModel.getId()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Result result = new Result();
        try {
            Integer saveNum = kmsService.edit(kmsModel);
            if ( 1 > saveNum) {
                result.setSuccess(false);
                result.setMessage("修改异常，请重试！");
                return new ResponseEntity<>(result, HttpStatus.FAILED_DEPENDENCY);
            }
        } catch (Exception e) {
            logger.error("修改知识管理信息异常", e);
            result.setSuccess(false);
            result.setMessage("修改异常，请重试！");
            return new ResponseEntity<>(result, HttpStatus.BAD_GATEWAY);
        }
        result.setSuccess(true);
        result.setMessage("修改成功！");
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 知识管理列表查询
     * @param kmsModel
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/query_kms", method = RequestMethod.POST)
    public ResponseEntity<List<KmsModel>> queryKms(@RequestBody KmsModel kmsModel) {
        List<KmsModel> kmsModelList = null;
        try {
            kmsModelList = kmsService.queryListKms(kmsModel , null);
        } catch (Exception e) {
            logger.error("获取知识管理信息异常", e);
        }
        return new ResponseEntity<>(kmsModelList, HttpStatus.OK);
    }

    /**
     * 知识管理列表查询,分页
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/query_page_kms", method = RequestMethod.GET)
    public ResponseEntity<PageInfo<KmsModel>> queryPageKmsModel(@RequestParam Integer page,@RequestParam Integer pageSize) {
        PageInfo<KmsModel> kmsModelPageInfo = null;
        try {
            kmsModelPageInfo = kmsService.querykmsPage(page , pageSize);
        } catch (Exception e) {
            logger.error("获取知识管理信息异常", e);
        }
        return new ResponseEntity<>(kmsModelPageInfo, HttpStatus.OK);
    }

    /**
     * 获取单个知识管理信息
     * @param id
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/query_single_kms", method = RequestMethod.GET)
    public ResponseEntity<KmsModel> querySingleKms(@RequestParam(name="ID") Long id) {
        KmsModel kmsModel = null;
        if (null == id) {
            logger.error("request param is null !");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            kmsModel = kmsService.queryKmsById(id);
        } catch (Exception e) {
            logger.error("获取知识管理信息异常", e);
        }
        return new ResponseEntity<>(kmsModel, HttpStatus.OK);
    }

    /**
     * 删除知识管理
     * @param ID
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/delete_kms", method = RequestMethod.DELETE)
    public ResponseEntity<Result> deleteKms(@RequestParam("ID") Long ID) {
        Result result= new Result();
        try {
            if (null == ID) {
                logger.error("request param is null !");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            //调用删除员工风险接口查询用户列表
            int delNum = kmsService.removeKmsById( ID);
            if (1 > delNum) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("删除知识管理异常", e);
            return new ResponseEntity<>(result, HttpStatus.BAD_GATEWAY);
        }
        logger.info("- - -删除知识管理的结果- - -{}", result);
        result.setSuccess(true);
        result.setMessage("删除成功！");
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * -----------------------------------------------------------
     * 新鲜事
     * -----------------------------------------------------------
     */

    /**
     * 新增新鲜事信息
     * @param departmentNewsModel
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/add_department_news", method = RequestMethod.POST)
    public ResponseEntity<Result> addDepartmentNews(@RequestBody DepartmentNewsModel departmentNewsModel) {
        if(null == departmentNewsModel ){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Result result = new Result();
        try {
            Integer saveNum =  departmentNewsService.save(departmentNewsModel);
            if ( 1 > saveNum) {
                result.setSuccess(false);
                result.setMessage("添加异常，请重试！");
                return new ResponseEntity<>(result, HttpStatus.FAILED_DEPENDENCY);
            }
        } catch (Exception e) {
            logger.error("新增新鲜事信息异常", e);
            result.setSuccess(false);
            result.setMessage("添加异常，请重试！");
            return new ResponseEntity<>(result, HttpStatus.BAD_GATEWAY);
        }
        result.setSuccess(true);
        result.setMessage("添加成功！");
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 修改知识管理信息
     * @param departmentNewsModel
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/update_department_news", method = RequestMethod.POST)
    public ResponseEntity<Result> updateDepartmentNews(@RequestBody DepartmentNewsModel departmentNewsModel) {
        if(null == departmentNewsModel || null == departmentNewsModel.getId()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Result result = new Result();
        try {
            Integer saveNum = departmentNewsService.edit(departmentNewsModel);
            if ( 1 > saveNum) {
                result.setSuccess(false);
                result.setMessage("修改异常，请重试！");
                return new ResponseEntity<>(result, HttpStatus.FAILED_DEPENDENCY);
            }
        } catch (Exception e) {
            logger.error("修改新鲜事信息异常", e);
            result.setSuccess(false);
            result.setMessage("修改异常，请重试！");
            return new ResponseEntity<>(result, HttpStatus.BAD_GATEWAY);
        }
        result.setSuccess(true);
        result.setMessage("修改成功！");
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 新鲜事列表查询
     * @param departmentNewsModel
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/query_department_news", method = RequestMethod.POST)
    public ResponseEntity<List<DepartmentNewsModel>> queryDepartmentNews(@RequestBody DepartmentNewsModel departmentNewsModel) {
        List<DepartmentNewsModel> departmentNewsModelList = null;
        try {
            departmentNewsModelList = departmentNewsService.queryListDepartmentNews(departmentNewsModel , null);
        } catch (Exception e) {
            logger.error("获取新鲜事信息异常", e);
        }
        return new ResponseEntity<>(departmentNewsModelList, HttpStatus.OK);
    }

    /**
     * 获取单个新鲜事信息
     * @param id
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/query_single_department_news", method = RequestMethod.GET)
    public ResponseEntity<DepartmentNewsModel> querySingleDepartmentNews(@RequestParam(name="ID") Long id) {
        DepartmentNewsModel model = null;
        if (null == id) {
            logger.error("request param is null !");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            model = departmentNewsService.queryDepartmentNewsById(id);
        } catch (Exception e) {
            logger.error("获取新鲜事信息异常", e);
        }
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    /**
     * 删除新鲜事
     * @param ID
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/delete_department_news", method = RequestMethod.DELETE)
    public ResponseEntity<Result> deleteDepartmentNews(@RequestParam("ID") Long ID) {
        Result result= new Result();
        try {
            if (null == ID) {
                logger.error("request param is null !");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            //调用删除员工风险接口查询用户列表
            int delNum = departmentNewsService.removeDepartmentNewsById( ID);
            if (1 > delNum) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("删除新鲜事异常", e);
            return new ResponseEntity<>(result, HttpStatus.BAD_GATEWAY);
        }
        logger.info("- - -删除新鲜事的结果- - -{}", result);
        result.setSuccess(true);
        result.setMessage("删除成功！");
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    /**
     * -----------------------------------------------------------
     * 公告栏
     * -----------------------------------------------------------
     */

    /**
     * 公告信息列表查询
     * @param noticeModel
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/query_notice", method = RequestMethod.POST)
    public ResponseEntity<List<NoticeModel>> queryNotice(@RequestBody NoticeModel noticeModel) {
        List<NoticeModel> noticeModelList = null;
        try {
            noticeModelList = noticeService.queryListNotice(noticeModel , null);
        } catch (Exception e) {
            logger.error("获取公告信息异常", e);
        }
        return new ResponseEntity<>(noticeModelList, HttpStatus.OK);
    }

    /**
     * 获取单个公告信息
     * @param id
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/query_single_notice", method = RequestMethod.GET)
    public ResponseEntity<NoticeModel> querySingleNotice(@RequestParam(name="ID") Long id) {
        NoticeModel model = null;
        if (null == id) {
            logger.error("request param is null !");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            model = noticeService.queryNoticeById(id);
        } catch (Exception e) {
            logger.error("获取公告信息异常", e);
        }
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    /**
     * 公告信息新增
     * @param noticeModel
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/add_notice", method = RequestMethod.POST)
    public ResponseEntity<Result> addNotice(@RequestBody NoticeModel noticeModel) {
        if(null == noticeModel ){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Result result = new Result();
        try {
            Integer saveNum = noticeService.save(noticeModel);
            if ( 1 > saveNum) {
                result.setSuccess(false);
                result.setMessage("公告信息添加异常，请重试！");
                return new ResponseEntity<>(result, HttpStatus.FAILED_DEPENDENCY);
            }
        } catch (Exception e) {
            logger.error("公告信息新增异常", e);
            result.setSuccess(false);
            result.setMessage("公告信息添加异常，请重试！");
            return new ResponseEntity<>(result, HttpStatus.BAD_GATEWAY);
        }
        result.setSuccess(true);
        result.setMessage("公告信息添加成功！");
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 删除公告信息
     * @param ID
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/delete_notice", method = RequestMethod.DELETE)
    public ResponseEntity<Result> deleteNotice(@RequestParam("id") Integer ID) {
        Result result= new Result();
        try {
            if (null == ID) {
                logger.error("request param is null !");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            //调用删除员工风险接口查询用户列表
            int delNum = noticeService.removeNoticeById( ID);
            if (1 > delNum) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("删除公告异常", e);
            return new ResponseEntity<>(result, HttpStatus.BAD_GATEWAY);
        }
        result.setSuccess(true);
        result.setMessage("删除公告成功！");
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}

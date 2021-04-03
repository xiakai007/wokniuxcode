package com.isoftstone.humanresources.controller;

import com.isoftstone.humanresources.domain.Result;
import com.isoftstone.humanresources.domain.VisitLeavemsgModel;
import com.isoftstone.humanresources.domain.VisitModel;
import com.isoftstone.humanresources.service.VisitLeavemsgService;
import com.isoftstone.humanresources.service.VisitService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/hr_manager/visit")
@Api(value = "拜访管理API")
public class VisitController {
    private final static Logger logger = LoggerFactory.getLogger(VisitController.class);
    @Autowired
    private VisitService visitService;

    @Autowired
    private VisitLeavemsgService visitLeavemsgService;
    /**
     * 新增拜访记录信息
     * @param visitModel
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/add_visit", method = RequestMethod.POST)
    public ResponseEntity<Result> addVisit(@RequestBody VisitModel visitModel) {
        if(null == visitModel ){
             return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Result result = new Result();
        try {
            int resultNum = visitService.save(visitModel);
            if (0 == resultNum) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("新增信息异常", e);
            result.setSuccess(false);
            result.setMessage("添加异常，请重试！");
        }
        result.setSuccess(true);
        result.setMessage("添加成功！");
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    /**
     * 查询拜访记录信息
     * @param userName
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/query_all_visit", method = RequestMethod.GET)
    public ResponseEntity<List<VisitModel>> queryAllVisit(@RequestParam("userName") String userName) {
        List<VisitModel> result = new ArrayList<VisitModel>();
        try {
            result = visitService.queryListVisit(null,null);
            if (null == result) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("查询信息异常", e);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 查询拜访记录信息
     * @param ID
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/query_visit", method = RequestMethod.GET)
    public ResponseEntity<VisitModel> queryVisit(@RequestParam("ID") Long ID) {
        if(null == ID ){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        VisitModel result = new VisitModel();
        try {
            result = visitService.queryVisitById(ID);
            if (null == result) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("查询信息异常", e);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 删除拜访记录
     * @param ID
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/delete_visit", method = RequestMethod.GET)
    public ResponseEntity<Result> deleteVisit(@RequestParam("ID") Long ID) {
        Result result= new Result();
        try {
            if (null == ID) {
                logger.error("request param is null !");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            //调用删除员工风险接口查询用户列表
            int deResult = visitService.removeVisitById(ID);
            if(1==deResult){
                result.setSuccess(true);
                result.setMessage("删除成功");
            }else {
                result.setSuccess(false);
                result.setMessage("删除失败");
            }
        } catch (Exception e) {
            logger.error("删除拜访记录异常", e);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    /**
     * 新增拜访遗留问题
     * @param visitModel
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/add_visit_leavemsg", method = RequestMethod.POST)
    public ResponseEntity<Result> addVisitLeavemsg(@RequestBody VisitLeavemsgModel visitModel) {
        if(null == visitModel ){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Result result = new Result();
        try {
            int resultNum = visitLeavemsgService.save(visitModel);
            if (0 == resultNum) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("新增抽奖人信息异常", e);
            result.setSuccess(false);
            result.setMessage("添加异常，请重试！");
        }
        result.setSuccess(true);
        result.setMessage("添加成功！");
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 删除拜访遗留问题记录
     * @param ID
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/delete_visit_leavemsg", method = RequestMethod.GET)
    public ResponseEntity<Result> deleteLeavemsg(@RequestParam("ID") Long ID) {
        Result result= new Result();
        try {
            if (null == ID) {
                logger.error("request param is null !");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            int deResult = visitLeavemsgService.removeVisitLeavemsgById(ID);
            if(1==deResult){
                result.setSuccess(true);
                result.setMessage("删除成功");
            }else {
                result.setSuccess(false);
                result.setMessage("删除失败");
            }
        } catch (Exception e) {
            logger.error("删除拜访记录异常", e);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}

package com.isoftstone.humanresources.controller;

import com.isoftstone.humanresources.domain.Result;
import com.isoftstone.humanresources.domain.VisitLeavemsgModel;
import com.isoftstone.humanresources.domain.VisitModel;
import com.isoftstone.humanresources.domain.recruit.PduCostcenterModel;
import com.isoftstone.humanresources.domain.recruit.RequirementModel;
import com.isoftstone.humanresources.domain.recruit.RequirementRequest;
import com.isoftstone.humanresources.domain.recruit.UserModel;
import com.isoftstone.humanresources.service.RecruitService;
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
@RequestMapping(value = "/hr_manager/recruit")
@Api(value = "招聘管理API")
public class RecruitController {
    private final static Logger logger = LoggerFactory.getLogger(RecruitController.class);
    @Autowired
    private RecruitService recruitService;

    /**
     * 招聘管理登录
     * @param userName
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ResponseEntity<UserModel> getUserByUserNameAndPassword(@RequestParam("username") String userName, @RequestParam("password") String password) {
        UserModel model = null;
        try {
            model = recruitService.getUserByUserNameAndPassword(userName,password);
            if (null == model) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("查询信息异常", e);
        }
        return new ResponseEntity<>(model, HttpStatus.OK);
    }


    /**
     * 查询拜访记录信息
     * @param requirementRequest
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/query_requirement", method = RequestMethod.POST)
    public ResponseEntity<List<RequirementModel>> queryAllVisit(@RequestParam("pageOffset") String pageOffset, @RequestParam("pageSize") String pageSize, @RequestBody RequirementRequest requirementRequest) {
        List<RequirementModel> result = new ArrayList<RequirementModel>();
        try {
            result = recruitService.queryListRequirement(requirementRequest,  pageOffset ,  pageSize);
            if (null == result) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("查询信息异常", e);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    /**
     * 查询筛选信息
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/query_requirement_params", method = RequestMethod.GET)
    public ResponseEntity<RequirementRequest> queryVisit() {
        RequirementRequest result = new RequirementRequest();
        try {
            result = recruitService.queryDistinctParams();
            if (null == result) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("查询信息异常", e);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 查询PDU信息
     * @param pduCostcenterModel
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/query_pdu_costcenter", method = RequestMethod.POST)
    public ResponseEntity<List<String>> PduCostcenter( @RequestParam("queryParam") String queryParam,@RequestBody PduCostcenterModel pduCostcenterModel) {
        List<String> result = new ArrayList<String>();
        try {
            result = recruitService.queryPduCostcenter(queryParam,pduCostcenterModel);
            if (null == result) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("查询信息异常", e);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 新增拜访记录信息
     * @param requirementModel
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/add_requirement", method = RequestMethod.POST)
    public ResponseEntity<Result> addRequirement(@RequestBody RequirementModel requirementModel) {
        if(null == requirementModel ){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Result result = new Result();
        try {
            result = recruitService.save(requirementModel);

        } catch (Exception e) {
            logger.error("新增信息异常", e);
            result.setSuccess(false);
            result.setMessage("添加异常，请重试！");
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}

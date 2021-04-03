package com.isoftstone.humanresources.controller;

import com.github.pagehelper.PageInfo;
import com.isoftstone.humanresources.domain.*;
import com.isoftstone.humanresources.domain.recruit.CandidateModel;
import com.isoftstone.humanresources.domain.recruit.InterviewRecordModel;
import com.isoftstone.humanresources.domain.recruit.QueryCandidateRequest;
import com.isoftstone.humanresources.service.CandidateService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/hr_manager/candidate")
@Api(value = "招聘-候选人管理API")
public class CandidateController {
    private final static Logger logger = LoggerFactory.getLogger(CandidateController.class);
    @Autowired
    private CandidateService candidateService;

    /**
     * 分页查询候选人列表
     *
     * @param queryCandidateRequest
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/query_candidate", method = RequestMethod.POST)
    public ResponseEntity<PageInfo<CandidateModel>> queryUserGroup(@RequestBody QueryCandidateRequest queryCandidateRequest) {
        PageInfo<CandidateModel> candidateModelPageInfo = null;
        try {
            if (null == queryCandidateRequest) {
                logger.error("request param is null !");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            //调用查询用户接口查询用户列表
            candidateModelPageInfo = candidateService.queryCandidate(queryCandidateRequest);
            if (null == candidateModelPageInfo) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("查询用户组列表异常", e);
        }
        return new ResponseEntity<>(candidateModelPageInfo, HttpStatus.OK);
    }

    /**
     * 新增候选人信息
     *
     * @param candidateModel
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/add_candidate", method = RequestMethod.POST)
    public ResponseEntity<Result> addCandidate(@RequestBody CandidateModel candidateModel) {
        Result result = null;
        try {
            if (null == candidateModel) {
                logger.error("request param is null !");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            result = candidateService.addCandidate(candidateModel);
            if (null == result) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("新增用户组异常", e);
        }
        logger.info("- - -新增用户组结束- - -{}",result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 更新候选人信息（状态）
     *
     * @param candidateModel
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/update_candidate", method = RequestMethod.POST)
    public ResponseEntity<Result> updateCandidate(@RequestBody CandidateModel candidateModel) {
        Result result = null;
        try {
            if (null == candidateModel) {
                logger.error("request param is null !");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            result = candidateService.updateCandidate(candidateModel);
            if (null == result) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("更新用户组异常", e);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 分页查询候选人面试信息列表
     *
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/query_interview", method = RequestMethod.GET)
    public ResponseEntity<List<InterviewRecordModel>> queryUserGroup(@RequestParam(name = "userID" ) String userID,
                                                                     @RequestParam(name = "userType" ) String userType) {
        //userType : CANDIDATE 候选人面试 EMPLOYEE 员工面试
        List<InterviewRecordModel> interviewRecordModelList = null;
        try {
            if (StringUtils.isEmpty(userID)) {
                logger.error("request param is null !");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            //调用查询用户接口查询用户列表
            interviewRecordModelList = candidateService.queryListByID(userID,userType);
            if (CollectionUtils.isEmpty(interviewRecordModelList)) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("查询用户组面试信息列表异常", e);
        }
        return new ResponseEntity<>(interviewRecordModelList, HttpStatus.OK);
    }

    /**
     * 新增候选人信息
     *
     * @param interviewRecordModel
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/edit_interview", method = RequestMethod.POST)
    public ResponseEntity<Result> editInterview(@RequestBody InterviewRecordModel interviewRecordModel) {
        Result result = null;
        try {
            if (null == interviewRecordModel) {
                logger.error("request param is null !");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            result = candidateService.addInterview(interviewRecordModel);
            if (null == result) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("新增面试记录异常", e);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}

package com.isoftstone.humanresources.controller;

import com.github.pagehelper.PageInfo;
import com.isoftstone.humanresources.domain.QuerySystemLogParam;
import com.isoftstone.humanresources.domain.QueryUserRequest;
import com.isoftstone.humanresources.domain.SysLog;
import com.isoftstone.humanresources.domain.User;
import com.isoftstone.humanresources.service.SystemLogService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/hr_manager/systemlog")
@Api(value = "日志API")
public class SystemLogController {
    private final static Logger logger = LoggerFactory.getLogger(SystemLogController.class);
    @Autowired
    private SystemLogService systemLogService;
    @CrossOrigin
    @RequestMapping(value = "/query_system_log", method = RequestMethod.POST)
    public ResponseEntity<PageInfo<SysLog>> querySystemLog(@RequestBody QuerySystemLogParam querySystemLogParam) {
        logger.info("- - -查询日志列表的请求参数- - -{}", querySystemLogParam);
        PageInfo<SysLog> sysLogPageInfo  = null;
        try {
            if (null == querySystemLogParam) {
                logger.error("request param is null !");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            //调用查询用户接口查询用户列表
            sysLogPageInfo = systemLogService.queryLogList(querySystemLogParam);
            if (null == sysLogPageInfo) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("查询日志列表异常", e);
        }
        logger.info("- - -查询日志列表的结果- - -{}", sysLogPageInfo);
        return new ResponseEntity<>(sysLogPageInfo, HttpStatus.OK);
    }
}

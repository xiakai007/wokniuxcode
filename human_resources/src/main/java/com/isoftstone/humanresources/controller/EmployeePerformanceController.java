package com.isoftstone.humanresources.controller;

import com.isoftstone.humanresources.domain.Result;
import com.isoftstone.humanresources.service.EmployeePerformanceService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping(value = "/hr_manager/employeePerformance")
@Api(value = "员工绩效API")
public class EmployeePerformanceController {
    private final static Logger logger = LoggerFactory.getLogger(EmployeePerformanceController.class);
    @Autowired
    private EmployeePerformanceService employeePerformanceService;

    @CrossOrigin
    @PostMapping(path = "/importExcelEmpPer")
    public ResponseEntity<Result> importExcelEmpPer(@RequestParam("file") MultipartFile file){
        logger.info("- - -获取批量导入员工绩效信息的请求参数- - -{}",file);
        Result result=null;
        try
        {
            if (null == file) {
                logger.error("request param is null !");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            result = employeePerformanceService.importExcelEmpPer(file);
            if (null == result) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }catch (Exception e){
            logger.error("-----批量导入员工绩效信息-------", e);
        }
        logger.info("- - -批量导入员工绩效信息- - -{}", result);
        return new ResponseEntity(result, HttpStatus.OK);

    }



}

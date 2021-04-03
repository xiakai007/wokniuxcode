package com.isoftstone.humanresources.controller;

import com.isoftstone.humanresources.domain.LuckDrawModel;
import com.isoftstone.humanresources.domain.Result;
import com.isoftstone.humanresources.service.LuckDrawService;
import com.isoftstone.humanresources.service.UserService;
import com.isoftstone.humanresources.util.CommonConstant;
import com.isoftstone.humanresources.util.StringUtil;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/hr_manager/luck_draw")
@Api(value = "抽奖信息管理管理API")
public class LuckDrawController {
    private final static Logger logger = LoggerFactory.getLogger(LuckDrawController.class);
    @Autowired
    private LuckDrawService luckDrawService;
    @Autowired
    private UserService userService;

    /**
     * 查询候选抽奖人列表
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/query_employee", method = RequestMethod.GET)
    public ResponseEntity<List<LuckDrawModel>> queryLuckDrawList() {
        List<LuckDrawModel> luckDrawModelList = null;
        try {
            luckDrawModelList = luckDrawService.queryListLuckDraw(null
            ,null);
            if (null == luckDrawModelList) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("查询候选抽奖人异常", e);
        }
        return new ResponseEntity<>(luckDrawModelList, HttpStatus.OK);
    }

    /**
     * 新增抽奖候选人信息
     * @param luckDrawModel
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/add_employee", method = RequestMethod.POST)
    public ResponseEntity<Result> addEmployee(@RequestBody LuckDrawModel luckDrawModel) {
        if(null == luckDrawModel ){
             return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Result result = new Result();
        try {
            if (null == luckDrawModel) {
                logger.error("request param is null !");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            result = luckDrawService.addLuckDraw(luckDrawModel);
            if (null == result) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("新增抽奖人信息异常", e);
            result.setSuccess(false);
            result.setMessage("添加异常，请重试！");
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    /**
     * 文件上传到本地服务器
     *
     * @param file
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ResponseEntity<Map<String, String>> uploadFile(@RequestParam("file") MultipartFile file) {
        Map<String, String> map = new HashMap<>();
        try {
            if (null == file) {
                logger.error("request param is null !");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            map = userService.fileUpload(file, CommonConstant.IMG_LUCK);

            if (null == map) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("上传文件失败", e);
        }
        return new ResponseEntity(map, HttpStatus.OK);
    }

    /**
     * 删除员工风险
     * @param ID
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/delete_luck_draw", method = RequestMethod.GET)
    public ResponseEntity<Result> deleteLuckDraw(@RequestParam("ID") Long ID) {
        Result result= new Result();
        try {
            if (null == ID) {
                logger.error("request param is null !");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            //调用删除员工风险接口查询用户列表
            int deResult = luckDrawService.removeLuckDrawById(ID);
            if(1==deResult){
                result.setSuccess(true);
                result.setMessage("删除成功");
            }else {
                result.setSuccess(false);
                result.setMessage("删除失败");
            }
        } catch (Exception e) {
            logger.error("删除员工风险异常", e);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 查询员工名称相同的个数
     * @param employeeName
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/query_name_count", method = RequestMethod.GET)
    public ResponseEntity<Result> queryLuckDrawByName(@RequestParam("employeeName") String employeeName) {
        Result result= new Result();
        try {
            if (StringUtil.isEmpty(employeeName)) {
                logger.error("request param is null !");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            //调用删除员工风险接口查询用户列表
            int deResult = luckDrawService.queryLuckDrawByName(employeeName);
            result.setSuccess(true);
            result.setMessage(deResult+"");
        } catch (Exception e) {
            logger.error("删除员工风险异常", e);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}

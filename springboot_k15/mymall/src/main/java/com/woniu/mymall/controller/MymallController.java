package com.woniu.mymall.controller;

import com.github.pagehelper.PageHelper;
import com.woniu.mymall.entity.pojo.Mymall;
import com.woniu.mymall.service.MymallService;
import com.woniu.mymall.util.Constaint;
import com.woniu.mymall.util.R;
import com.woniu.mymall.util.ResultCode;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(value = "/mymall")
@CrossOrigin
@RestController
public class MymallController {
    @Autowired
    private MymallService mymallService;
    @ApiOperation(value = "获取所有商品")
    @GetMapping(value = "/getMymallAll")
    public R getMymallAll(){
        PageHelper.startPage(1,8);
        List<Mymall> mymalls = mymallService.selectMymallAll();
        if(mymalls!=null&&mymalls.size()>0){
            return R.ok().code(ResultCode.SUCCESS).message(Constaint.SUCCESS).data("mymalls",mymalls);
        }else{
            return R.error();
        }
    }
}

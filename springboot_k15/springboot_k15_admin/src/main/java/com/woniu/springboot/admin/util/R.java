package com.woniu.springboot.admin.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回码的接口
 */
@Data
@ApiModel(value="返回码的接口")
public class R {
    /**
     * 是否成功，成true败false
     */
    @ApiModelProperty(value="是否成功")
    private Boolean success;
    /**
     * 返回状态码
     */
    @ApiModelProperty(value="返回的状态码")
    private Integer code;
    /**
     * 返回的信息
     */
    @ApiModelProperty(value="返回的信息")
    private String message;
    /**
     * 返回携带的数据
     */
    @ApiModelProperty(value="返回携带的数据")
    private Map<String,Object> data=new HashMap<>();
    public static R ok(){
        R r = new R();
        r.setSuccess(true);
        r.setCode(ResultCode.SUCCESS);
        r.setMessage(Constaint.SUCCESS);
        return r;
    }
    public static R error(){
        R r = new R();
        r.setSuccess(false);
        r.setCode(ResultCode.ERROR);
        r.setMessage(Constaint.ERROR);
        return r;
    }
    public R success(Boolean success){
        this.setSuccess(success);
        return this;
    }
    public R code(Integer code){
        this.setCode(code);
        return this;
    }
    public R message(String message){
        this.setMessage(message);
        return this;
    }
    public R data(String key, Object value){
        this.data.put(key,value);
        return this;
    }
    public R data(Map<String,Object> map){
        this.setData(map);
        return this;
    }
}

package com.woniu.bootrediss.service.impl;


import com.woniu.bootrediss.controller.HttpUtils;
import com.woniu.bootrediss.service.UserService;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private RedisTemplate redisTemplate;
    @Override
    public boolean sendAuthcode(String telephone) {
        int codenum=getAuthcode();
        String code=String.valueOf(codenum);
        System.out.println("code:"+code);
        String host = "https://smssend.shumaidata.com";
        String path = "/sms/send";
        String method = "POST";
        String appcode = "96ab46eb21544012a64364a9e570f98c";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("receive", telephone);
        querys.put("tag", code);
        querys.put("templateId", "M09DD535F4");
        Map<String, String> bodys = new HashMap<String, String>();
        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            System.out.println(response.toString());
            //获取response的body
            System.out.println(EntityUtils.toString(response.getEntity()));
            redisTemplate.opsForValue().set(telephone,code,180*1000, TimeUnit.MILLISECONDS);
            System.out.println("sendAuthcode-redis:"+redisTemplate.opsForValue().get(telephone));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean isExist(String telephone, String authcode) {
        String authcodeRedis = (String)redisTemplate.opsForValue().get(telephone);
        System.out.println("authcodeRedis:"+authcodeRedis);
        if(authcodeRedis!=null&&authcode.equals(authcodeRedis)){
            return true;
        }
        return false;
    }

    private Integer getAuthcode(){
        int res=(int)((Math.random()*9+1)*100000);
        return res;
    }
}

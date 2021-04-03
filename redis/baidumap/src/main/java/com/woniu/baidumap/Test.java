package com.woniu.baidumap;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.woniu.baidumap.entity.Result;
import com.woniu.baidumap.entity.Shop;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpGet get = new HttpGet("http://api.map.baidu.com/place/v2/search?query=%E7%81%AB%E9%94%85&region=%E8%A5%BF%E5%AE%89&output=json&ak=pyWX5T57tvh36xscx61O9parWWdaqafX");
        try {
            HttpResponse response = client.execute(get);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String json = EntityUtils.toString(entity,"UTF-8");
                //System.out.println(result);
                ObjectMapper objectMapper = new ObjectMapper();
                Result result = objectMapper.readValue(json, Result.class);
                System.out.println(result);
                List<Shop> shops = result.getResults();
                for (Shop shop : shops) {
                    System.out.println(shop.getName()+"\t"+shop.getTelephone()+"\t"+shop.getAddress());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

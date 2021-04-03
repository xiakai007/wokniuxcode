package com.woniu.baidumap.controller;

import com.woniu.baidumap.entity.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.geo.*;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class NearController {
    @Autowired
    @Qualifier(value = "redisTemplate")
    private RedisTemplate redisTemplate;
    @GetMapping(value = "/near")
    public List near(String conditionname){
        List list=new ArrayList();
        Shop shop =(Shop) redisTemplate.opsForValue().get(conditionname);
        System.out.println("shop:"+shop);
        System.out.println("size:"+redisTemplate.boundZSetOps("shop").size());
        Point point = new Point(Double.parseDouble(shop.getLocation().getLng()),Double.parseDouble(shop.getLocation().getLat()));
        Metric metric = RedisGeoCommands.DistanceUnit.KILOMETERS;
        Distance distance = new Distance(50,metric);
        Circle circle = new Circle(point,distance);
        RedisGeoCommands.GeoRadiusCommandArgs args = RedisGeoCommands.GeoRadiusCommandArgs.newGeoRadiusArgs().includeDistance().includeCoordinates().sortAscending().limit(1000);
        GeoResults<RedisGeoCommands.GeoLocation<String>> radius = redisTemplate.opsForGeo().radius("shop", circle, args);
        if(radius!=null){
            radius.forEach(geoLocationGeoResult -> {
                RedisGeoCommands.GeoLocation<String> content = geoLocationGeoResult.getContent();
                String name = content.getName();
                Point poi = content.getPoint();
                Distance dis = geoLocationGeoResult.getDistance();
                Map map = new HashMap();
                map.put("name",name);
                map.put("lng",poi.getX());
                map.put("lat",poi.getY());
                map.put("dis",dis.getValue());
                list.add(map);
            });
        }
        return list;
    }
}

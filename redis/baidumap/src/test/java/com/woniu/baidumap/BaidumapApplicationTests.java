package com.woniu.baidumap;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.woniu.baidumap.entity.Result;
import com.woniu.baidumap.entity.Shop;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.geo.*;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.BoundGeoOperations;
import org.springframework.data.redis.core.GeoOperations;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class BaidumapApplicationTests {
	@Autowired
	private RedisTemplate redisTemplate;
	@Test
	void contextLoads() {
	}
	@Test
	void test1() {
		Map<String, Point> points = new HashMap<>();
		points.put("aa", new Point(114.12, 39.08));
		points.put("bb", new Point(113.2901, 38.02));
		points.put("cc", new Point(113.2902, 38.02));
		points.put("dd", new Point(113.2903, 38.02));
		points.put("ee", new Point(113.2904, 38.02));
		points.put("ff", new Point(113.2904, 38.02));
		BoundGeoOperations<String,String> geoOps = redisTemplate.boundGeoOps("shop");
		geoOps.add(points);
	}
	@Test
	public void test2(){
		//Circle对象是封装覆盖的面积，需要的要素为中心点坐标Point对象、半径（radius）、计量单位（metric）
		Point point = new Point(114.12, 39.08);
		Metric metric = RedisGeoCommands.DistanceUnit.KILOMETERS;
		Distance distance = new Distance(150, metric);
		Circle circle = new Circle(point, distance);

		//GeoRadiusCommandArgs用来封装GEORADIUS的一些可选命令参数，
		// 例如我们需要在返回结果中包含坐标、中心距离、由近到远排序的前10条数据：
		RedisGeoCommands.GeoRadiusCommandArgs args = RedisGeoCommands
				.GeoRadiusCommandArgs
				.newGeoRadiusArgs()
				.includeDistance()
				.includeCoordinates()
				.sortAscending()
				.limit(10);
		//然后执行 radius方法就会拿到GeoResults<RedisGeoCommands.GeoLocation<String>>封装的结果，
		//我们对这个可迭代对象进行解析就可以拿到我们想要的数据：
		GeoResults<RedisGeoCommands.GeoLocation<String>> radius = redisTemplate.opsForGeo()
				.radius("shop", circle, args);

		if (radius != null) {
			radius.forEach(geoLocationGeoResult -> {
				RedisGeoCommands.GeoLocation<String> content = geoLocationGeoResult.getContent();
				//member 名称  如  hn
				String name = content.getName();
				// 对应的经纬度坐标
				Point pos = content.getPoint();
				// 距离中心点的距离
				Distance dis = geoLocationGeoResult.getDistance();
				System.out.println(name+"\t"+pos+ "\t"+dis);
			});
		}
	}
	@Test
	public void testBatch(){
		GeoOperations<String, Shop> geoOperations = redisTemplate.opsForGeo();
		Map<String, Point> points = new HashMap<>();
		String s = "赵钱孙李";

		CloseableHttpClient httpClient = HttpClientBuilder.create().build();

		char[] chars = s.toCharArray();

		for (char aChar : chars) {
			for (int i = 1; i < 20; i++) {
				// 创建Get请求
				HttpGet httpGet = new HttpGet("http://api.map.baidu.com/place/v2/search?query="+aChar+"&region=西安&output=json&ak=M0toqf0247DyrGKOyMrZg1XQ&page_size=20&page_num="+i);
				// 响应模型
				CloseableHttpResponse response = null;
				try {
					// 由客户端执行(发送)Get请求
					response = httpClient.execute(httpGet);
					// 从响应模型中获取响应实体
					HttpEntity responseEntity = response.getEntity();
					System.out.println("响应状态为:" + response.getStatusLine());
					if (responseEntity != null) {
						String json = EntityUtils.toString(responseEntity);
						ObjectMapper objectMapper = new ObjectMapper();
						Result result = objectMapper.readValue(json, Result.class);
						if(result==null||result.getTotal()==0) break;
						List<Shop> results = result.getResults();
						for (Shop shop : results) {
							System.out.println(shop);
							points.put(shop.getName(), new Point(Double.parseDouble(shop.getLocation().getLng()), Double.parseDouble(shop.getLocation().getLat())));
							redisTemplate.opsForValue().set(shop.getName(), shop);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			BoundGeoOperations<String, String> geoOps = redisTemplate.boundGeoOps("shop");
			geoOps.add(points);
		}
	}
	@Test
	public void test3(){
		Shop shop = (Shop)redisTemplate.opsForValue().get("孙六村");
		System.out.println(shop);
		System.out.println(redisTemplate.boundZSetOps("shop").size());

		Point point = new Point(Double.parseDouble(shop.getLocation().getLng()), Double.parseDouble(shop.getLocation().getLat()));

		Metric metric = RedisGeoCommands.DistanceUnit.KILOMETERS;
		Distance distance = new Distance(200, metric);
		Circle circle = new Circle(point, distance);

		//GeoRadiusCommandArgs用来封装GEORADIUS的一些可选命令参数，
		// 例如我们需要在返回结果中包含坐标、中心距离、由近到远排序的前5条数据：
		RedisGeoCommands.GeoRadiusCommandArgs args = RedisGeoCommands
				.GeoRadiusCommandArgs
				.newGeoRadiusArgs()
				.includeDistance()
				.includeCoordinates()
				.sortAscending()
				.limit(1000);

		GeoResults<RedisGeoCommands.GeoLocation<String>> radius = redisTemplate.opsForGeo()
				.radius("shop", circle, args);

		if (radius != null) {
			radius.forEach(geoLocationGeoResult -> {
				RedisGeoCommands.GeoLocation<String> content = geoLocationGeoResult.getContent();
				//member 名称  如  tianjin
				String name = content.getName();
				// 对应的经纬度坐标
				Point pos = content.getPoint();
				// 距离中心点的距离
				Distance dis = geoLocationGeoResult.getDistance();
				System.out.println(name+"\t"+pos+ "\t"+dis+"=====>"+redisTemplate.opsForValue().get(name));
			});
		}

	}

}

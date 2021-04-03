package com.woniu.jd;

import com.woniu.jd.mapper.GoodsMapper;
import com.woniu.jd.pojo.entity.Goods;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class JdApplicationTests {
	@Autowired
	private GoodsMapper goodsMapper;
	@Test
	void contextLoads() {
	}
	@Test
	void test1() {
		List<Goods> goods = goodsMapper.selectGoodsAll();
		System.out.println(goods);
	}
	@Test
	void test2() {
		Goods goods = new Goods();
		goods.setName("qwer");
		BigDecimal bigDecimal = new BigDecimal(12.846);
		goods.setPrice(bigDecimal);
		goods.setShop("tyui");
		goods.setImg("lkjguuefhjsdf");
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		goods.setMarktime(timestamp);
		goods.setStatuss(1);
		goodsMapper.insertGoods(goods);
	}
	@Test
	void test3() throws Exception{
		Map<String,String> map=getMap();
		String[] goods={"电视机","手机","游戏本","耳机","羽绒服"};
		for (String good : goods) {
			for (int i = 1; i <= 100; i++) {
				String url="https://search.jd.com/Search?keyword="+good+"&wq="+good+"%AC&page="+i+"&s=116&click=0";
				addGoods(url,map);
			}
		}
	}
	private void addGoods(String url,Map<String,String> map) throws Exception{
		Document doc = Jsoup.connect(url).headers(map).get();
		Element element = doc.getElementById("J_goodsList");
		if(element==null){
			return;
		}
		Elements lis = element.getElementsByTag("li");
		Goods goodsAdd = new Goods();
		for(Element li:lis){
			try{
				String img="http:"+li.getElementsByClass("p-img").get(0).getElementsByTag("img").attr("data-lazy-img");
				System.out.println("img:"+img);
				goodsAdd.setImg(img);
				String price = li.getElementsByClass("p-price").get(0).getElementsByTag("i").text();
				System.out.println("price:"+price);
				goodsAdd.setPrice(new BigDecimal(price));
				String name = li.getElementsByClass("p-name").get(0).getElementsByTag("em").text();
				System.out.println("name:"+name);
				goodsAdd.setName(name);
				String shop = li.getElementsByClass("p-shop").get(0).getElementsByTag("a").text();
				System.out.println("shop:"+shop);
				goodsAdd.setShop(shop);
				Timestamp timestamp = new Timestamp(System.currentTimeMillis());
				System.out.println("timestamp:"+timestamp);
				goodsAdd.setMarktime(timestamp);
				goodsAdd.setStatuss(1);
				goodsMapper.insertGoods(goodsAdd);
			}catch (Exception e){
				System.out.println(e);
			}

		}
	}
	private Map<String,String> getMap(){
		Map<String,String> map=new HashMap();
		map.put("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
		map.put("Accept-encoding","gzip, deflate, br");
		map.put("Accept-Language","zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2");
		map.put("Cache-Control","max-age=0");
		map.put("Connection","keep-alive");
		map.put("Cookie","__jda=122270672.16100200534871876711919.1610020053.1610020053.1610020054.1; unpl=V2_ZzNtbUYCSx0gDURReRgIBWIKQF8SAhRHdAtFUXsfCwFkBRpaclRCFnUUR1RnGFoUZwsZWERcQRBFCEdkeBpdAWQCEFRHZ3Mldgh2VUsZWwVmAhFcQ1NBEHwORl19HloFZwsSVXJnRBV8OHYoJVIEWDpTEVxCUnMWdglCVHIbXwNXAiJdRVZFF3UNQ1R5KRdrZk4SWkJWQhZ0CUJWfhBaBW4FFVtCV0sVfThHZHg%3d; __jdb=122270672.2.16100200534871876711919|1.1610020054; __jdc=122270672; __jdv=76161171|kong|t_220520384_|tuiguang|5d99d43430e148c3adfc022417f52796|1610020054126; __jdu=16100200534871876711919; areaId=27; ipLoc-djd=27-2376-50230-0; PCSYCityID=CN_610000_610100_610112; shshshfp=fc0e793923dd6b658913a5534e69e5e2; shshshfpa=6835290a-e1c2-e07c-70c2-d7999af2994d-1610020058; shshshsID=ea9c3146b9c01ea85deaf0737a33a901_2_1610020063014; shshshfpb=kWTWmg15vz%2FMhh3F5d73%2FUg%3D%3D; qrsc=1; rkv=1.0; 3AB9D23F7A4B3C9B=AY3IVZXCPEWXRZO6NVYJJX2JMPS6UWIRTEXPYA567W35KJX2WH6X4QISXXT5BMDS3PLY77N65TAMBAXH4EGSA3FYJI");
		map.put("content-type","text/html;charset=utf-8");
		map.put("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:84.0) Gecko/20100101 Firefox/84.0");
		return map;
	}
}

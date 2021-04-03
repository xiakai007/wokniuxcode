package com.woniu.smartremind;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.woniu.smartremind.mbg.mapper.CrimeMapper;
import com.woniu.smartremind.mbg.model.Crime;
import com.woniu.smartremind.uitl.ToPinyin;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;

@SpringBootTest
class SmartremindApplicationTests {
	@Autowired
	private CrimeMapper crimeMapper;
	@Autowired
	private RestHighLevelClient client;
	@Test
	void contextLoads() {
	}
	@Test
	void test1(){
		List<Crime> crimes = crimeMapper.selectByExample(null);
		System.out.println(crimes);
	}
	@Test
	void test2()throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				new FileInputStream("d:/crime.txt")
		));
		String msg=null;
		while ((msg=reader.readLine())!=null){
			if(!msg.trim().equals("")){
				for (int i = 0; i < 10; i++) {
					msg=msg.replaceAll(i+"","");
				}
				msg=msg.replaceAll("第条","");
				msg=msg.replaceAll("第款","");
				msg=msg.replaceAll("刑法","");
				msg=msg.replaceAll("同上","");
				msg=msg.replaceAll("、","");
				try{
					Crime crime = new Crime();
					String simplecode= ToPinyin.getSimpleCode(msg);
					String fullcode=ToPinyin.getFullCode(msg);
					crime.setCrime(msg);
					crime.setSimplecode(simplecode);
					crime.setFullcode(fullcode);
					System.out.println("INSERT INTO crime VALUES(null,'"+msg+"','"+simplecode+"','"+fullcode+"');");
					crimeMapper.insert(crime);
				}catch (Exception e){
				}
			}
		}
	}
	@Test
	void test3()throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				new FileInputStream("d:/crime.txt")
		));
		String msg=null;
		BulkRequest bulkRequest = new BulkRequest();
		while ((msg=reader.readLine())!=null){
			if(!msg.trim().equals("")){
				for (int i = 0; i < 10; i++) {
					msg=msg.replaceAll(i+"","");
				}
				msg=msg.replaceAll("第条","");
				msg=msg.replaceAll("第款","");
				msg=msg.replaceAll("刑法","");
				msg=msg.replaceAll("同上","");
				msg=msg.replaceAll("、","");
				try{
					Crime crime = new Crime();
					String simplecode= ToPinyin.getSimpleCode(msg);
					String fullcode=ToPinyin.getFullCode(msg);
					crime.setCrime(msg);
					crime.setSimplecode(simplecode);
					crime.setFullcode(fullcode);
					String crimeJ = new ObjectMapper().writeValueAsString(crime);
					bulkRequest.add(new IndexRequest("crime").source(crimeJ, XContentType.JSON));
				}catch (Exception e){
					e.printStackTrace();
				}
			}
		}
		client.bulk(bulkRequest, RequestOptions.DEFAULT);
	}
	@Test
	void test4()throws Exception{
		SearchRequest searchRequest = new SearchRequest("crime");
		String crime="daoqie";
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
		boolQueryBuilder.should(QueryBuilders.matchQuery("crime",crime));
		boolQueryBuilder.should(QueryBuilders.matchPhraseQuery("simeplecode",crime));
		boolQueryBuilder.should(QueryBuilders.matchPhraseQuery("fullcode",crime));
		boolQueryBuilder.minimumShouldMatch(1);
		searchSourceBuilder.query(boolQueryBuilder);
		searchRequest.source(searchSourceBuilder);
		SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
		SearchHits hits = response.getHits();
		for (SearchHit hit : hits) {
			System.out.println(hit.getSourceAsMap());
		}
	}
}

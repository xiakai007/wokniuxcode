package com.woniu.es;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.woniu.es.entity.Student;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class EsApplicationTests {
	@Autowired
	private RestHighLevelClient restHighLevelClient;

	@Test
	void contextLoads() {
	}
	@Test
	void createIndex() throws IOException{
		CreateIndexRequest request = new CreateIndexRequest("student");
		CreateIndexResponse response = restHighLevelClient.indices().create(request, RequestOptions.DEFAULT);
		System.out.println(response);
	}
	@Test
	void getIndex() throws IOException{
		GetIndexRequest request = new GetIndexRequest("student");
		boolean exists = restHighLevelClient.indices().exists(request, RequestOptions.DEFAULT);
		System.out.println(exists);
	}
	@Test
	void deleteIndex() throws IOException{
		DeleteIndexRequest request = new DeleteIndexRequest("student");
		AcknowledgedResponse delete = restHighLevelClient.indices().delete(request, RequestOptions.DEFAULT);
		System.out.println(delete);
	}
	@Test
	void createDoc() throws IOException{
		IndexRequest indexRequest = new IndexRequest("student");
		indexRequest.id("1");
		indexRequest.timeout(TimeValue.timeValueSeconds(1));
		Student student = new Student();
		student.setName("tom");
		student.setAge(18);
		student.setAddress("西安");
		String json = new ObjectMapper().writeValueAsString(student);
		indexRequest.source(json,XContentType.JSON);
		IndexResponse response = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
		System.out.println(response);
	}
	@Test
	void isStudent() throws IOException{
		GetRequest request = new GetRequest("student", "1");
		boolean exists = restHighLevelClient.exists(request, RequestOptions.DEFAULT);
		System.out.println(exists);
	}
	@Test
	void searchUserinfo() throws IOException{

	}
}

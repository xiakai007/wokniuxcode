package com.woniu.jd.controller;

import com.woniu.jd.util.PageBean;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/goods")
public class GoodsControllerPageBean {
    @Autowired
    private RestHighLevelClient client;
    @GetMapping(value = "/searchGoodsMap")
    public Map searchGoods(String name, Integer priceGte, Integer priceLte, PageBean pageBean) throws Exception{
        Map results =new HashMap();
        if(pageBean==null){
            pageBean=new PageBean();
        }
        List list=new ArrayList();
        SearchRequest request = new SearchRequest("goods");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.from(pageBean.getFrom());
        searchSourceBuilder.size(pageBean.getSize());
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        boolQueryBuilder.must(QueryBuilders.matchQuery("name",name));
        if(priceGte!=null&&priceGte>=0&&priceGte<=priceLte){
            boolQueryBuilder.must(QueryBuilders.rangeQuery("price").gte(priceGte));
        }
        if(priceLte!=null&&priceLte>=priceGte){
            boolQueryBuilder.must(QueryBuilders.rangeQuery("price").lte(priceLte));
        }
        searchSourceBuilder.query(boolQueryBuilder);
        request.source(searchSourceBuilder);
        SearchResponse searchResponse = client.search(request, RequestOptions.DEFAULT);
        long count=searchResponse.getHits().getTotalHits().value;
        pageBean.setCount(new Long(count).intValue());
        System.out.println("总记录数："+count);
        SearchHits hits = searchResponse.getHits();
        for (SearchHit hit : hits) {
            Map<String, Object> sourceAsMap = hit.getSourceAsMap();
            list.add(sourceAsMap);
        }
        results.put("pageBean",pageBean);
        results.put("list",list);
        return results;
    }
}

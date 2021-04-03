package com.woniu.providers;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.woniu.bean.pojo.Goods;

public class GoodsProvider {
	public String selectDynamicSqlByGoods(Goods goods){
		return new SQL(){
			{
				SELECT("*");
				FROM("mall_goods");
				StringBuilder sb=new StringBuilder();
				String name=goods.getName();
				String author=goods.getAuthor();
				String publisher=goods.getPublisher();
				if(name!=null&&!name.equals("")){
					sb.append("AND name LIKE'%").append(name).append("%'");
				}
				if(author!=null&&!author.equals("")){
					sb.append("AND author LIKE'%").append(author).append("%'");
				}
				if(publisher!=null&&!publisher.equals("")){
					sb.append("AND publisher LIKE'%").append(publisher).append("%'");
				}
				if(!"".equals(sb.toString())){
					WHERE(sb.toString().replaceFirst("AND", "")); 
				}
			}
		}.toString();
	}
	public String updateDynamicSql(Goods goods){
		return new SQL(){
			{
				UPDATE("mall_goods");
				StringBuilder sbu=new StringBuilder();
				Integer id=goods.getId();
				String name=goods.getName();
				String author=goods.getAuthor();
				String publisher=goods.getPublisher();
				if(name!=null&&!name.equals("")){
					sbu.append("name='").append(name).append("',");
				}
				if(author!=null&&!author.equals("")){
					sbu.append("author='").append(author).append("',");
				}
				if(publisher!=null&&!publisher.equals("")){
					sbu.append("publisher='").append(publisher).append("',");
				}
				sbu.delete(sbu.length()-1, sbu.length());
				SET(sbu.toString());
				StringBuilder sbb=new StringBuilder();
				sbb.append("id=").append(id);
				WHERE(sbb.toString());
			}
		}.toString();
	}
	public String selectDSqlByMap(Map<String,Object> mapParams){
		return null;
	}
}

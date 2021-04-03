package com.woniu.tests;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.woniu.bean.pojo.Goods;
import com.woniu.mappers.GoodsMapper;
import com.woniu.utils.MyUtil;
/**
 * 使用pagehelper和jsqlparser插件分页查询
 * @author xiakai
 *
 */
public class TestGoodsPageMapper {
	private Logger logger=Logger.getLogger(TestGoodsPageMapper.class);
	/**
	 * 使用pagehelper和jsqlparser插件分页查询
	 */
	@Test
	public void testGoodsPage() {
		SqlSession sqlSession=MyUtil.getSqlSession();
		GoodsMapper goodsMapper=sqlSession.getMapper(GoodsMapper.class);
		Page<Goods> page=PageHelper.startPage(2, 2);
		List<Goods> goodses=goodsMapper.selectGoodsByPage();
		int pages=page.getPages();
		logger.info("共有"+pages+"页");
		for (Goods goods : goodses) {
			logger.info(goods.getName()+"\t"+goods.getGoodsno());
		}
		MyUtil.closeSqlSession(sqlSession);
	}

}

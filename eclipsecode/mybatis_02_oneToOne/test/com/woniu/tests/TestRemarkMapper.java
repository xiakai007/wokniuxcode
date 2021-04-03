package com.woniu.tests;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.woniu.bean.pojo.Remark;
import com.woniu.mappers.RemarkMapper;
import com.woniu.utils.MyUtil;

public class TestRemarkMapper {
	private Logger logger=Logger.getLogger(TestRemarkMapper.class);
	@Test
	public void testSelectALLrmk() {
		SqlSession sqlSession=MyUtil.getSqlSession();
		RemarkMapper remarkMapper=sqlSession.getMapper(RemarkMapper.class);
		List<Remark> rmks=remarkMapper.selectALLrmk();
		for (Remark remark : rmks) {
			logger.info(remark.getContent()+"\t"+remark.getGoods().getName()+"\t"+remark.getUser().getAccount());
		}
		MyUtil.closeSqlSession(sqlSession);
	}

}

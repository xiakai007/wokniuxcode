package com.woniu.mymall;

import com.woniu.mymall.entity.pojo.Mymall;
import com.woniu.mymall.mapper.MymallMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
@Slf4j
@SpringBootTest
class MymallApplicationTests {
	@Autowired
	private MymallMapper mymallMapper;
	@Test
	void test1() {
		List<Mymall> mymalls = mymallMapper.selectMymallAll();
		for (Mymall mymall : mymalls) {
			log.info(mymall.getName());
		}
	}

}

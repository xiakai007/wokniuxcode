package com.woniu.springboot.mp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.woniu.springboot.mp.mapper.DeptMapper;
//import com.woniu.springboot.mp.pojo.Dept;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Springboot03MpApplicationTests {
	/*@Autowired
	private DeptMapper deptMapper;

	/**
	 * 查询
	 */
	/*@Test
	void test1() {
		List<Dept> deptList = deptMapper.selectList(null);
		for(Dept dept:deptList){
			System.out.println(dept);
		}
	}
	/**
	 * 增加
	 */
	/*@Test
	void test2(){
		Dept dept=new Dept();
		dept.setDname("监察部");
		int insert = deptMapper.insert(dept);
		System.out.println("insert:"+insert);
	}
	/**
	 * 删除
	 */
	/*@Test
	void test3(){
		deptMapper.deleteById(7);
	}
	/**
	 * 修改
	 */
	/*@Test
	void test4(){
		Dept dept = new Dept();
		dept.setId(8);
		dept.setDname("监察中心888");
		deptMapper.updateById(dept);
	}
	/**
	 * 模糊查询
	 */
	/*@Test
	void test5(){
		QueryWrapper<Dept> queryWrapper=new QueryWrapper<>();
		queryWrapper.like("dname","%销售%");
		List<Dept> deptList = deptMapper.selectList(queryWrapper);
		for(Dept dept:deptList){
			System.out.println(dept);
		}
	}*/
    @Test
    void test5(){

    }
}

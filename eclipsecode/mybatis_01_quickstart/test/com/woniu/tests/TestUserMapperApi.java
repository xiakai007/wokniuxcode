package com.woniu.tests;

import java.io.InputStream;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.woniu.bean.pojo.Address;
import com.woniu.bean.pojo.Admin;
import com.woniu.bean.pojo.Cart;
import com.woniu.bean.pojo.Category;
import com.woniu.bean.pojo.Goods;
import com.woniu.bean.pojo.Orderitem;
import com.woniu.bean.pojo.Orders;
import com.woniu.bean.pojo.Remark;
import com.woniu.bean.pojo.User;
import com.woniu.utils.MyUtil;

public class TestUserMapperApi {
	@Test
	public void testSelectUser() throws Exception {
		SqlSession sqlSession=MyUtil.getSqlSession();
		User user=sqlSession.selectOne("com.woniu.mappers.UserMapper.selectUser", 5);
		System.out.println(user);
		MyUtil.closeSqlSession(sqlSession);
	}
	@Test
	public void testUpdateUser() throws Exception {
		SqlSession sqlSession=MyUtil.getSqlSession();
		long lon=System.currentTimeMillis();
		Timestamp ts=new Timestamp(lon);
		User user = new User(5,"tom","211111","98u@qq.com","ijb",29,ts,"1");
		sqlSession.update("com.woniu.mappers.UserMapper.updateUser", user);
		sqlSession.commit();
		MyUtil.closeSqlSession(sqlSession);
	}
	@Test
	public void testDeleteUser() throws Exception {
		SqlSession sqlSession=MyUtil.getSqlSession();
		sqlSession.delete("com.woniu.mappers.UserMapper.deleteUser", 6);
		sqlSession.commit();
		MyUtil.closeSqlSession(sqlSession);
	}
	@Test
	public void testAddUser() throws Exception {
		SqlSession sqlSession=MyUtil.getSqlSession();
		Timestamp ts=new Timestamp(new Date().getTime());
		User user = new User("jack","123qwe","er32@qq.com","fgh",29,ts,"0");
		sqlSession.insert("com.woniu.mappers.UserMapper.addUser", user);
		//必须提交事务
		sqlSession.commit();
		MyUtil.closeSqlSession(sqlSession);
	}
	@Test
	public void testUserMapper() throws Exception {
		SqlSession sqlSession=MyUtil.getSqlSession();
		List<User> users=sqlSession.selectList("com.woniu.mappers.UserMapper.selectAllUser");
		for(User user:users){
			System.out.println(user);
		}
		MyUtil.closeSqlSession(sqlSession);
	}
	@Test
	public void testRemarkMapper() throws Exception {
		InputStream in=Resources.getResourceAsStream("mybatis-config.xml");
		SqlSession sqlSession=new SqlSessionFactoryBuilder().build(in).openSession();
		List<Remark> remarks=sqlSession.selectList("com.woniu.mappers.RemarkMapper.selectAllRemark");
		for(Remark remark:remarks){
			System.out.println(remark);
		}
		sqlSession.close();
	}
	@Test
	public void testOrderitemMapper() throws Exception {
		InputStream in=Resources.getResourceAsStream("mybatis-config.xml");
		SqlSession sqlSession=new SqlSessionFactoryBuilder().build(in).openSession();
		List<Orderitem> orderitems=sqlSession.selectList("com.woniu.mappers.OrderitemMapper.selectAllOrderitem");
		for(Orderitem orderitem:orderitems){
			System.out.println(orderitem);
		}
		sqlSession.close();
	}
	@Test
	public void testOrdersMapper() throws Exception {
		InputStream in=Resources.getResourceAsStream("mybatis-config.xml");
		SqlSession sqlSession=new SqlSessionFactoryBuilder().build(in).openSession();
		List<Orders> orderss=sqlSession.selectList("com.woniu.mappers.Orders.selectAllOrders");
		for(Orders orders:orderss){
			System.out.println(orders);
		}
		sqlSession.close();
	}
	@Test
	public void testGoodsMapper() throws Exception {
		InputStream in=Resources.getResourceAsStream("mybatis-config.xml");
		SqlSession sqlSession=new SqlSessionFactoryBuilder().build(in).openSession();
		List<Goods> goodss=sqlSession.selectList("com.woniu.mappers.GoodsMapper.selectAllGoods");
		for(Goods goods:goodss){
			System.out.println(goods);
		}
		sqlSession.close();
	}
	@Test
	public void testCategoryMapper() throws Exception {
		InputStream in=Resources.getResourceAsStream("mybatis-config.xml");
		SqlSession sqlSession=new SqlSessionFactoryBuilder().build(in).openSession();
		List<Category> categories =sqlSession.selectList("com.woniu.mappers.CategoryMapper.selectAllCategory");
		for(Category category:categories){
			System.out.println(category);
		}
		sqlSession.close();
	}
	@Test
	public void testCartMapper() throws Exception {
		InputStream in=Resources.getResourceAsStream("mybatis-config.xml");
		SqlSession sqlSession=new SqlSessionFactoryBuilder().build(in).openSession();
		List<Cart> carts=sqlSession.selectList("com.woniu.mappers.CartMapper.selectAllCart");
		for(Cart cart:carts){
			System.out.println(cart);
		}
		sqlSession.close();
	}
	@Test
	public void testAddressMapper() throws Exception {
		InputStream in=Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(in);
		SqlSession sqlSession=sqlSessionFactory.openSession();
		List<Address> addresses=sqlSession.selectList("com.woniu.mappers.AddressMapper.selectAllAddress");
		for(Address address:addresses){
			System.out.println(address);
		}
		sqlSession.close();
	}
	@Test
	public void testAdminMapper() throws Exception {
		//加载配置文件
		InputStream in=Resources.getResourceAsStream("mybatis-config.xml");
		//创建SqlSessionFactory的实例对象sqlSessionFactory
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(in);
		//调用sqlSessionFactory的openSession方法得到SqlSession对象
		SqlSession sqlSession =sqlSessionFactory.openSession();
		//查询语句，selectList方法的参数为SQL映射文件中namespace的内容打点id值。
		List<Admin> listAdmin= sqlSession.selectList("com.woniu.mappers.AdminMapper.selectAllAdmin");
		if(listAdmin!=null&&!listAdmin.isEmpty()){
			for(Admin admin:listAdmin){
				System.out.println(admin);
			}
		}
		//关闭sqlSession
		sqlSession.close();
	}

}

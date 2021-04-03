package com.wxws.sms.data;
/**
 * 数据初始化
 * @author xiakai
 *
 */
public class Data {
	/*商品信息*/
	public Goods []goods = new Goods[50];
	/*会员信息*/
	public Customer []customers = new Customer[100];
	/*管理员*/
	public Manager manager = new Manager();
	
	/*货物初始化*/
	public void initial() {
		for(int i =0;i<goods.length;i++) {
			goods[i] = new Goods();
		}
		//商品1
		goods[0].goodsName = "addidas运动鞋";
		goods[0].goodsPrice  = 880;
		//商品2
		goods[1].goodsName = "Kappa网球裙";
		goods[1].goodsPrice  = 200;
		//商品3
		goods[2].goodsName = "网球拍";
		goods[2].goodsPrice  = 780;
		//商品4
		goods[3].goodsName = "addidasT恤";
		goods[3].goodsPrice  = 420.78;
		//商品5
		goods[4].goodsName = "Nike运动鞋";
		goods[4].goodsPrice  = 900;
		//商品6
		goods[5].goodsName = "Kappa网球";
		goods[5].goodsPrice  = 42;
		//商品7
		goods[5].goodsName = "KappaT恤";
		goods[5].goodsPrice  = 245;
		
		for(int i=0;i<customers.length;i++) {
			customers[i] = new Customer();
		}
		//客户1
		customers[0].custNo = 1001;
		customers[0].custBirth = "05/23";
		customers[0].custScore = 2020;
		//客户2
		customers[1].custNo = 1002;
		customers[1].custBirth = "05/24";
		customers[1].custScore = 2021;
		//客户3
		customers[2].custNo = 1003;
		customers[2].custBirth = "05/25";
		customers[2].custScore = 2022;
		//客户4
		customers[3].custNo = 1004;
		customers[3].custBirth = "05/26";
		customers[3].custScore = 2023;
		//客户5
		customers[4].custNo = 1005;
		customers[4].custBirth = "05/27";
		customers[4].custScore = 2024;
		//客户6
		customers[5].custNo = 1006;
		customers[5].custBirth = "05/28";
		customers[5].custScore = 2025;
		//客户7
		customers[6].custNo = 1007;
		customers[6].custBirth = "05/29";
		customers[6].custScore = 2026;
	}

}

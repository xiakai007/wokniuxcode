package com.wxws.sms.management;

import java.util.Scanner;

import com.wxws.sms.data.Customer;
import com.wxws.sms.data.Data;
import com.wxws.sms.data.Goods;

public class Menu {
	Scanner sc = new Scanner(System.in);
	/*初始化商品和客户信息*/
	Data data = new Data();
//	data.initial();
	/*商品信息*/
	public Goods []goods = new Goods[50];
	/*会员信息*/
	public Customer []customers = new Customer[100];
	/**
	 * 传递数据库
	 * @param goods
	 * @param customers
	 */
	public void setData(Goods []goods,Customer []customers) {
		this.goods = goods;
		this.customers = customers;
	}
	/**
	 * 显示我行我素购物管理系统的登录菜单
	 */
	public void showLoginMenu() {
		System.out.println("\n\n\t\t\t    欢迎使用我行我素购物管理系统\n\n");
		System.out.println ("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
		System.out.println("\t\t\t\t 1. 登 录 系 统\n\n");
		System.out.println("\t\t\t\t 2. 更 改 管 理 员 密 码\n\n");
		System.out.println("\t\t\t\t 3. 退 出\n\n");
		System.out.println ("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
		System.out.print("请选择,输入数字:");
		checkSetLogin();
	}
	/**
	 * 登录验证和更改管理员密码
	 */
	public void checkSetLogin() {
		boolean flag = true;
		while(flag) {
			int choice = sc.nextInt();
			Verify veri = new Verify();
			switch(choice) {
			case 1:
				/*密码验证，3次机会*/
				for(int i=3;i>=1;i--) {
					if(veri.verif(data.manager.userName, data.manager.passWord)) {
						showMainMenu();
						break;
					}else if(i!=1) {
						System.out.println("\n用户名和密码不匹配，请重新输入：");
					}else {
						System.out.println("\n您没有权限进入系统！谢谢！");
						flag = false;
					}
				}
				break;
			case 2:
				if(veri.verif(data.manager.userName, data.manager.passWord)) {
					System.out.print("请输入新的用户名：");
          		    String name = sc.next();
          		    System.out.print("请输入新的密码：");
          		    String pwd = sc.next();
          		    System.out.print("请再次输入新的密码：");
        		    String repwd = sc.next();
        		    if(pwd.equals(repwd)) {
        		    	data.manager.userName = name;
        		    	data.manager.passWord = pwd;
        		    	System.out.println("用户名和密码更改成功！");
        		    }else {
        		    	System.out.println("两次密码不一致。");
        		    }
        		    System.out.println("\n请选择，输入数字：");
				}else {
					System.out.println("抱歉，你没有权限修改！");
					flag = false;
				}
				break;
			case 3:
				 System.out.println("谢谢您的使用！");
				 flag = false;
				 break;
			default:
			     System.out.print("\n输入有误！请重新选择，输入数字: ");
				 break;
			}
			if(!flag) {
				break;
			}
		}
		
	}
	/**
	 * 主菜单
	 */
	public void showMainMenu() {
		System.out.println("\n\n\t\t\t\t我行我素购物管理系统>主菜单\n");
		System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
		System.out.println("\t\t\t\t 1. 客 户 信 息 管 理\n");
		System.out.println("\t\t\t\t 2. 购 物 结 算\n");
		System.out.println("\t\t\t\t 3. 真 情 回 馈\n");		
		System.out.println("\t\t\t\t 4. 注 销\n");
		System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
		System.out.print("请选择,输入数字:");
		
		boolean flag = true;
		while(flag) {
			String choice = sc.next();
			switch(choice) {
			case "1":
				//显示客户信息管理菜单
				showCustMenu();
				flag = false;
				break;
			case "2":
				//显示购物结算菜单
				Pay pay = new Pay();
				pay.setData(goods, customers);
				pay.calPrice();
				flag = false;
				break;
			case "3":
				//显示真情回馈菜单
				showSendMenu();
				flag = false;
				break;
			case "4":
				//返回主菜单
				showLoginMenu();
				flag = false;
				break;
				default:
					System.out.print("输入错误，请重新输入数字：");
					break;
			}
			if(!flag) {
				break;
			}
		}
		
	}
	/**
	 * 客户信息管理菜单
	 */
	public void showCustMenu() {
		System.out.println("我行我素购物管理系统>主菜单 > 客户信息管理\n");
		System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
		System.out.println("\t\t\t\t 1. 显 示 所 有 客 户 信 息\n");
		System.out.println("\t\t\t\t 2. 添 加 客 户 信 息\n");
		System.out.println("\t\t\t\t 3. 修 改 客 户 信 息\n");
		System.out.println("\t\t\t\t 4. 查 询 客 户 信 息\n");
		System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
		System.out.print("请选择,输入数字或按'n'返回上一级菜单:");
		
		boolean flag = true;
		while(flag) {
			CustManagement cmt = new CustManagement();
			cmt.setData(goods, customers);
			String choice = sc.next();
			if(choice.equals("1")) {
				cmt.show();
				break;
			}else if(choice.equals("2")) {
				cmt.add();
				break;
			}else if(choice.equals("3")) {
				cmt.modify();
				break;
			}else if(choice.equals("4")) {
				cmt.search();
				break;
			}else if(choice.equals("n")) {
				showMainMenu();
				break;
			}else{
				System.out.println("输入错误, 请重新输入数字：");
			}
		}
	}
	/**
	 * 真情回馈菜单
	 */
    public void showSendMenu() {
    	System.out.println("我行我素购物管理系统>主菜单 >真情回馈\n");
		 System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
		 System.out.println("\t\t\t\t 1. 幸 运 大 放 送\n");
		 System.out.println("\t\t\t\t 2. 幸 运 抽 奖\n");
		 System.out.println("\t\t\t\t 3. 生 日 问 候\n");
		 System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
		 System.out.print("请选择,输入数字或按'n'返回上一级菜单:");
		 
		 boolean flag = true;
		 while(flag) {
			 
		 }
		 
	}

}

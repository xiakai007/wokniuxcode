package com.wxws.sms.data;

/**
 * ��ʼ������
 */
public class Data {
	/* ��Ʒ��Ϣ */
	public Goods goods[] = new Goods[50];
	/* ��Ա��Ϣ */
	public Customer customers[] = new Customer[100];
	/* ����Ա */
	public Manager manager = new Manager();

	public void ini() {
		for (int i = 0; i < goods.length; i++) {
			goods[i] = new Goods();
		}
		
		// ��Ʒ0
		goods[0].goodsName = "addidas�˶�Ь";
		goods[0].goodsPrice = 880;
		
		// ��Ʒ1
		goods[1].goodsName = "Kappa����ȹ";
		goods[1].goodsPrice = 200;
	
		// ��Ʒ2
		goods[2].goodsName = "������";
		goods[2].goodsPrice = 780;
	

		// ��Ʒ3
		goods[3].goodsName = "addidasT��";
		goods[3].goodsPrice = 420.78;
		

		// ��Ʒ4
		goods[4].goodsName = "Nike�˶�Ь";
		goods[4].goodsPrice = 900;
		

		// ��Ʒ5
		goods[5].goodsName = "Kappa����";
		goods[5].goodsPrice = 45;
		

		// ��Ʒ6
		goods[6].goodsName = "KappaT��";
		goods[6].goodsPrice = 245;

	
		for (int i = 0; i < customers.length; i++) {
			customers[i] = new Customer();
		}
		customers[0].custNo = 1900; // �ͻ�1
		customers[0].custBirth = "08/05";
		customers[0].custScore = 2000;

		customers[1].custNo = 1711; // �ͻ�2
		customers[1].custBirth = "07/13";
		customers[1].custScore = 4000;

		customers[2].custNo = 1623; // �ͻ�3
		customers[2].custBirth = "06/26";
		customers[2].custScore = 5000;

		customers[3].custNo = 1545; // �ͻ�4
		customers[3].custBirth = "04/08";
		customers[3].custScore = 2200;

		customers[4].custNo = 1464; // �ͻ�5
		customers[4].custBirth = "08/16";
		customers[4].custScore = 1000;

		customers[5].custNo = 1372; // �ͻ�6
		customers[5].custBirth = "12/23";
		customers[5].custScore = 3000;

		customers[6].custNo = 1286; // �ͻ�7
		customers[6].custBirth = "12/21";
		customers[6].custScore = 10080;

	}

}

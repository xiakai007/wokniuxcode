package com.wxws.sms.management;

import java.util.*;

import com.wxws.sms.data.Customer;
import com.wxws.sms.data.Goods;

public class Pay {
	/* ��Ʒ��Ϣ */
	public Goods goods[] = new Goods[50];
	/* ��Ա��Ϣ */
	public Customer customers[] = new Customer[100];

	/**
	 * �������ݿ�
	 */
	public void setData(Goods[] goods, Customer[] customers) { // �����ʹ��this������β����ı伴��
		this.goods = goods;
		this.customers = customers;
	}

	/**
	 * ����ͻ����ۿ���Ŀ
	 */
	public double getDiscount(int curCustNo, Customer[] customers) {
		double discount;
		int index = -1;
		for (int i = 0; i < customers.length; i++) {
			if (curCustNo == customers[i].custNo) {
				index = i;
				break;
			}
		}

		if (index == -1) {// �����Ա�Ų�����
			discount = -1;

		} else {

			// �ж��ۿ�
			int curscore = customers[index].custScore;
			if (curscore < 1000) {
				discount = 0.95;
			} else if (1000 <= curscore && curscore < 2000) {
				discount = 0.9;
			} else if (2000 <= curscore && curscore < 3000) {
				discount = 0.85;
			} else if (3000 <= curscore && curscore < 4000) {
				discount = 0.8;
			} else if (4000 <= curscore && curscore < 6000) {
				discount = 0.75;
			} else if (6000 <= curscore && curscore < 8000) {
				discount = 0.7;
			} else {
				discount = 0.6;
			}
		}
		return discount;

	}

	/*
	 * ��ʵ�ֹ�������Լ��������СƱ
	 */
	public void calcPrice() {
		int curCustNo; // �ͻ���
		int goodsNo = 0; // ��Ʒ���
		double price; // ��Ʒ�۸�
		String name;
		int count; // ��������
		String choice;
		String goodsList = ""; // �����嵥
		double total = 0; // �����ܽ��
		double finalPay = 0; // ���ۺ��踶��
		double payment; // ʵ�ʽ��ѽ��

		System.out.println("�������ع������ϵͳ > �������\n\n");

		// ��ӡ��Ʒ�嵥
		System.out.println("*************************************");
		System.out.println("��ѡ�������Ʒ��ţ�");
		for (int i = 0, p = 0; i < goods.length && null != goods[i].goodsName; i++) {
			p++;
			System.out.println(p + ": " + goods[i].goodsName + "\t");
		}
		System.out.println("*************************************\n");

		/* ���й������ϵͳ */
		Scanner input = new Scanner(System.in);
		System.out.print("\t�������Ա�ţ�");
		curCustNo = input.nextInt();
		double discount = getDiscount(curCustNo, customers);
		if (discount == -1) {
			System.out.println("��Ա���������");
		} else {

			do {
				System.out.print("\t��������Ʒ��ţ�"); // �����±�+1����Ʒ���
				goodsNo = input.nextInt();
				System.out.print("\t��������Ŀ��");
				count = input.nextInt();

				// ��ѯ����
				price = goods[goodsNo - 1].goodsPrice;
				name = goods[goodsNo - 1].goodsName;
				total = total + price * count;

				// ���ӹ����嵥
				goodsList = goodsList + "\n" + name + "\t" + "��" + price
						+ "\t\t" + count + "\t\t" + "��" + (price * count)
						+ "\t";

				System.out.print("\t�Ƿ������y/n��");
				choice = input.next();
			} while (choice.equals("y"));

			// ���������ܽ��
			finalPay = total * discount;

			// ��ӡ�����嵥
			System.out.println("\n");
			System.out.println("���������������������������������������嵥������������������������������������������");
			System.out.println("��Ʒ\t\t" + "����\t\t" + "����\t\t" + "���\t");
			System.out.print(goodsList);
			System.out.println("\n�ۿۣ�\t" + discount);
			System.out.println("����ܼ�:\t" + "��" + finalPay);
			System.out.print("ʵ�ʽ���:\t��");
			payment = input.nextDouble();
			System.out.println("��Ǯ:\t" + "��" + (payment - finalPay));

			// �����õĻ��֣�
			int score = (int) finalPay / 100 * 3;

			// ���Ļ�Ա����
			for (int i = 0; i < customers.length; i++) {
				if (customers[i].custNo == curCustNo) {
					customers[i].custScore = customers[i].custScore + score;
					System.out.println("���ι�������Ļ����ǣ� " + score);
					break;
				}
			}
		}
		// ������һ���˵�
		System.out.print("\n��'n'������һ���˵�:");
		if (input.next().equals("n")) {
			Menu menu = new Menu();
			menu.setData(goods, customers);
			menu.showMainMenu();
		}

	}

}

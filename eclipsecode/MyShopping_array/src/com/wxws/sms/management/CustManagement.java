package com.wxws.sms.management;

import java.util.Scanner;

import com.wxws.sms.data.Customer;
import com.wxws.sms.data.Goods;

public class CustManagement {
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
	 * ������һ���˵�
	 */
	public void returnLastMenu() {
		System.out.print("\n\n�밴'n'������һ���˵�:");
		Scanner input = new Scanner(System.in);
		boolean con = true;
		do {
			if (input.next().equals("n")) {
				Menu menu = new Menu();
				menu.setData(goods, customers);
				menu.showCustMMenu();
			} else {
				System.out.print("�������, ������'n'������һ���˵���");
				con = false;
			}
		} while (!con);
	}

	/**
	 * ѭ�����ӻ�Ա��MY
	 */
	public void add() {
		System.out.println("�������ع������ϵͳ > �ͻ���Ϣ���� > ��ӿͻ���Ϣ\n\n");
		String con = "n";
		// ȷ�������Աλ��
		int index = -1;
		for (int i = 0; i < customers.length; i++) {
			if (customers[i].custNo == 0) {
				index = i;
				break;
			}
		}

		do { // ѭ��¼���Ա��Ϣ
			Scanner input = new Scanner(System.in);
			System.out.print("�������Ա��(<4λ����>)��");
			int no = input.nextInt();
			System.out.print("�������Ա���գ���/��<����λ����ʾ>����");
			String birth = input.next();
			System.out.print("��������֣�");
			int score = input.nextInt();

			// ��Ա����Ч������
			if (no < 1000 || no > 9999) {
				System.out.println("�ͻ���" + no + "����Ч��Ա�ţ�");
				System.out.println("¼����Ϣʧ��\n");
				System.out.println("������ӻ�Ա�𣿣�y/n��");
				con = input.next();
				continue;
			}
			// ��ӻ�Ա

			customers[index].custNo = no;
			customers[index].custBirth = birth;
			customers[index++].custScore = score;
			System.out.println("�»�Ա��ӳɹ���");
			System.out.println("������ӻ�Ա�𣿣�y/n��");
			con = input.next();
		} while ("y".equals(con) || "Y".equals(con));
		returnLastMenu();
	}

	/**
	 * ���Ŀͻ���Ϣ
	 */
	public void modify() {
		System.out.println("�������ع������ϵͳ > �ͻ���Ϣ���� > �޸Ŀͻ���Ϣ\n\n");
		System.out.print("�������Ա�ţ�");
		Scanner input = new Scanner(System.in);
		int no = input.nextInt();
		System.out.println("  ��Ա��            ����             ����      ");
		System.out.println("------------|------------|---------------");
		int index = -1;
		for (int i = 0; i < customers.length; i++) {
			if (customers[i].custNo == no) {
				System.out.println(customers[i].custNo + "\t\t"
						+ customers[i].custBirth + "\t\t"
						+ customers[i].custScore);
				index = i;
				break;
			}
		}

		if (index != -1) {
			while (true) {
				System.out
						.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
				System.out.println("\t\t\t\t1.�� �� �� Ա �� ��.\n");
				System.out.println("\t\t\t\t2.�� �� �� Ա �� ��.\n");
				System.out
						.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
				System.out.print("��ѡ���������֣�");
				switch (input.nextInt()) {
				case 1:
					System.out.print("�������޸ĺ�����գ�");
					customers[index].custBirth = input.next();
					System.out.println("������Ϣ�Ѹ��ģ�");
					break;
				case 2:
					System.out.print("�������޸ĺ�Ļ�Ա���֣�");
					customers[index].custScore = input.nextInt();
					System.out.println("��Ա�����Ѹ��ģ�");
					break;
				}

				System.out.println("�Ƿ��޸���������(y/n):");
				String flag = input.next();
				;
				if ("n".equalsIgnoreCase(flag))
					break;
			}
		} else {
			System.out.println("��Ǹ��û�����ѯ�Ļ�Ա��");
		}

		// ������һ���˵�
		returnLastMenu();

	}

	/**
	 * ��ѯ�ͻ�����Ϣ
	 */
	public void search() {
		System.out.println("�������ع������ϵͳ > �ͻ���Ϣ���� > ��ѯ�ͻ���Ϣ\n");
		String con = "y";
		Scanner input = new Scanner(System.in);
		while (con.equals("y")) {
			System.out.print("�������Ա�ţ�");
			int no = input.nextInt();
			System.out.println("  ��Ա��            ����             ����      ");
			System.out.println("------------|------------|---------------");
			boolean isAvailable = false;
			for (int i = 0; i < customers.length; i++) {
				if (customers[i].custNo == no) {
					System.out.println(customers[i].custNo + "\t\t"
							+ customers[i].custBirth + "\t\t"
							+ customers[i].custScore);
					isAvailable = true;
					break;
				}
			}
			if (!isAvailable) {
				System.out.println("��Ǹ��û�����ѯ�Ļ�Ա��Ϣ��");
			}
			System.out.print("\nҪ������ѯ��y/n��:");
			con = input.next();
		}

		// ������һ���˵�
		returnLastMenu();
	}

	/**
	 * ��ʾ���еĻ�Ա��Ϣ
	 */
	public void show() {
		System.out.println("�������ع������ϵͳ > �ͻ���Ϣ���� > ��ʾ�ͻ���Ϣ\n\n");
		System.out.println("  ��Ա��            ����             ����      ");
		System.out.println("------------|------------|---------------");
		int length = customers.length;
		for (int i = 0; i < length; i++) {
			if (customers[i].custNo == 0) {
				break; // �ͻ���Ϣ�Ѿ���ʾ���
			}
			System.out.println(customers[i].custNo + "\t\t"
					+ customers[i].custBirth + "\t\t" + customers[i].custScore);
		}

		// ������һ���˵�
		returnLastMenu();
	}
	/**
	 * 
	 * @param ageline
	 */
	public void AgeRate(int ageline){
		int young = 0;	//��¼����ֽ������¹˿͵�����
		int old = 0; //��¼����ֽ������Ϲ˿͵�����
		int age = 0;	//����˿͵�����
		Scanner input = new Scanner(System.in);
		for(int i = 0; i < 10; i++){
			System.out.print("�������" +(i+1)+ "λ�˿͵����䣺");
			age = input.nextInt();
			if(age > 0 && age <= 30){
				young++;
			}
		}
		System.out.println("30�����µı����ǣ�" + young/10.0*100 +"%");
		System.out.println("30�����ϵı����ǣ�" + (1-young/10.0)*100 +"%");
	}
}

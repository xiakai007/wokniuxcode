package com.wxws.sms.management;

import java.util.Scanner;
import com.wxws.sms.data.*;

/**
 *�������
 */
public class GiftManagement {
	/* ��Ʒ��Ϣ */
	public Goods goods[] = new Goods[50];
	/* ��Ա��Ϣ */
	public Customer customers[] = new Customer[100];
	
	  /**
	   * �������ݿ�
	   */
	public void setData(Goods[] goods,  Customer[] customers){ //�����ʹ��this������β����ı伴��
		this.goods = goods; 
		this.customers = customers;
	}
	   
	
	/**
	 * ������һ���˵�
	 */
	  public void returnLastMenu(){
		   System.out.print("\n\n�밴'n'������һ���˵�:");
		   Scanner input = new Scanner(System.in);
		   boolean con = true;
		   do{ 
		     if(input.next().equals("n")){
			    Menu menu = new Menu();
		        menu.setData(goods,customers);
		        menu.showSendGMenu();
		     }else{
		    	System.out.print("�������, ������'n'������һ���˵���");
		    	con = false;
		     }
	       }while(!con);
	   }
	
	/**
	  * ʵ�������ʺ���
	  */
	  public void sendBirthCust(){
		  System.out.println("�������ع������ϵͳ > �����ʺ�\n\n");
		  System.out.print("��������������(��/��<����λ��ʾ>)��");
          Scanner input = new Scanner(System.in);
          String date = input.next();
          System.out.println(date);
          String no = "";
          boolean isAvailable = false;
          for(int i = 0; i < customers.length; i++){
       	    if(customers[i].custBirth!=null && customers[i].custBirth.equals(date)){
       		  no = no + customers[i].custNo + "\n";
       		  isAvailable = true;
       	    }
          }
          if(isAvailable){
       	     System.out.println("�����յĻ�Ա�ǣ�");
       	     System.out.println(no);
             System.out.println("��ϲ������MP3һ����");
          }else{
       	     System.out.println("����û�й����յĻ�Ա��");
          }     
          
          //������һ���˵�
          returnLastMenu();
	  }
	  
	  /**
       *  �������˻�Ա
       */
	  public void  sendLuckyCust(){
		  System.out.println("�������ع������ϵͳ > ���˳齱\n\n");
		  System.out.print("�Ƿ�ʼ��y/n����");
		  Scanner input = new Scanner(System.in);
		  if(input.next().equals("y")){
			  int random = (int)(Math.random()* 10);
			  //System.out.println(random);
			  int baiwei; //��λ 
			  boolean isAvailable = false;
			  String list = "";
              for(int i = 0; i< customers.length; i++){
                 if(customers[i].custNo==0){
                	 break;
                 } 
    			 baiwei = customers[i].custNo / 100 % 10;
            	 if(baiwei == random){
            		 list = list + customers[i].custNo+ "\t";
            		 isAvailable = true;
            	 }
              }
              if(isAvailable){
            	   System.out.println("���˿ͻ�����MP3��" + list);
              }else{
            	   System.out.println("�����˿ͻ���");
              }
		  }
		  
		  //������һ���˵�
          returnLastMenu();
	  }
	  /**
	   * ���˴����
	   */
	  public void sendGoldenCust(){
		  System.out.println("�������ع������ϵͳ > ���˴����\n\n");
		  int index = 0;
		  int max = customers[0].custScore;
		  //�ٶ����ָ�����ͬ
		  for(int i = 0; i < customers.length; i++){
			  if(customers[i].custScore == 0){
				  break;  //�������Ϊ���û�
			  }
			  //�������ֵĿͻ�
			  if(customers[i].custScore  > max){
				  max = customers[i].custScore ;
				  index = i;
			  }
		  }
		  System.out.println("������߻��ֵĻ�Ա�ǣ� " + customers[index].custNo + "\t" + customers[index].custBirth + "\t" + customers[index].custScore);
          //�����ʼǱ����Զ���
		  Gift laptop = new Gift();
		  laptop.name = "ƻ���ʼǱ�����";
		  laptop.price = 12000;
		  System.out.print("��ϲ��������Ʒ�� ");
		  System.out.println(laptop);
		  
          //������һ���˵�
          returnLastMenu();
	  }
}

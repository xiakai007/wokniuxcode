package com.wxws.sms.management;

import com.wxws.sms.data.*;
import java.util.*;

public class StartSMS {
      /**
       * �������ع������ϵͳ�����
       *
       */
	  public static void main(String[] args){
    	   /*��ʼ���̳�����Ʒ�Ϳͻ���Ϣ*/
           Data initial = new Data();
           initial.ini();
           
           
           /*����ϵͳ*/
           Menu menu = new Menu();
     	   menu.setData(initial.goods, initial.customers); 
           menu.showLoginMenu();
           
           /*�˵�ѡ��*/
           boolean con = true;
           while(con){
             Scanner input = new Scanner(System.in);
             int choice = input.nextInt();
             VerifyEqual pv = new VerifyEqual();
             switch(choice){
               case 1: 
            	  /*������֤*/
            	  for(int i = 3; i>=1; i--){
            		  if(pv.verify(initial.manager.username, initial.manager.password)){
                    	  menu.showMainMenu();
                    	  break;
            		  }else if(i!=1){
            			  System.out.println("\n�û��������벻ƥ�䣬���������룺"); //����3�����룬�˳�
            		  }else{
            			  System.out.println("\n��û��Ȩ�޽���ϵͳ��лл��");
            			  con = false;
            		  }
            	  }
            	  break;
               case 2: 
            	  if(pv.verify(initial.manager.username, initial.manager.password)){
            		  System.out.print("�������µ��û�����");
            		  String name = input.next();
            		  System.out.print("�������µ����룺");
            		  String pwd = input.next();
            		
            		  System.out.print("���ٴ������µ����룺");
            		  String repwd = input.next();
            		  if(pwd.equals(repwd)){
            			  initial.manager.username = name;
            			  initial.manager.password = pwd;
            			  System.out.println("�û����������Ѹ��ģ�");  
            		  }
            		  else{
            			  System.out.println("�������벻һ�¡�");
            		  }
            			  
            		  System.out.println("\n��ѡ���������֣�");
            	  }else{
            		  System.out.println("��Ǹ����û��Ȩ���޸ģ�");
            		  con = false;
            	  }
            	  break;
               case  3: 
            	  System.out.println("лл����ʹ�ã�");
            	  con = false;
            	  break;
               default: 
            	  System.out.print("\n��������������ѡ����������: ");
             }
             if(!con){
            	 break;
             }
           }
          
      }
}

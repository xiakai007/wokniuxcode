package com.wxws.sms.management;
import java.util.*;
public class VerifyEqual {
    /**
     * ��֤����Ա���û����������Ƿ����
     */ 
	public boolean verify(String username, String password){
    	  System.out.print("�������û�����");
    	  Scanner input = new Scanner(System.in);
    	  String name = input.next();
          System.out.print("���������룺");
          input = new Scanner(System.in);
          String psw = input.next();
          if(name.equals(username) && password.equals(psw)){
        	  return true;
          }else{
        	  return false;
          }
     }
}

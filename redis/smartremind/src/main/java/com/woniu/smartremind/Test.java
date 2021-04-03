package com.woniu.smartremind;

import com.woniu.smartremind.uitl.ToPinyin;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Test {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream("d:/crime.txt")
        ));
        String msg=null;
        while ((msg=reader.readLine())!=null){
            if(!msg.trim().equals("")){
                for (int i = 0; i < 10; i++) {
                    msg=msg.replaceAll(i+"","");
                }
                msg=msg.replaceAll("第条","");
                msg=msg.replaceAll("第款","");
                msg=msg.replaceAll("刑法","");
                msg=msg.replaceAll("同上","");
                msg=msg.replaceAll("、","");
                try{
                    String simplecode= ToPinyin.getSimpleCode(msg);
                    String fullcode=ToPinyin.getFullCode(msg);
                    System.out.println("INSERT INTO crime VALUES(null,'"+msg+"','"+simplecode+"','"+fullcode+"')");
                }catch (Exception e){

                }
            }

        }
    }
}

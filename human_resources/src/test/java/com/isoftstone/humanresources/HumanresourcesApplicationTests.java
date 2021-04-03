package com.isoftstone.humanresources;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HumanresourcesApplicationTests {

    @Test
    @Ignore
    public void contextLoads() {

    }

    @Test
    public void getExe() {
        String str = "在岸,在岸,";
        System.out.println(str.substring(0,str.length()-1));

    }
    @Test
    public void getTimeDif() {
//        Date d1 = new Date(); //第一个时间
//        Date d2 = new Date(); //第二个时间
//        SimpleDateFormat f = new SimpleDateFormat("hh:mm"); //格式化为 hhmmss
//        int d1Number = Integer.parseInt(f.format(d1).toString()); //将第一个时间格式化后转为int
//        int d2Number = Integer.parseInt(f.format(d2).toString()); //将第二个时间格式化后转为int
//        if(d1Number>d2Number){
//            System.out.println("时间d1大");
//            System.out.println(d1Number);
//        }

        String time1str = "16:00";
        String time2str = "17:00";

        DateFormat df = new SimpleDateFormat("HH:mm");//创建日期转换对象HH:mm:ss为时分秒，年月日为yyyy-MM-dd
        try {
            Date dt1 = df.parse(time1str);//将字符串转换为date类型
            Date dt2 = df.parse(time2str);
            if (dt1.getTime() > dt2.getTime())//比较时间大小,如果dt1大于dt2
            {
                System.out.println("yes");
            }else{
                System.out.println("no");
            }

            System.out.println(dt1.getTime()- dt2.getTime());
            System.out.println(dt2.getTime()- dt1.getTime());
        }catch (Exception e){
            e.printStackTrace();
        }

    }


}

package com.woniu;

public class Test10 {
    public static void main(String[] args) throws Exception {
        Test09 instance1 = Test09.getInstance();
        System.out.println("instance1:"+instance1);
        Test09 instance2 = Test09.getInstance();
        System.out.println("instance2:"+instance2);
        Test09 instance3 = Test09.getInstance();
        System.out.println("instance3:"+instance3);
        Test09 instance4 = Test09.getInstance();
        System.out.println("instance4:"+instance4);
    }
}

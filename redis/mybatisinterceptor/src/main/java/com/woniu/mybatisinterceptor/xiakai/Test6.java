package com.woniu.mybatisinterceptor.xiakai;

import java.util.ArrayList;
import java.util.List;

public class Test6 {
    public static String reverseWords(String s) {
        s.trim();
        s += " ";
        // 将每个单词都放入这个数组
        List<String> strList = new ArrayList<>();
        String name = "", res = "";
        for (int i = 0; i < s.length(); i ++ ) {
            if(s.charAt(i) != ' ') name += s.charAt(i);
            else {
                strList.add(name); // 如果遇到连续的空格，这里会添加空的name
                name = "";
            }
        }
        System.out.println("strList:"+strList);
        while(strList.size() > 0) {
            if(!strList.get(strList.size() - 1).equals("")) { // 只添加非空字符串
                res += strList.get(strList.size() - 1) + " ";

            }
            strList.remove(strList.size() - 1);
        }
        return res.trim();

    }
    public static void main(String[] args) {
        String a="   i     have a            dream  ";
        String s = reverseWords(a);
        System.out.println(s);
    }
}

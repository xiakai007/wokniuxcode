package com.woniu.mybatisinterceptor.xiakai;

import java.nio.charset.CharacterCodingException;
import java.util.*;

/**
 * 计算字符串字符出现的次数
 */
public class Test3 {
    public static void main(String[] args) {
        String str="aaabbbcccdddasdfasfasdfasdf";
        char[] chars = str.toCharArray();
        TreeMap<Character, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < chars.length; i++) {
            if(treeMap.containsKey(chars[i])){
                Integer value = treeMap.get(chars[i]);
                treeMap.replace(chars[i],value+1);
            }else {
                treeMap.put(chars[i],1);
            }
        }
        Set<Character> characters = treeMap.keySet();
        for (Character character : characters) {
            System.out.println(character+"---"+treeMap.get(character));
        }
        System.out.println("*******");
        Set<Map.Entry<Character, Integer>> entries = treeMap.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            System.out.println(entry.getKey()+"---"+entry.getValue());
        }
        Integer[] a={2,5,7,1,6};
        //Arrays.sort(a);//升序

        Arrays.sort(a, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        System.out.println(Arrays.toString(a));
    }

}

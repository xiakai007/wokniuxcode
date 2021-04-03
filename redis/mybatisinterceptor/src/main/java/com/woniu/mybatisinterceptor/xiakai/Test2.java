package com.woniu.mybatisinterceptor.xiakai;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;
@Slf4j
public class Test2 {
    public static void main(String[] args) {
        HashMap<String,User> map=new HashMap<>();
        map.put("a",new User("jack",10));
        map.put("b",new User("mike",6));
        map.put("c",new User("tom",20));
        map.put("d",new User("jerry",3));
        map.put("e",new User("xiakai",18));
        log.info("排序前"+map);
        HashMap<String, User> sortedMap = mySort(map);
        log.info("排序后"+sortedMap);
    }
    public static HashMap<String,User> mySort(HashMap<String,User> map){
        Set<Map.Entry<String, User>> entries = map.entrySet();
        List<Map.Entry<String, User>> list=new ArrayList<>(entries);
        Collections.sort(list, new Comparator<Map.Entry<String, User>>() {
            @Override
            public int compare(Map.Entry<String, User> o1, Map.Entry<String, User> o2) {
                //o1-o2代表升序排序
                return o1.getValue().getAge()-o2.getValue().getAge();
            }
        });
        LinkedHashMap<String, User> linkedHashMap = new LinkedHashMap<>();
        for (Map.Entry<String, User> stringUserEntry : list) {
            linkedHashMap.put(stringUserEntry.getKey(),stringUserEntry.getValue());
        }
        return linkedHashMap;
    }

}

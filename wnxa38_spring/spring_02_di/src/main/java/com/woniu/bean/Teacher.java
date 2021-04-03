package com.woniu.bean;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

@Data
public class Teacher {
    private String name;
    private List<Student> students;
    private List<String> hobbies;
    private Map<String,String> job;
    private Properties studentLevel;
    public void introduce(){
        System.out.println("我是"+name+"，我的学生有：");
        if(students!=null&&!students.isEmpty()){
            for (Student student:students) {
                System.out.println("\t"+student.getName());
            }
        }
        if(hobbies!=null&&!hobbies.isEmpty()){
            System.out.println("我的爱好有：");
            for (String hobby:hobbies) {
                System.out.println("\t"+hobby);
            }
        }
        System.out.println("职务有：");
        if(job!=null){
            Set<Map.Entry<String, String>> entries = job.entrySet();
            for(Map.Entry<String, String> entry:entries){
                System.out.println(entry.getKey()+"-->"+entry.getValue());
            }
        }
        System.out.println("徒弟类别：");
        if(studentLevel!=null){
            System.out.println("firstLevel:"+studentLevel.getProperty("firstLevel"));
            System.out.println("secondLevel:"+studentLevel.getProperty("secondLevel"));
        }
    }
}

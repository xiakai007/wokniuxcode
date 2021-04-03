package com.woniu.springboot.auickstart.config;

import com.woniu.springboot.auickstart.pojo.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {
    @Bean
    public Person getPerson(){
        return new Person("person-关羽",18);
    }
    @Bean
    public Person getPerson2(){
        return new Person("person-刘备",22);
    }
    @Bean("beihai")
    public Person getPerson3(){
        return new Person("person-北海",22);
    }
}

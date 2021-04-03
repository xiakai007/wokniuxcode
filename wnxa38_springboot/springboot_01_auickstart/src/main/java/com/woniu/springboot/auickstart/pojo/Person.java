package com.woniu.springboot.auickstart.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@ConfigurationProperties(prefix = "org.giles")
public class Person {
    private String name;
    private Integer age;
}

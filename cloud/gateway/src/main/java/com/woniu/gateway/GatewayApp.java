package com.woniu.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@ServletComponentScan("com.woniu.gateway")
public class GatewayApp {
    public static void main(String[] args){
        SpringApplication.run(GatewayApp.class,args);
    }
}

package com.woniu.springboot.portals.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerJavaConfig {
    @Bean
    public Docket getDocket(){
        Docket docket=new Docket(DocumentationType.SWAGGER_2);
        ApiSelectorBuilder apisb = docket.apiInfo(getApiInfo()).select();
        Docket newDocket = apisb.apis(RequestHandlerSelectors.basePackage("com.woniu.springboot.portals.controller")).build();
        return newDocket;
    }
    public ApiInfo getApiInfo(){
        ApiInfo apiInfo=new ApiInfoBuilder().title("K15教育平台")
                .description("K15教育平台门户网站API接口")
                .contact(new Contact("xiakai","http://www.woniu.com","980385778@qq.com"))
                .version("1.0")
                .license("蜗牛学院")
                .build();
        return apiInfo;
    }
}

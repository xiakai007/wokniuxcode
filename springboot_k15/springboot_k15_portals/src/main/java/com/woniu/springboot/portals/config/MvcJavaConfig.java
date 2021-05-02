package com.woniu.springboot.portals.config;

import com.woniu.springboot.portals.interceptor.JwtInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class MvcJavaConfig implements WebMvcConfigurer {
    @Bean
    @Scope("prototype")
    public JwtInterceptor jwtInterceptor(){
        return new JwtInterceptor();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/login"
                        ,"/course/getFineCourse"
                        ,"/images/**"
                        ,"/teacher/getFamousTeachers");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://127.0.0.1/k15portals")
                .allowedMethods("GET","HEAD","PUT","POST","DELETE","OPTIONS")
                .maxAge(3600)
                .allowedHeaders("*");
    }
}

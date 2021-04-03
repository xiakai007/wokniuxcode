package myconfig;

import com.woniu.springboot.auickstart.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public User getUser(){
        return new User("user-大史",14);
    }
}

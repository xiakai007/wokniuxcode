package com.isoftstone.humanresources.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SystemConfig {

    @Value("${MAIL_SMTP}")
    private String smtp;
    @Value("${MAIL_FROM}")
    private String from;
    // smtp认证用户名和密码
    @Value("${MAIL_USERNAME}")
    private String username;
    @Value("${MAIL_PASSWORD}")
    private String password;

    public String getSmtp() {
        return smtp;
    }

    public void setSmtp(String smtp) {
        this.smtp = smtp;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

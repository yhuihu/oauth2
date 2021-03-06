package com.demo.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.demo.oauth2.mapper")
public class SpringSecurityOauth2ResourceApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityOauth2ResourceApplication.class,args);
    }
}

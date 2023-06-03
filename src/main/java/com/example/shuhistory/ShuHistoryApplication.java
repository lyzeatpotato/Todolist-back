package com.example.shuhistory;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@MapperScan("com.example.shuhistory.mapper")
public class ShuHistoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShuHistoryApplication.class, args);
    }

}

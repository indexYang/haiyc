package com.yc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.yc.dao")
public class HaiycWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(HaiycWebApplication.class);
    }
}

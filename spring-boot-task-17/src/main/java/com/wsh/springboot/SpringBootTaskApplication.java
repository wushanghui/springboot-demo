package com.wsh.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling //开始定时任务功能
@EnableAsync //开启异步注解
@SpringBootApplication
public class SpringBootTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTaskApplication.class, args);
    }

}

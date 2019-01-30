package com.wsh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication 注解 表示这是一个主程序，springboot应用
 */
@SpringBootApplication
public class HelloWorldMain {

    public static void main(String[] args) {
        //启动 spring 应用
        SpringApplication.run(HelloWorldMain.class, args);
    }
}

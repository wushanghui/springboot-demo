package com.wushanghui.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 自定义健康状态指示器
 * 1、编写一个指示器 实现 HealthIndicator 接口
 * 2、指示器的名字 xxxxHealthIndicator
 * 3、加入容器中
 */
@SpringBootApplication
public class SpringBootActuator20Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootActuator20Application.class, args);
    }

}

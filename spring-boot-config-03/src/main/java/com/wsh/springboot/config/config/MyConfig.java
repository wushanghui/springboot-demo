package com.wsh.springboot.config.config;

import com.wsh.springboot.config.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration 这个注解表示当前类是一个配置类，替代之前的spring配置文件
 */
@Configuration
public class MyConfig {

    /**
     * @Bean 注解表示将方法返回值添加到容器中，容器中这个组件默认的id就是方法名
     * @return
     */
    @Bean
    public HelloService helloService() {
        System.out.println("HelloService 加入容器中");
        return new HelloService();
    }

}

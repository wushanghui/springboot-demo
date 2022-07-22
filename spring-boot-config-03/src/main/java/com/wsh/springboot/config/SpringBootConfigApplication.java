package com.wushanghui.springboot.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @ImportResource 这个注解是导入spring的配置文件，使配置文件里面的内容生效；
 * 注解加到主启动类上
 */
@SpringBootApplication
//@ImportResource(locations = {"classpath:beans.xml"})
public class SpringBootConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootConfigApplication.class, args);
	}

}


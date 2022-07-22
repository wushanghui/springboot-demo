package com.wushanghui.springboot.config;

import com.wushanghui.springboot.config.bean.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 单元测试
 * 可以在测试期间类似编码一样进行自动注入等容器的功能
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootConfigApplicationTests {

	@Autowired
	Person person;

	@Autowired
	ApplicationContext ioc;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testConfigProperties() {
		System.out.println(person);
	}

	/**
	 * 测试容器中有没有HelloService
	 */
	@Test
	public void testHelloService() {
		boolean flag = ioc.containsBean("helloService");
		System.out.println(flag);
	}
}


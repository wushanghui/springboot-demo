package com.wushanghui.starter.controller;

import com.wushanghui.starter.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jue
 * @date 2019/2/25 23:11
 * @describe
 */
@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @GetMapping("/hello")
    public String hello() {
        String helloStr = helloService.seyHello("小吴同学");
        return helloStr;
    }
}

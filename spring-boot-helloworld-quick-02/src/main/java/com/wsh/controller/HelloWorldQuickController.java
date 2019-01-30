package com.wsh.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController 注解包含 @Controller和@ResponseBody 注解
 * ResponseBody 注解标在类名上表示所有的方法请求都可以给浏览器返回参数，如果是对象
 * 会自动转成json格式
 */
@RestController
public class HelloWorldQuickController {

    @RequestMapping(value = "/hello")
    public String hello() {
        return "hello world quick";
    }
}

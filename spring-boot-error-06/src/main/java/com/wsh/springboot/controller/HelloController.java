package com.wushanghui.springboot.controller;

import com.wushanghui.springboot.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author：Administrator
 * @date：2019/2/6
 * @describe：
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(@RequestParam("user") String user) {
        if ("abcd".equals(user)) {
            throw new UserNotExistException();
        }
        return "hello world";
    }
}

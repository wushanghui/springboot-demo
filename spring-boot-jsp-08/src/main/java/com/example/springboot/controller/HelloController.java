package com.example.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author：Administrator
 * @date：2019/2/9
 * @describe：
 */
@Controller
public class HelloController {

    @GetMapping("/abc")
    public String hello(ModelMap modelMap) {
        modelMap.addAttribute("msg", "你好");
        return "success";
    }
}

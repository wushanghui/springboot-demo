package com.wsh.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author：Administrator
 * @date：2019/2/22
 * @describe：
 */
@Controller
public class JsMethodTestController {

    @RequestMapping("/inputMaxLenLimit")
    public String inputMaxLenLimit() {
        return "jsmethodtest/vailddemo";
    }
}

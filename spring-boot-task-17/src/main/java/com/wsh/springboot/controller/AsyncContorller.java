package com.wsh.springboot.controller;

import com.wsh.springboot.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author jue
 * @date 2019/3/4 22:03
 * @describe
 */
@Controller
public class AsyncContorller {

    @Autowired
    private AsyncService asyncService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String hello() {
        asyncService.hello();
        return "success";
    }
}

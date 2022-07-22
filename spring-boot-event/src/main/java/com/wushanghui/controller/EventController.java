package com.wushanghui.controller;

import com.wushanghui.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 吴尚慧
 * @since 2022/7/15 11:33
 */
@RestController
public class EventController {

    @Autowired
    OrderService orderService;

    @GetMapping("/event")
    public String helloEvent() {
        orderService.buyOrder("732171109");
        return "hello event";
    }
}

package com.wushanghui.springboot.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author jue
 * @date 2019/3/4 22:00
 * @describe
 */
@Service
public class AsyncService {

    @Async //告诉spring 这是一个异步的方法
    public void hello() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("处理数据中。。。");
    }
}

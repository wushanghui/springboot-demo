package com.wushanghui.springboot.controller;

import com.wushanghui.springboot.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author：Administrator
 * @date：2019/2/6
 * @describe：处理异常
 */
@ControllerAdvice
public class MyExceptionHandler {

    /**
     * 1.第一种写法
     * 浏览器和客户端返回的都是json数据
     * @param e
     * @return
     */
//    @ResponseBody
//    @ExceptionHandler(UserNotExistException.class)
//    public Map<String, Object> handleException(Exception e) {
//        Map<String, Object> map = new HashMap<>(2);
//        map.put("code", "user not exist");
//        map.put("message", e.getMessage());
//        return map;
//    }

    /**
     *
     * 转发到/error 进行自适应响应效果处理
     * @param e
     * @return
     */
    @ExceptionHandler(UserNotExistException.class)
    public String handleException(Exception e, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>(2);
        //传入我们自己的错误状态码 4xx，5xx，否则就不会进入定制错误页面的解析流程
        request.setAttribute("javax.servlet.error.status_code", 500);
        map.put("code", "user not exist");
        map.put("message", "用户还是不存在呀。。。");
        //把我们定义的错误map放到请求域中
        request.setAttribute("extra", map);
        //转发到/error
        return "forward:/error";
    }
}

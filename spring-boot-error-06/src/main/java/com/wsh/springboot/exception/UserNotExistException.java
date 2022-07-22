package com.wushanghui.springboot.exception;

/**
 * @author：Administrator
 * @date：2019/2/6
 * @describe：
 */
public class UserNotExistException extends RuntimeException {

    public UserNotExistException() {
        super("用户不存在！");
    }
}

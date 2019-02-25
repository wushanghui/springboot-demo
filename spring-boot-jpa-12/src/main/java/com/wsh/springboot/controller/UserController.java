package com.wsh.springboot.controller;

import com.wsh.springboot.entity.User;
import com.wsh.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author jue
 * @date 2019/2/24 16:21
 * @describe
 */
@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/getUserById/{id}")
    @ResponseBody
    public User getUserById(@PathVariable("id") Integer id) {
        //此处用getOne() 会报错
        User user = userRepository.findOne(id);
        return user;
    }

    @GetMapping("/saveUser")
    @ResponseBody
    public User saveUser(User user) {
        return userRepository.save(user);
    }
}

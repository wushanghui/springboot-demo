package com.wushanghui.springboot.controller;

import com.wushanghui.springboot.bean.Department;
import com.wushanghui.springboot.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author jue
 * @date 2019/2/17 20:10
 * @describe
 */
@Controller
public class DepartmentController {

    @Autowired
    DepartmentMapper departmentMapper;

    @GetMapping("/dept/{id}")
    @ResponseBody
    public Department getDeptById(@PathVariable("id") Integer id) {
        return departmentMapper.getDeptById(id);
    }

    @GetMapping("/dept")
    @ResponseBody
    public Department insertDept(Department department) {
        departmentMapper.addDept(department);
        return department;
    }
}

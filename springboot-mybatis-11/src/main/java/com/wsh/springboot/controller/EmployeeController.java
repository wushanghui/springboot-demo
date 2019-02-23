package com.wsh.springboot.controller;

import com.wsh.springboot.bean.Employee;
import com.wsh.springboot.mapper.EmploymentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author jue
 * @date 2019/2/18 23:21
 * @describe
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmploymentMapper employmentMapper;

    @GetMapping("/emp/{id}")
    @ResponseBody
    public Employee getEmp(@PathVariable("id") Integer id) {
        Employee emp = employmentMapper.getEmpById(id);
        return emp;
    }

}

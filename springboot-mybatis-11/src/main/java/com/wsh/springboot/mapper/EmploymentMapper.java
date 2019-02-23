package com.wsh.springboot.mapper;

import com.wsh.springboot.bean.Employee;

/**
 * @author jue
 * @date 2019/2/23 14:20
 * @describe
 */
public interface EmploymentMapper {

    public Employee getEmpById(Integer id);
}

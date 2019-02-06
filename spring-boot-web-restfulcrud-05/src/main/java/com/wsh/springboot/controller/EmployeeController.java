package com.wsh.springboot.controller;

import com.wsh.springboot.dao.DepartmentDao;
import com.wsh.springboot.dao.EmployeeDao;
import com.wsh.springboot.entities.Department;
import com.wsh.springboot.entities.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.Collection;

/**
 * @author：Administrator
 * @date：2019/2/5
 * @describe：
 */
@Controller
public class EmployeeController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;
    /**
     * 查询出所有员工并返回列表页面
     * @param modelMap model
     * @return
     */
    @GetMapping("/emps")
    public String emps(ModelMap modelMap) {
        Collection<Employee> employees = employeeDao.getAll();
        modelMap.addAttribute("emps", employees);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toEmp(Model model) {
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/add";
    }

    /**
     * 员工添加
     * @return
     */
    @PostMapping("/emp")
    public String addEmp(Employee employee) {
        logger.info("新增，保存的员工信息：{}", employee);
        //保存员工
        employeeDao.save(employee);
        //来到员工列表页面
        //redirect：表示重定向到一个地址， /代表当前项目路径
        //forward：表示转发到一个地址
        return "redirect:/emps";
    }

    /**
     * 去修改页面
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, ModelMap model) {
        //员工信息
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp", employee);
        //页面要展示的部门列表
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        //回到修改页面（新增和修改用一个页面）
        return "emp/add";
    }

    /**
     * 修改员工
     * @param employee
     * @return
     */
    @PutMapping("/emp")
    public String updateEmp(Employee employee) {
        logger.info("要修改的员工信息为：{}", employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    /**
     * 员删除
     * @param id 员工id
     * @return 页面
     */
    @DeleteMapping("/emp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id) {
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}


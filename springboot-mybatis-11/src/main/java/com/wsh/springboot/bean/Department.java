package com.wushanghui.springboot.bean;

/**
 * @author jue
 * @date 2019/2/17 19:26
 * @describe
 */
public class Department {
    private Integer id;
    private String departmentName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}

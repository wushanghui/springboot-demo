package com.wushanghui.springboot.mapper;

import com.wushanghui.springboot.bean.Department;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author jue
 * @date 2019/2/17 20:02
 * @describe
 */
//@Mapper 也可以在application里面加入 @MappperScan 注解，扫描固定包下的所有文件
public interface DepartmentMapper {

    @Select("select * from department where id=#{id}")
    public Department getDeptById(Integer id);
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into department(department_name) values(#{departmentName})")
    public int addDept(Department department);
    @Update("update department set department_name=#{departmentName} where id=#{id}")
    public int updateDeptById(Department department);
    @Delete("delete from department t where t.id=#{id}")
    public int deleteDeptById(Integer id);
}

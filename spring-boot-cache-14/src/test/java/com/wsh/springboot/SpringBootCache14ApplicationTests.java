package com.wushanghui.springboot;

import com.alibaba.fastjson.JSON;
import com.wushanghui.springboot.bean.Department;
import com.wushanghui.springboot.bean.Employee;
import com.wushanghui.springboot.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootCache14ApplicationTests {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    EmployeeMapper employeeMapper;

    @Test
    public void testStringRedisTemplate() {
        //str
//        stringRedisTemplate.opsForValue().set("msg","hello");
//        String msg = stringRedisTemplate.opsForValue().get("msg");
//        System.out.println(msg);
        stringRedisTemplate.opsForList().leftPush("list", "1");
        stringRedisTemplate.opsForList().leftPush("list", "2");
    }

    @Test
    public void testRedisTemplate() {
        Employee emp = employeeMapper.getEmpById(1);
        //默认保存对象使用jdk序列化规则
        redisTemplate.opsForValue().set("emp", emp);
        String jsonStr = JSON.toJSONString(emp);
        System.out.println(jsonStr);
        redisTemplate.opsForValue().set("emp2", jsonStr);
        Department department = new Department();
        department.setDepartmentName("软件创新部");
        department.setId(1);
        redisTemplate.opsForValue().set("department", department);
    }

}

package com.wsh.springboot.service;

import com.wsh.springboot.bean.Department;
import com.wsh.springboot.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.stereotype.Service;

@CacheConfig(cacheNames="dept" ,cacheManager = "deptCacheManager") //抽取缓存的公共配置
@Service
public class DeptService {

    @Autowired
    DepartmentMapper departmentMapper;

    //Qualifier 指定缓存管理器名
//    @Qualifier("deptCacheManager")
//    @Autowired
//    RedisCacheManager deptCacheManager;


    /**
     *  缓存的数据能存入redis；
     *  第二次从缓存中查询就不能反序列化回来；
     *  存的是dept的json数据;CacheManager默认使用RedisTemplate<Object, Employee>操作Redis
     * @param id
     * @return
     */
    @Cacheable(cacheNames = "dept"/*,cacheManager = "deptCacheManager"*/)
    public Department getDeptById(Integer id){
        System.out.println("查询部门"+id);
        Department department = departmentMapper.getDeptById(id);
        return department;
    }

    // 使用缓存管理器得到缓存，进行api调用
//    public Department getDeptById(Integer id){
//        System.out.println("查询部门"+id);
//        Department department = departmentMapper.getDeptById(id);
//
//        //获取某个缓存
//        Cache dept = deptCacheManager.getCache("dept");
//        dept.put("dept:1",department);
//
//        return department;
//    }


}

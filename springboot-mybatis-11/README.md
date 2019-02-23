# springboot整合mybatis
## 1 导入依赖
```xml
<dependency>        
    <groupId>org.mybatis.spring.boot</groupId>            
    <artifactId>mybatis‐spring‐boot‐starter</artifactId>            
    <version>1.3.1</version>            
</dependency> 
```
## 2 注解版
```java
@Mapper
public interface DepartmentMapper(){}

//也可在application启动类上加入 @MapperScan(value = "com.wsh.springboot.mapper")
```
## 3 配置文件版
在application.yml 文件中配置：
```yaml
mybatis:
  config‐location: classpath:mybatis/mybatis‐config.xml 指定全局配置文件的位置
  mapper‐locations: classpath:mybatis/mapper/*.xml  指定sql映射文件的位置
```
mybatis‐config.xml 配置文件：
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
<settings>
    <setting name="mapUnderscoreToCamelCase" value="true"/>
</settings>
</configuration>
```

mapper xml 文件：
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.wsh.springboot.mapper.EmploymentMapper">
    <select id="getEmpById" resultType="com.wsh.springboot.bean.Employee">
        select * from employee where id = #{id}
    </select>
    <insert id="insertEmp">
        insert into employee(lastName, email, gender, d_id) values (#{laseNmae},#{emal},#{gender},#{dId})
    </insert>
</mapper>
```
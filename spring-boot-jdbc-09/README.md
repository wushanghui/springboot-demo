# 1、jdbc
## jdbc以及mysql驱动依赖
```properties
<dependency>
    <groupId>org.springframework.boot</groupId>            
    <artifactId>spring‐boot‐starter‐jdbc</artifactId>            
</dependency>        
<dependency>        
    <groupId>mysql</groupId>            
    <artifactId>mysql‐connector‐java</artifactId>            
    <scope>runtime</scope>            
</dependency>
```
## application.yml 文件配置连接数据库
```yaml
spring:
  datasource:
    username: root
    password: 123456
    url: jdbc:mysql://192.168.15.22:3306/jdbc
    driver‐class‐name: com.mysql.jdbc.Driver
```
## 应用启动自动运行的脚本规则
`schema‐*.sql、data‐*.sql`
默认规则：`schema.sql，schema‐all.sql`

自定义sql
```yaml  
schema:    
      ‐ classpath:department.sql
      #指定位置
```
# 2、整合Druid数据源

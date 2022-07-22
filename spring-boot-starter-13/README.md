# 自定义starter
## 启动器（starter）
- 启动器模块是一个空 JAR 文件，仅提供辅助性依赖管理，这些依赖可能用于自动
装配或者其他类库
- 命名规约：
推荐使用以下命名规约:
1. 官方命名空间
前缀：“spring-boot-starter-”<br/>
模式：spring-boot-starter-模块名<br/>
举例：spring-boot-starter-web、spring-boot-starter-actuator、spring-boot-starter-jdbc<br/>
2. 自定义命名空间
后缀：“-spring-boot-starter”<br/>
模式：模块-spring-boot-starter<br/>
举例：mybatis-spring-boot-starter<br/>
首先建一个空工程，比如：spring-boot-starter-13

## 具体步骤 
在空工程里面再建三个工程：<br/>
1、maven工程<br/>
wsh-spring-boot-starter 让其他工程依赖的 starter<br/>
依赖自动配置模块
```xml
<!-- 启动器 -->
<dependencies>
    <!-- 引入自动配置模块 -->
    <dependency>
        <groupId>com.wushanghui.starter</groupId>
        <artifactId>wsh-spring-boot-starter-autoconfigurer</artifactId>
        <version>0.0.1-SNAPSHOT</version>
    </dependency>
</dependencies>
```
2、spring boot 模块<br/>
wsh-spring-boot-starter-autoconfigurer 自动配置工程<br/>
引入starter的基本配置或者其他等
```xml
<!--引入spring‐boot‐starter；所有starter的基本配置 -->
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter</artifactId>
    </dependency>
</dependencies>
```
3、spring boot 模块<br/>
spring-boot-starter-test 测试模块<br/>
依赖自定义的starter 坐标
```xml
<!-- 引入自定义的starter -->
<dependency>
    <groupId>com.wushanghui.starter</groupId>
    <artifactId>wsh-spring-boot-starter</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```
## 其他
- 自动装配使用配置类（@Configuration）结合Spring4 提供的条件判断注解
@Conditional及Spring Boot的派生注解如@ConditionOnClass完成；
- 配置自动装配Bean；
将标注@Configuration的自动配置类，放在classpath下META-INF/spring.factories文件中
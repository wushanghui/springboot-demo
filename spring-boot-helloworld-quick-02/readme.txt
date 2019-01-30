Spring Initializer快速创建项目
默认生成的Spring Boot项目；
主程序已经生成好了，我们只需要我们自己的逻辑
resources文件夹中目录结构
static：保存所有的静态资源； js css images；
templates：保存所有的模板页面；（Spring Boot默认jar包使用嵌入式的Tomcat，默认不支持JSP页
面）；可以使用模板引擎（freemarker、thymeleaf）；
application.properties：Spring Boot应用的配置文件；可以修改一些默认设置；
比如修改默认的端口号：server.port=9090
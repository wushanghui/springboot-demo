package com.wushanghui.springbootextensionpoint.extension;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 用于在刷新之前初始化 Spring ConfigurableApplicationContext的回调接口。
 * 通常在需要对应用程序上下文进行一些编程初始化的 Web 应用程序中使用。例如，针对上下文环境注册属性源或激活配置文件。请参阅ContextLoader和FrameworkServlet支持以分别声明“contextInitializerClasses”上下文参数和初始化参数。
 * 鼓励ApplicationContextInitializer处理器检测 Spring 的Ordered接口是否已实现或是否存在@Order注释，并在调用之前对实例进行相应的排序。
 * 自从：
 * 3.1
 * 也可以看看：
 * org.springframework.web.context.ContextLoader.customizeContext , org.springframework.web.context.ContextLoader.CONTEXT_INITIALIZER_CLASSES_PARAM , org.springframework.web.servlet.FrameworkServlet.setContextInitializerClasses , org.springframework.web.servlet.FrameworkServlet.applyInitializers
 *
 * @author 吴尚慧
 * @since 2022/8/12 9:56
 */
public class ApplicationContextInitializerTest implements ApplicationContextInitializer {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("[ApplicationContextInitializer] initialize");
    }
}

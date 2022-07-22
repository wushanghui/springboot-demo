package com.wushanghui.springboot.config;

import com.wushanghui.springboot.component.LoginHandlerInterceptor;
import com.wushanghui.springboot.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author：Administrator
 * @date：2019/2/4
 * @describe：
 */
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter{

    //方法一
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        super.addViewControllers(registry);
        //浏览器发送的wsh请求来到success
        registry.addViewController("/wsh").setViewName("success");
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
        registry.addViewController("/main.html").setViewName("dashboard");
    }

    //方法二
    //所有的WebMvcConfigurerAdapter 组件一起生效
//    @Bean //将组件注册到容器中
//    public WebMvcConfigurerAdapter webMvcConfigurerAdapter() {
//        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
//            @Override
//            public void addViewControllers(ViewControllerRegistry registry) {
//                registry.addViewController("/").setViewName("login");
//                registry.addViewController("/login").setViewName("login");
//                registry.addViewController("/index").setViewName("login");
//                registry.addViewController("/login.html").setViewName("login");
//            }
//        };
//        return adapter;
//    }

    /**
     * 把我们定义的区域信息解析器注册到容器中
     * @return
     */
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        super.addInterceptors(registry);
        //springboot已经做好了对静态资源的映射，这里只需要拦截请求
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/index.html", "/", "/user/login");
    }
}

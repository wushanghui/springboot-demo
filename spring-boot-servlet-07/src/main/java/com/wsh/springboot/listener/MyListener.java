package com.wushanghui.springboot.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author：Administrator
 * @date：2019/2/7
 * @describe：
 */
public class MyListener implements ServletContextListener {
    private static final Logger logger = LoggerFactory.getLogger(MyListener.class);
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        logger.info("contextInitialized...web应用启动");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        logger.info("contextDestroyed...当前web项目销毁");
    }
}

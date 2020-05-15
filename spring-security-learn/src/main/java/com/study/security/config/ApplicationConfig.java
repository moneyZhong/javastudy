package com.study.security.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;


/**
 * 对应web.xml 中的ContextLoaderListener
 */
@Configuration
@ComponentScan(basePackages = "com.study.security",
excludeFilters = {@ComponentScan.Filter(type= FilterType.ANNOTATION,value= Controller.class)})
public class ApplicationConfig {
    //此处配置除Controller的其他bean, 如： 数据库连接池，事务管理器，业务bean等
}

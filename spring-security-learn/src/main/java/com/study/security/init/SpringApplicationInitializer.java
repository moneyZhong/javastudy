package com.study.security.init;

import com.study.security.config.ApplicationConfig;
import com.study.security.config.SecurityConfig;
import com.study.security.config.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
/**
 * web.xml
 *
 * <context-param>
 *     <param-name>contextConfigLocation</param-name>
 *     <param-value>classpath*:spring/applicationcontext-*.xml</param-value>
 * </context-param>
 *
 * <listener>
 *     <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
 * </listener>
 *
 * <filter>
 *     <filter-name>encodingFilter</filter-name>
 *     <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
 *     <init-param>
 *         <param-name>encoding</param-name>
 *         <param-value>UTF-8</param-value>
 *     </init-param>
 *     <init-param>
 *         <param-name>forceEncoding</param-name>
 *         <param-value>true</param-value>
 *     </init-param>
 * </filter>
 * <filter-mapping>
 *     <filter-name>encodingFilter</filter-name>
 *     <url-pattern>/*</url-pattern>
 * </filter-mapping>
 *
 * <servlet>
 *     <servlet-name>springmvc</servlet-name>
 *     <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
 *     <init-param>
 *         <param-name>contextConfigLocation</param-name>
 *         <param-value>classpath*:spring/springmvc-context.xml</param-value>
 *     </init-param>
 *     <load-on-startup>1</load-on-startup>
 * </servlet>
 * <servlet-mapping>
 *     <servlet-name>springmvc</servlet-name>
 *     <url-pattern>/</url-pattern>
 * </servlet-mapping>
 */


/**
 * 相当于web.xml
 *
 */
public class SpringApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{ApplicationConfig.class, SecurityConfig.class};//applicationContext.xml
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};//springmvc.xml
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}

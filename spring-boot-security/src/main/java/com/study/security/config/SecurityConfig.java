package com.study.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * security.xml
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    /**
     * 查询用户信息
     *
     * @return
     */
    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        UserDetails build1 = User.withUsername("zhangsan").password("123").authorities("p1").build();
        UserDetails build2 = User.withUsername("lisi").password("456").authorities("p2").build();

        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(build2);
        manager.createUser(build1);
        return manager;
    }

    //密码编码器
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    //安全拦截机制
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/r/**").authenticated()//所有/r/**的请求必须认证通过
                .anyRequest().permitAll()//除了/r/**的请求都可以访问
                .and()
                .formLogin() //允许表单提交
                .loginPage("/login-view")//指定我们自己的登录页,spring security以重定向方式跳转到/login-view
                .loginProcessingUrl("/login")//指定登录处理的URL，也就是用户名、密码表单提交的目的路径
                .successForwardUrl("/login-success")//指定登录成功后的跳转URL
                .permitAll();//允许 任意用户访问基于表单登录的所有的URL
    }
}

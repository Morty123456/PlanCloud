package org.hg.hystrix.config;

import org.hg.hystrix.filter.MyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

/**
 * @author: wzh
 * @time: 2020/8/9 7:46
 * @description:
 */
@Configuration
public class filterConfig {
    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new MyFilter());
        registrationBean.addUrlPatterns("/*");
//        registrationBean.addInitParameter("paramName","paramValue");
        registrationBean.setName("MyFilter");
        return registrationBean;
    }

    @Bean(name = "myFilter")
    public Filter myFilter() {
        return new MyFilter();
    }
}


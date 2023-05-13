package com.rei.javawithpython.config;


import com.rei.javawithpython.filter.IpAddressFilter;
import com.rei.javawithpython.filter.LogApiFilter;
import com.rei.javawithpython.filter.LogProcessTimeFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class FilterConfig {

    //打入的api位址用(不需要的話可以略過，需要的話要追加檔案)
    @Bean
    public FilterRegistrationBean logApiFilter() {
        FilterRegistrationBean<LogApiFilter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new LogApiFilter());
        bean.addUrlPatterns("/*");
        bean.setName("LogApiFilter");
        bean.setOrder(0);

        return bean;
    }

    //計算處理時間用(不需要的話可以略過，需要的話要追加檔案)
    @Bean
    public FilterRegistrationBean logProcessTimeFilter() {
        FilterRegistrationBean<LogProcessTimeFilter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new LogProcessTimeFilter());
        bean.addUrlPatterns("/*");
        bean.setName("logProcessTimeFilter");
        bean.setOrder(1);

        return bean;
    }

    // ip位址
    @Bean
    public FilterRegistrationBean ipAddressFilter() {
        FilterRegistrationBean<IpAddressFilter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new IpAddressFilter());
        bean.addUrlPatterns("/*");
        bean.setName("ipAddressFilter");
        bean.setOrder(2);

        return bean;
    }

    
}

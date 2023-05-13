package com.rei.javawithpython.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class AppConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowCredentials(true)
//                如果需要前後端分離，這裡設定前端port
//                .allowedOriginPatterns("http://localhost:5173/")
                .allowedMethods(new String[]{"GET", "POST", "PUT", "DELETE","OPTIONS","PATCH"})
                .allowedHeaders("*")
                .exposedHeaders("*");
    }
}

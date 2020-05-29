package com.galaxy.easybuy.config;

import com.galaxy.easybuy.component.StringToDate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

import java.util.Date;

@Configuration
public class webConfig {
//    @Bean
//    public WebMvcConfigurer webMvcConfigurer(){
//        return new WebMvcConfigurer() {
//            @Override
//            public void addViewControllers(ViewControllerRegistry registry) {
//                registry.addViewController("/").setViewName("/login");
//                registry.addViewController("/index.html").setViewName("/login");
//            }
//
//            @Override
//            public void addInterceptors(InterceptorRegistry registry) {
//                registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/*")
//                        .excludePathPatterns("/","/index.html","/account/login");
//                registry.addInterceptor(new PrivilegeInterceptor()).addPathPatterns("/*")
//                        .excludePathPatterns("/","/index.html","/account/login","/account/home","/account/logout","/complaint/*");
//            }
//        };
//    }
    @Bean
    public Converter<String, Date> converter(){
        return new StringToDate();
    }

}

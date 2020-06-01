package com.galaxy.easybuy.config;

import com.galaxy.easybuy.component.AccessInterceptor;
import com.galaxy.easybuy.component.StringToDate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Date;

@Configuration
public class webConfig {
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new AccessInterceptor()).addPathPatterns("/**");
            }
        };
    }
    @Bean
    public Converter<String, Date> converter(){
        return new StringToDate();
    }

}

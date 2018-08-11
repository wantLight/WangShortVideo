package com.imooc;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by xyzzg on 2018/8/11.
 */
@Configuration
public class WebMvcConfiger extends WebMvcConfigurerAdapter{
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //资源映射
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/META-INF/resources/")
                .addResourceLocations("file:D:/imooc_videos_dev/");
    }
}

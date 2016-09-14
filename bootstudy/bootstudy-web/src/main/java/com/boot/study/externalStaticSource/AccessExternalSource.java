package com.boot.study.externalStaticSource;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * spring boot默认静态资源访问路径为 classpath下 public static resources META-INF/resources，且优先级依次由低到高 下面为自定义访问静态资源的方法
 * 
 * @author Administrator
 */
// @Configuration 注册bean 优先级比component高
@Component
public class AccessExternalSource extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 访问相对路径 即 classpath下的静态资源（非spring boot 默认加载的目录）
        registry.addResourceHandler("/bootTest/**").addResourceLocations("classpath:/bootTest/").addResourceLocations("classpath:/public/");
        // 访问绝对路径下的静态资源
        // registry.addResourceHandler("/bootTest/**").addResourceLocations("file:C:/Users/Administrator/Desktop/");
        super.addResourceHandlers(registry);
    }

}

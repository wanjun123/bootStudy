package com.boot.study;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.boot.study.util.SpringUtil;


@SpringBootApplication
@Import({ SpringUtil.class })
@ComponentScan(basePackages = { "com.boot" })
public class App extends WebMvcConfigurerAdapter {

    // @Bean
    // public HttpMessageConverters fastJsonHttpMessageConverters() {
    // FastJsonHttpMessageConverter fastJson = new FastJsonHttpMessageConverter();
    // fastJson.setFeatures(SerializerFeature.PrettyFormat);
    // return new HttpMessageConverters(fastJson);
    // }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        FastJsonHttpMessageConverter fastJsonConverter = new FastJsonHttpMessageConverter();
        fastJsonConverter.setFeatures(SerializerFeature.PrettyFormat);
        converters.add(fastJsonConverter);
    }
}

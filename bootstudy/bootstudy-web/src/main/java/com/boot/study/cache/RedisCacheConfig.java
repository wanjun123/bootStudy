package com.boot.study.cache;

import java.nio.charset.Charset;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@EnableCaching
public class RedisCacheConfig extends CachingConfigurerSupport {

    /**
     * 缓存管理器
     * 
     * @param template
     * @return
     */
    @Bean
    public CacheManager cacheManager(RedisTemplate<?, ?> template) {
        CacheManager cacheManager = new RedisCacheManager(template);
        return cacheManager;
    }

    /**
     * redis模板工具类
     * 
     * @param factory
     * @return
     */
    @Bean
    @Primary
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, String> template = new RedisTemplate<String, String>();
        // Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        // ObjectMapper objectMapper = new ObjectMapper();
        // objectMapper.setVisibility(PropertyAccessor.ALL,
        // com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY);
        // jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
        // template.setValueSerializer(jackson2JsonRedisSerializer);
        StringRedisSerializer serializer = new StringRedisSerializer(Charset.forName("utf-8"));
        template.setKeySerializer(serializer);
        template.setValueSerializer(serializer);
        template.setHashKeySerializer(serializer);
        template.setHashValueSerializer(serializer);
        template.setConnectionFactory(factory);
        return template;
    }

    // @Override
    // public KeyGenerator keyGenerator() {
    // return new KeyGenerator() {
    //
    // @Override
    // public Object generate(Object target, Method method, Object... aobj) {
    // StringBuilder sb = new StringBuilder();
    // sb.append(target.getClass().getName());
    // sb.append(method.getName());
    // for (Object obj : aobj) {
    // sb.append(obj.toString());
    // }
    // System.out.println("key generator -->" + sb.toString());
    // return sb.toString();
    // }
    // };
    // }

}

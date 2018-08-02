package deki.com.springbootcache.config;

import deki.com.springbootcache.entity.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.net.UnknownHostException;


@Configuration
public class RedisConfig {


    @Bean
    public RedisTemplate<Object, Person> redisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
        RedisTemplate<Object, Person> template = new RedisTemplate<Object, Person>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<Person> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Person>(Person.class);
        template.setDefaultSerializer(jackson2JsonRedisSerializer);
        return template;
    }

    /**
     * 自定制RedisCacheManager规则，使得缓存的为json
     */
//    @Bean
//    public RedisCacheManager redisCacheManager(RedisTemplate<Object, Person> redisTemplate){
//        RedisCacheManager redisCacheManager = RedisCacheManager.builder(redisTemplate.getConnectionFactory()).build();
//        return redisCacheManager;
//    }
}

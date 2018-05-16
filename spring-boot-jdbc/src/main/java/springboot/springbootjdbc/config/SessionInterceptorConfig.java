package springboot.springbootjdbc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import springboot.springbootjdbc.interceptor.SessionInterceptor;

/**
 * 配置信息类，添加@Configuration注解让SpringBoot自动加载类内的配置，
 * 有一点要注意我们继承了WebMvcConfigurerAdapter这个类，
 * 这个类是SpringBoot内部提供专门处理用户自行添加的配置，里面不仅仅包含了修改视图的过滤还有其他很多的方法，包括我们后面章节要讲到的拦截器，过滤器，Cors配置等。
 * WebMvcConfigurerAdapter过时问题
 * Spring boot2.0使用的是Spring5.0,spring5.0认为WebMvcConfiguerAdapter失效，使用WebMvcConfigurationSupport来代替或者WebMvcConfigurer（推荐）
 * https://blog.csdn.net/Hedy17/article/details/79869002
 */

@Configuration
public class SessionInterceptorConfig implements WebMvcConfigurer {

    @Bean
    public SessionInterceptor sessionInterceptor(){
        return new SessionInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(sessionInterceptor()).addPathPatterns("/**");
    }
}

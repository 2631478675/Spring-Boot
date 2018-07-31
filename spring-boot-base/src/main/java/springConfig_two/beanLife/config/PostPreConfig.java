package springConfig_two.beanLife.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springConfig_two.beanLife.service.BeanWayService;
import springConfig_two.beanLife.service.JSR250WayService;

@Configuration
@ComponentScan("springConfig_two.beanLife")
public class PostPreConfig {
    @Bean(initMethod = "init" ,destroyMethod = "destory")
    BeanWayService beanWayService(){
        return new BeanWayService();
    }
    @Bean
    JSR250WayService jsr250WayService(){
        return new JSR250WayService();
    }
}

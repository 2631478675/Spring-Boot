package springBase_one.Ioc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springBase_one.Ioc.service.NoAnnoService;
import springBase_one.Ioc.service.UseNoAnnoService;

@Configuration   //表示此bean是一个配置类
public class NoAnnoConfig {

    @Bean //bean注解的使用：定义bean
    public NoAnnoService noAnnoService(){
        return new NoAnnoService();
    }
    @Bean
    public UseNoAnnoService useNoAnnoService(){
        UseNoAnnoService useNoAnnoService=new UseNoAnnoService();
        useNoAnnoService.setNoAnnoService(noAnnoService());
        return useNoAnnoService;
    }

}

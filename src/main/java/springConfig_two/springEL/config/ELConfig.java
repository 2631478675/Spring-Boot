package springConfig_two.springEL.config;


import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

import java.io.IOException;

/**
 * 注入Properties的方法：①：使用@value注入，配置PropertySourcesPlaceholderConfigurer的bean
 * ②使用org.springframework.core.env.Environment;注入 获取使用environment.getProperty("github.url")
 */
@Configuration
@ComponentScan("springConfig_two.springEL")

//使用@PropertySource指定配置文件的位置
@PropertySource("classpath:springEL.properties")
public class ELConfig {

    @Value("I love you!")
    private String normal;

    //注入操作系统属性
    @Value("#{systemProperties['os.name']}")
    private String osName;

    //注入表达式结果
    @Value("#{ T(java.lang.Math).random() * 100.0 }")
    private double randomNumber;

    //注入其他Bean属性
    @Value("#{stringService.string}")
    private String fromAnother;

    //注入文件资源
    @Value("classpath:springEL.txt")
    private Resource testFile;

    //注入网址资源
    @Value("http://www.baidu.com")
    private Resource testUrl;

    //注入配置文件 使用@Value注入，则需要配置一个PropertySourcesPlaceholderConfigurer
    //此处使用 $ 不使用 #
    @Value("${github.name}")
    private String githubName;

    //注入配置文件
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    //注入配置文件 注入Properties可以从Environment中获得
    @Autowired
    private Environment environment;


    public void outputResource() {
        try {
            System.out.println(normal);
            System.out.println(osName);
            System.out.println(randomNumber);
            System.out.println(fromAnother);
            System.out.println(IOUtils.toString(testFile.getInputStream()));
            System.out.println(IOUtils.toString(testFile.getInputStream()));
            System.out.println(githubName);
            System.out.println(environment.getProperty("github.url"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

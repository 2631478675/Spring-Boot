package controller.springbootbase.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ConfigurationProperties注解：加载properties文件内的配置
 * 常用属性：
 * ①prefix 指定配置的前缀
 * ②locations指定properties文件的位置，不过在springboot1.5之后不再使用，使用@PropertySource代替
 */
@Component
@ConfigurationProperties(prefix = "author")
public class Pojo {
    private String name;
    private Long age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }
}

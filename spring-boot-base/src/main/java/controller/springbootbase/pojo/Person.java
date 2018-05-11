package controller.springbootbase.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * give an example for yml
 */


/**
 * 将配置文件中的属性的值，映射到这个组件中
 *@ConfigurationProperties(prefix ="person")
 * 或者使用注解@Value代替
 *
 * 如果说，我们只是在某个业务逻辑中需要获取一下配置文件中的某项值，使用@Value；
 * 如果说，我们专门编写了一个javaBean来和配置文件进行映射，我们就直接使用@ConfigurationProperties；
 */
@Component
@PropertySource(value = {"classpath:person.properties"})
@ConfigurationProperties(prefix ="person")  //默认在全局配置文件（application.properties）中获取值  使用注解>>>@@PropertySource来破解，嘿嘿
@Validated
public class Person {
    //lastName必须是邮箱格式
    // @Email
    //@Value("${person.last-name}")
    private String lastName;
    //@Value("#{11*2}")
    private Integer age;
    //@Value("true")
    private Boolean boss;

    private Date birth;
    //@Value("${person.maps}")
    private Map<String,Object> maps;
    private List<Object> lists;
    private Dog dog;


    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                ", boss=" + boss +
                ", birth=" + birth +
                ", maps=" + maps +
                ", lists=" + lists +
                ", dog=" + dog +
                '}';
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getBoss() {
        return boss;
    }

    public void setBoss(Boolean boss) {
        this.boss = boss;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<Object> getLists() {
        return lists;
    }

    public void setLists(List<Object> lists) {
        this.lists = lists;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }
}

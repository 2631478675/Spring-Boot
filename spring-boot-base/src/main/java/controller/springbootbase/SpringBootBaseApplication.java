package controller.springbootbase;

import controller.springbootbase.pojo.Pojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @SpringBootApplication组合注解：其中一个元注解@EnableAutoConfiguration
 * 此元注解：添加包（如spring-boot-starter-web）的依赖，spring boot会自动对Tomcat和springmvc进行自动配置
 */
@RestController
@SpringBootApplication
public class SpringBootBaseApplication {

	@Autowired
	private Pojo pojo;

	//因为
	@RequestMapping("/")
	public String index(){
		return "author name is "+pojo.getName();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBaseApplication.class, args);
	}
}
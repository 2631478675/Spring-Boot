package springboot.springbootwebatguigu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;

@SpringBootApplication
@EnableAutoConfiguration
public class SpringBootWebAtguiguApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebAtguiguApplication.class, args);
	}

}

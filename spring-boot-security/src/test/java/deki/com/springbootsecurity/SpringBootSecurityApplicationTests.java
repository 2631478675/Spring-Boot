package deki.com.springbootsecurity;

import deki.com.springbootsecurity.entity.User;
import deki.com.springbootsecurity.service.AuthService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootSecurityApplicationTests {

	@Autowired
	AuthService authService;

	User user = new User("刘元林","123456");

	@Test
	public void contextLoads() {
		authService.register(user);
	}

}

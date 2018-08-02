package deki.com.springbootcache;

import deki.com.springbootcache.entity.Person;
import deki.com.springbootcache.repository.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootCacheApplicationTests {

//	@Autowired
//	RedisTemplate redisTemplate;

	@Autowired
	PersonRepository personRepository;

	@Autowired
	RedisTemplate<Object, Person> redisTemplate;

	@Test
	public void contextLoads() {
		Person person = personRepository.getOne((long) 1);
		redisTemplate.opsForValue().set("findByName[合肥]",person);
	}

}

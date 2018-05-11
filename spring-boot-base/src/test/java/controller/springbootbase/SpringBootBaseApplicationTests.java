package controller.springbootbase;

import controller.springbootbase.pojo.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * spring boot 单元测试
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootBaseApplicationTests {

	Logger logger= LoggerFactory.getLogger(getClass());
	@Autowired
	Person person;

	@Autowired
	ApplicationContext ioc;
	@Test
	public void testImportSource(){
		boolean b=ioc.containsBean("testImportResouceService");
		System.out.println(b);
	}
	@Test
	public void contextLoads() {
		System.out.println(person);

		//测试日志
		logger.trace("trace日志");
		logger.debug("debug日志");
		logger.info("info日志");
		logger.warn("warn日志");
		logger.error("error日志");
	}

}

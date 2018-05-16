package springboot.springbootjdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import springboot.springbootjdbc.dao.UserDao;
import springboot.springbootjdbc.service.UserService;

import javax.sql.DataSource;
import java.awt.print.Printable;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 数据库连接池：jdbc和druid，HikariDataSource
 * 何为数据池？负责管理、分配、释放数据库连接 reference https://www.waitig.com/jdbc-%E5%AD%A6%E4%B9%A0%E7%AC%94%E8%AE%B0%EF%BC%88%E4%B8%89%EF%BC%89%E6%95%B0%E6%8D%AE%E6%BA%90%E4%B8%8E%E8%BF%9E%E6%8E%A5%E6%B1%A0.html
 *  spring boot2.0以上默认使用HikariDataSource
 *  class org.apache.tomcat.jdbc.pool.DataSource,2.0以下默认使用数据源
 *  但是！这是使用Durid数据源，首先去.yml配置文件中配置
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootJdbcApplicationTests {


	//测试数据源

	@Autowired
	DataSource dataSource;

	@Autowired
	UserService userService;
	@Test
	public void contextLoads() throws Exception {

		//getClass()获得对象的类的信息
		System.out.println(dataSource.getClass());
		Connection connection=dataSource.getConnection();

		System.out.println(connection.getClass().getName());

		connection.close();

//		System.out.println(userDao.deleteByName("刘元林"));
		System.out.println(userService.findByName("刘元林"));
	}

}

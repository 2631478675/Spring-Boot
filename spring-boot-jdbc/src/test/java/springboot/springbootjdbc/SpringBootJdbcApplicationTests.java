package springboot.springbootjdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import springboot.springbootjdbc.dao.UserDao;

import javax.sql.DataSource;
import java.awt.print.Printable;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 数据库连接池：jdbc和druid
 * 何为数据池？负责管理、分配、释放数据库连接
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootJdbcApplicationTests {


	//测试数据源

	@Autowired
	DataSource dataSource;

	@Autowired
	UserDao userDao;
	@Test
	public void contextLoads() throws Exception {

		System.out.println(dataSource.getClass());
		Connection connection=dataSource.getConnection();

		System.out.println(connection);

		connection.close();

		System.out.println(userDao.findByName("刘元林"));
	}

}

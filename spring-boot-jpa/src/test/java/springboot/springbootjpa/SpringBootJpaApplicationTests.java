package springboot.springbootjpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootJpaApplicationTests {

	private final static Logger  LOGGER = LoggerFactory.getLogger(SpringBootJpaApplicationTests.class);

	@Autowired
	DataSource dataSource;
	@Test
	public void contextLoads() throws SQLException {

		LOGGER.info(String.valueOf(dataSource.getClass()));
		Connection connection = dataSource.getConnection();
		System.out.println(connection.getClass().getName());
		LOGGER.info(connection.getClass().getName());
		connection.close();
	}

}

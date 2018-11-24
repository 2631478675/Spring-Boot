package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {


	@Autowired
	private DataSourceConfig dataSourceConfig;


	@Test
	public void contextLoads() throws Exception {

		foundDataSourceParameter(dataSourceConfig.getTomcat());
	}

	public static void foundDataSourceParameter(Map<String, Object> parameters) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
		Class c = Class.forName("org.apache.tomcat.jdbc.pool.DataSource").getSuperclass();
		Object invokertester = c.newInstance();
		List nameList = Arrays.asList(new String[]{"MinIdle", "TestOnBorrow", "TestWhileIdle", "TimeBetweenEvictionRunsMillis", "MinEvictableIdleTimeMillis"});

		Iterator entries = parameters.entrySet().iterator();

		while (entries.hasNext()) {
			Map.Entry entry = (Map.Entry) entries.next();
			String key = (String) entry.getKey();
			if (nameList.contains(key)) {
				String methodName = "set" + key;
				Object value = entry.getValue();

				Method publicMethod = null;

				if (value.getClass().getName().equals("java.lang.Boolean")) {
					publicMethod = c.getDeclaredMethod(methodName, boolean.class);

				} else
					publicMethod = c.getDeclaredMethod(methodName, int.class);
				publicMethod.invoke(invokertester, value);
			}
		}


	}
}

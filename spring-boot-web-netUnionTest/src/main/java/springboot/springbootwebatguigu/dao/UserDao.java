package springboot.springbootwebatguigu.dao;

import org.springframework.stereotype.Repository;
import springboot.springbootwebatguigu.Pojo.User;

import java.util.HashMap;
import java.util.Map;

/**
 * 模拟数据库
 */
@Repository
public class UserDao {

    private static Map<String, User> users= null;

	static{
		users = new HashMap<>();
		users.put("刘元林",new User("刘元林","123456","12345678901","22222@qq.com"));
	}

	private static Integer initId = 1;

    public void save(User user){
        if(user.getId()==0){
            user.setId(initId++);
        }
        users.put(user.getUsername(),user);
    }

    public User getByName(String username){
        return  users.get(username);
    }

    public void getAll(){
        System.out.println(users);
    }
}

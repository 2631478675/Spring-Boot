package springboot.springbootjdbc.dao;

import springboot.springbootjdbc.Pojo.User;

import java.sql.SQLException;
import java.util.List;


public interface UserDao {

    void save(User user);

    void update(User user);

    User findByName(String name);

    List<User> finfAll() ;

    boolean deleteByName(String name);

}

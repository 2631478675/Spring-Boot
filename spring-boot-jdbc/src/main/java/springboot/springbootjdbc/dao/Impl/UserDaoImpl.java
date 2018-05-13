package springboot.springbootjdbc.dao.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import springboot.springbootjdbc.Pojo.User;
import springboot.springbootjdbc.dao.UserDao;

import java.sql.SQLException;
import java.util.List;


/*
https://blog.csdn.net/changemyself/article/details/1341599
 */
//接口存在两个实现类的时候必须使用@Qualifier指定注入哪个实现类
@Repository
public class UserDaoImpl implements UserDao {

    /**
     * jdbcTemplate的使用：不支持级联使用，常常和mybatis混用
     */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public RowMapper<User> getRowMapper() {
        return new BeanPropertyRowMapper<>(User.class);
    }
    @Override
    public void save(User user) {


    }

    @Override
    public void update(User user) {

    }
    //user_id id,user_name username,user_password password, user_phone phoneNumber,user_email email
    @Override
    public User findByName(String name) throws Exception{
        String sql="select *  from user where user_name = ?";
        System.out.println(jdbcTemplate.queryForObject(sql,getRowMapper(),name));
        return jdbcTemplate.queryForObject(sql,getRowMapper(),name);
    }

    @Override
    public List<User> finfAll(){
        return null;
    }

    @Override
    public void deleteByName(String name)  {

    }
}

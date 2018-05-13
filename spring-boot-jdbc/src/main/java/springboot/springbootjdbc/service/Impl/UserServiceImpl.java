package springboot.springbootjdbc.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.springbootjdbc.Pojo.User;
import springboot.springbootjdbc.dao.UserDao;
import springboot.springbootjdbc.service.UserService;

import java.sql.SQLException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public User findByName(String name) throws Exception {
//        if(userDao.findByName(name)==null){
////            throws Exception;
//        }
        return userDao.findByName(name);
    }
}

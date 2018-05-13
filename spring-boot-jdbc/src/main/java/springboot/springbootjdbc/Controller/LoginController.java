package springboot.springbootjdbc.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import springboot.springbootjdbc.Pojo.User;
import springboot.springbootjdbc.Response.Response;
import springboot.springbootjdbc.dao.UserDao;
import springboot.springbootjdbc.dao.UserDao_NoMySQL;

import javax.validation.Valid;


@RestController
@CrossOrigin
public class LoginController {

    @Autowired
    UserDao_NoMySQL userDaoNoMySQL;

    @Autowired
    UserDao userDao;
//    @PostMapping(value = "/login")
//    public Response login(@RequestBody User user){
//        String username=user.getUsername();
//        User user_new= userDaoNoMySQL.getByName(username);
//        if(user_new==null){
//            return new Response().failure();
//        }else {
//            if(!StringUtils.isEmpty(user_new.getUsername())&&(user.getPassword()).equals(user_new.getPassword())){
//                return new Response().success();
//            }
//            else {
//                return new Response().failure();
//            }
//        }
//
//    }
//    @PostMapping(value = "/regist")
//    public Response regist(@Valid @RequestBody User user,BindingResult result){
//        if(result.hasErrors()){
//            return new Response().failure();
//        }else {
//            user.setId(0);
//            userDaoNoMySQL.save(user);
//            return new Response().success();
//        }
//
//    }
//    @GetMapping(value = "/getUser")
//    public Response getUserByName(@RequestBody User user){
//        String name=user.getUsername();
//        if(userDao.findByName(name)==null){
//            return new Response().failure();
//        }else {
//            return new Response().success();
//        }
//    }
}

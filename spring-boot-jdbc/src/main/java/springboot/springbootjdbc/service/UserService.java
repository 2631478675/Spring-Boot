package springboot.springbootjdbc.service;


import springboot.springbootjdbc.Pojo.User;



public interface UserService  {

    User findByName(String name) ;
}

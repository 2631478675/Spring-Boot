package deki.com.springbootsecurity.service;

import deki.com.springbootsecurity.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService{
    public User findUserByName (User user);
}

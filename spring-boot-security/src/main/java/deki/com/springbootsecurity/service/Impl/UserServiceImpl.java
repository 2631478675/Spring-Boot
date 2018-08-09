package deki.com.springbootsecurity.service.Impl;

import deki.com.springbootsecurity.entity.User;
import deki.com.springbootsecurity.repository.UserRepository;
import deki.com.springbootsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User findUserByName(User user) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        List<User> user = userRepository.findByUsername(s);
        if(user==null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        return user.get(0);
    }
}

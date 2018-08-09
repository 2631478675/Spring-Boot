package deki.com.springbootsecurity.service.Impl;

import deki.com.springbootsecurity.entity.User;
import deki.com.springbootsecurity.repository.UserRepository;
import deki.com.springbootsecurity.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AuthServiceImpl implements AuthService {

    private AuthenticationManager authenticationManager;
    private UserDetailsService userDetailsService;


    @Autowired
    UserRepository userRepository;

    /**
     * 这里实现的目的就是得到加密后的密码
     * reference ： http://www.spring4all.com/article/421
     * @param userToAdd
     * @return
     */
    @Override
    public User register(User userToAdd) {
        final String username = userToAdd.getUsername();
//        if(userService.findUserByName()username)!=null) {
//            return null;
//        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        final String rawPassword = userToAdd.getPassword();
        userToAdd.setPassword(encoder.encode(rawPassword));
        userToAdd.setLatestTime(new Date());
//        userToAdd.setRoles(asList("ROLE_USER"));
        return userRepository.save(userToAdd);

    }

    @Override
    public String login(String username, String password) {
//        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username, password);
//        // Perform the security
//        final Authentication authentication = authenticationManager.authenticate(upToken);
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        // Reload password post-security so we can generate token
//        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
//        final String token = JWTUtil.generateToken(userDetails);
//        return token;
        return null;
    }

    @Override
    public String refresh(String oldToken) {
        return null;
    }
}

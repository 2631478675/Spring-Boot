package deki.com.springbootsecurity.service;

import deki.com.springbootsecurity.entity.User;

public interface AuthService {
    User register(User userToAdd);
    String login(String username, String password);
    String refresh(String oldToken);

}

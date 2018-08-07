package deki.com.bootredissecuritytoken.dao;

import deki.com.bootredissecuritytoken.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUserNameAndPassword (String username,String password);
    List<User> findByUserName (String username);
}

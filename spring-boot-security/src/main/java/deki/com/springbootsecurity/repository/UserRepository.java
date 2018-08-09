package deki.com.springbootsecurity.repository;

import deki.com.springbootsecurity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long>{
    public List<User> findByUsername (String username);
}

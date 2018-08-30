package springboot.springbootwebatguigu.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot.springbootwebatguigu.Pojo.User;

public interface UserRepositry extends JpaRepository<User, Integer> {
	public User findByUsername(String username);

}

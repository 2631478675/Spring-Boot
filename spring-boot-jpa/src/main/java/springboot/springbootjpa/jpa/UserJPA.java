package springboot.springbootjpa.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import springboot.springbootjpa.entity.User;

import java.util.List;


/**
 * @Transactional，来开启事务自动化管理
 */
@Transactional
public interface UserJPA extends JpaRepository<User,Long> {
    //查询大于20岁的用户

    /**
     * @Query中自定义SQL查询语句，nativeQuery = true则会执行自定义的SQL语句
     * @param age
     * @return
     */
    @Query(value = "select * from user where user_age > ?1",nativeQuery = true)
    public List<User> nativeQuery(int age);



    //根据用户名、密码删除一条数据

    /**
     * @Modifying+@Query不止能完成查询操作还能完成增删改
     * @param name
     * @param pwd
     */
    @Modifying
    @Query(value = "delete from user where user_name = ?1 and user_password = ?2",nativeQuery = true)
    public void deleteQuery(String name,String pwd);
}

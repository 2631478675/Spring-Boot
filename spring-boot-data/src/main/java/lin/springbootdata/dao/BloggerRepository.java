package lin.springbootdata.dao;

import lin.springbootdata.entity.Blogger;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BloggerRepository extends JpaRepository<Blogger,Long> {


    List<Blogger> findByName(String name);
}

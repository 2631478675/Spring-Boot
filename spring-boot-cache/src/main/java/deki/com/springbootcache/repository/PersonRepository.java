package deki.com.springbootcache.repository;

import deki.com.springbootcache.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository  extends JpaRepository<Person,Long>{

    List<Person> findByAddress(String address);

}

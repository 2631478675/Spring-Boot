package deki.com.springboot.dao;

import deki.com.springboot.domain.Person;
import deki.com.springboot.support.CustomRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepositoryWithCustom extends CustomRepository<Person,Long> {
    List<Person> findByAddress(String name);

    Person findByNameAndAddress(String name,String address);

    @Query("select p from Person p where p.name= :name and p.address= :address")
    Person withNameAndAddressQuery(@Param("name")String name, @Param("address")String address);

}

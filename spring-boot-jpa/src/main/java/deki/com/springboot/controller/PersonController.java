package deki.com.springboot.controller;

import deki.com.springboot.dao.PersonRepository;
import deki.com.springboot.dao.PersonRepositoryWithCustom;
import deki.com.springboot.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PersonRepositoryWithCustom personRepositoryWithCustom;

    /**
     * 测试排序
     * @return
     */
    @RequestMapping("/sort")
    public List<Person> sort(){

        List<Person> people = personRepository.findAll(new Sort(Sort.Direction.ASC,"age"));

        return people;

    }

    /**
     * 测试分页
     */
    @RequestMapping("/page")
    public Page<Person> page(){

        Page<Person> pagePeople = personRepository.findAll(new PageRequest(1, 2));

        return pagePeople;

    }


    /**
     * 测试分页
     */
    @RequestMapping("/auto")
    public Page<Person> auto(Person person){

        Page<Person> pagePeople = personRepositoryWithCustom.findByAuto(person,new PageRequest(0,10));

        return pagePeople;

    }

}

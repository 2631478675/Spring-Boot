package deki.com.springbootcache.controller;

import deki.com.springbootcache.entity.Person;
import deki.com.springbootcache.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    IPersonService personService;

    @RequestMapping("/testCacheable")
    public List<Person> testCacheable(String address){
        return personService.findByName(address);
    }


}

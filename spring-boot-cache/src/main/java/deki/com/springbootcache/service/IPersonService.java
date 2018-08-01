package deki.com.springbootcache.service;

import deki.com.springbootcache.entity.Person;

import java.util.List;

public interface IPersonService {
    public List<Person> findByName(String name);
}

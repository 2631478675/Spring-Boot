package deki.com.springbootcache.service.Impl;

import deki.com.springbootcache.entity.Person;
import deki.com.springbootcache.repository.PersonRepository;
import deki.com.springbootcache.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("iPersonService")
public class PersonServiceImpl implements IPersonService {

    @Autowired
    PersonRepository personRepository;


    @Override
    @Cacheable(value = "person",  //person中的缓存放入person中，student缓存放入student中
            //key = "",  缓存的key，默认使用参数的值：#name/#a0/#root.args[0] （key、keyGenerator二选一）
            keyGenerator = "keyGenerator"//自定义keyGenerator,个人不建议使用
            //condition = "", //对形参进行条件判断，（condition、unless二选一）
//            unless = "",
//            sync = "" //是否使用异步模式，默认为false，并且不支持unless的使用
    )
    public List<Person> findByName(String name) {
        List<Person> personList = personRepository.findByAddress(name);
        return personList;
    }

    /**
     * @CachePut：更新、增添数据时候使用
     *
     * @CacheEvict:删除数据时候用
     */

}

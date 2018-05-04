package lin.springbootdata.controller;


import lin.springbootdata.dao.BloggerRepository;
import lin.springbootdata.entity.Blogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BloggerController {

    //BloggerRepository继承父类JpaRepository，spring-boot-jpa自动注册bean
    @Autowired
    BloggerRepository bloggerRepository;

    @RequestMapping("/save")
    public Blogger save(String name,Integer age){
        Blogger blogger=bloggerRepository.save(new Blogger(null,name,age));
        return blogger;
    }
}

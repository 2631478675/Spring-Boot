package springboot.springbootjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.springbootjpa.entity.User;
import springboot.springbootjpa.jpa.UserJPA;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserJPA userJPA;

    @RequestMapping(value = "/list")
    public List<User> list()
    {
        return userJPA.findAll();
    }

    @RequestMapping(value = "/add")
    public String add(@RequestBody User user)
    {
        if(user == null){
            return "未传入用户，用户为空";
        }else {
            userJPA.save(user);   //save()方法会根据传入的id值的特征来决定是更新还是增加操作
            return "用户信息添加成功";
        }

    }

    @RequestMapping(value = "/delete")
    public String delete(Long userId)
    {
        userJPA.deleteById(userId);
        return "用户信息删除成功";
    }

    @RequestMapping(value = "/age")
    public List<User> age(){
        return userJPA.nativeQuery(20);
    }

    /**
     * 根据条件自定义编写删除SQL
     * @return
     */
//    @RequestMapping(value = "/deleteWhere")
//    public String deleteWhere()
//    {
//        userJPA.deleteQuery("","123456");
//        return "自定义SQL删除数据成功";
//    }

    /**
     * 分页查询测试
     * @param page 传入页码，从1开始
     * @return
     */
//    @RequestMapping(value = "/cutpage")
//    public List<User> cutPage(int page)
//    {
//        User user = new User();
//        user.setSize(2);
//        user.setSord("desc");
//        user.setPage(page);
//
//        //获取排序对象
//        Sort.Direction sort_direction = Sort.Direction.ASC.toString().equalsIgnoreCase(user.getSord()) ? Sort.Direction.ASC : Sort.Direction.DESC;
//        //设置排序对象参数
//        Sort sort = new Sort(sort_direction, user.getSidx());
//        //创建分页对象
//        PageRequest pageRequest = new PageRequest(user.getPage() - 1,user.getSize(),sort);
//        //执行分页查询
//        return userJPA.findAll(pageRequest).getContent();
//    }
}

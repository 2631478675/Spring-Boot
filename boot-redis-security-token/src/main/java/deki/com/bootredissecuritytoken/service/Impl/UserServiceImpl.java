package deki.com.bootredissecuritytoken.service.Impl;


import deki.com.bootredissecuritytoken.common.Response;
import deki.com.bootredissecuritytoken.dao.UserRepository;
import deki.com.bootredissecuritytoken.domain.User;
import deki.com.bootredissecuritytoken.service.IUserService;
import deki.com.bootredissecuritytoken.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("iUserService")
public class UserServiceImpl implements IUserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public Response login(User user) {
        String userName = user.getUserName();
        String password = user.getPassword();
        if(userName!=null&&password!=null){
           User u = userRepository.findByUserNameAndPassword(userName, password);
           if(u!=null){
               //创建token根据用户名和密码
               String token = JWTUtil.encryption(u.getUserName(),u.getPassword());
               //将生成的token保存到redis
//               if(redisTemplate.opsForValue().get("token")!=null){
//                   redisTemplate.opsForValue().
//               }
               redisTemplate.opsForValue().set("token",token);
               u.setcreateTime(new Date());
           }
           return Response.createByError("用户名或者密码错误");
        }

        return Response.createByError("用户名或者密码为空");
    }
}

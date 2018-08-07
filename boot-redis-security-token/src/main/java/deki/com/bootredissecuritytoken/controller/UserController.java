package deki.com.bootredissecuritytoken.controller;

import deki.com.bootredissecuritytoken.common.Response;
import deki.com.bootredissecuritytoken.domain.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/user/")
public class UserController {

    /**
     *
     * @param user:password and username
     * @return
     */
    @RequestMapping("login")
    public Response login(@RequestBody User user){
        return null;
    }
}

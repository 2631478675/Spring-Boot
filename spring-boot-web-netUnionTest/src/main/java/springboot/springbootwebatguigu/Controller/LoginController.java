package springboot.springbootwebatguigu.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;
import springboot.springbootwebatguigu.Response.Response;
import springboot.springbootwebatguigu.Pojo.User;
import springboot.springbootwebatguigu.dao.UserRepositry;

import javax.validation.Valid;

/**
 * 在使用@RequestMapping后，返回值通常解析为跳转路径。加上@responsebody后，返回结果直接写入HTTP response
 * body中，不会被解析为跳转路径。比如异步请求，希望响应的结果是json数据，那么加上@responsebody后，就会直接返回json数据
 */
@RestController // 注意@RestController注释是@Controller+@ResponseBoby的组合！！！没@RequestBody啥事

/**
 * 为什么要使用组合注解@RestController 在使用@RequestMapping后，返回值通常解析为跳转路径。
 * 加上@ResponseBoby后，返回结果直接写入HTTP response body中，不会被解析为跳转路径。
 * 比如异步请求，希望响应的结果是json数据，那么加上@responsebody后，就会直接返回json数据
 */

@CrossOrigin // 解决跨域问题
//springMVC的注解 @CrossOrigin(origins = "*", maxAge = 3600)  ，这里要强调的是springMVC的版本要在4.2或以上版本才支持@CrossOrigin
//https://blog.csdn.net/u012373815/article/details/71436415
public class LoginController {

	@Autowired
	UserRepositry userRepositry;

	@PostMapping(value = "/login")
	public Response login(@RequestBody User user) {
		String username = user.getUsername();
		User user_new = userRepositry.findByUsername(username);
		if (user_new == null) {
			return new Response().failure();
		} else {
			if ((!StringUtils.isEmpty(user_new.getUsername())) && (user.getPassword().equals(user_new.getPassword()))) {
				return new Response().success();
			} else {
				return new Response().failure();
			}
		}

	}

	@PostMapping(value = "/regist")
	public Response regist(@Valid @RequestBody User user, BindingResult result) {
		System.out.println("test");
		if (result.hasErrors()) {
			return new Response().failure();
		} else {
			userRepositry.save(user);
			return new Response().success();
		}

	}
}

package springMvc_four.annotation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * application/json被封装到响应报文中的Content-Type
 */

//此注解代替@Controller和@ResponseBody注解
@RestController
@RequestMapping("rest")
public class DemoRestController {

    //返回数据的媒体类型为json，或者自己定义返回的json格式
    @RequestMapping(value = "/getjson" ,produces = {"application/json;charset=utf-8"})
    public Pojo getjson(Pojo pojo){
        return new Pojo(pojo.getId(),pojo.getName());
    }
    @RequestMapping(value = "/getjson" ,produces = {"application/xml;charset=utf-8"})
    public Pojo getxml(Pojo pojo){
        return new Pojo(pojo.getId(),pojo.getName());
    }
}

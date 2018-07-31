package springMvc_four.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * springmvc常用注解：
 * @Controller：控制器bean，dispatcher Servlet会自动扫描有此注解的类
 * @RequestMapping：映射web请求{produces：response的媒体类型和字符集，value：路径}
 * @PathVariable：用来接收路径上的参数
 * @ResponseBody：返回值可以放到response中，而不是返回一个页面
 *
 */
@Controller
@RequestMapping("anno")
public class AnnotationController {

    @RequestMapping(produces = "text/plain;charset=UTF-8")
    public @ResponseBody String index(HttpServletRequest request) {
        return "url:" + request.getRequestURL() + " can access";
    }

    //访问路径：/anno/pathvar/string
    @RequestMapping(value = "/pathvar/{str}", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String demoPathVar(@PathVariable String str,
                                            HttpServletRequest request) {
        return "url:" + request.getRequestURL() + " can access,str: " + str;
    }

    //访问路径；/anno/pojo?id=1
    @RequestMapping(value = "/requestParam", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String passRequestParam(Long id,
                                                 HttpServletRequest request) {

        return "url:" + request.getRequestURL() + " can access,id: " + id;

    }

    //访问路径：/anno/pojo?id=1&name=e
    @RequestMapping(value = "/pojo", produces = "application/json;charset=UTF-8")
    //@ResponseBody可以放到方法上也可以放到返回值前面
    @ResponseBody
    public String passObj(Pojo pojo, HttpServletRequest request) {

        return "url:" + request.getRequestURL()
                + " can access,  pojo.getId: " + pojo.getId()+" pojo.getName:" + pojo.getName();

    }

    //可以接受映射到不同路径上的相同方法
    @RequestMapping(value = { "/name1", "/name2" }, produces = "text/plain;charset=UTF-8")
    public @ResponseBody String remove(HttpServletRequest request) {

        return "url:" + request.getRequestURL() + " can access";
    }
}

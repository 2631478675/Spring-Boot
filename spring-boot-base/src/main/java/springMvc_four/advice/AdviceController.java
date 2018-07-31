package springMvc_four.advice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import springMvc_four.annotation.Pojo;

/**
 * @ModelAttribute("msg") String msg ->获取@ControllerAdvice类的方法中的@ModelAttribute修饰的全局变量
 * 用来处理异常
 */
@Controller
public class AdviceController  {
    // 访问路径：/advice?id=1&name=e
    @RequestMapping("/advice")
    public String getSomething(@ModelAttribute("msg") String msg, Pojo pojo){//1

        throw new IllegalArgumentException("非常抱歉，参数有误/"+"来自@ModelAttribute:"+ msg);
    }

}

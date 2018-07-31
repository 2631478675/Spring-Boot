package springMvc_four.advice;


import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * 注解@ControllerAdvice的使用：注解的类中的目标方法，对所有注解了@RequestMapping的控制器内的方法都有效
 * 使用：处理全局控制器的异常
 */
//组合注解：组合了@Component，注册为spring的bean
@ControllerAdvice
public class ExceptionHandlerAdvice {

    //@ExceptionHandler的value属性过滤拦截条件：Exception.class拦截了所有的异常
    @ExceptionHandler(value = Exception.class)
    public ModelAndView exception(Exception exception, WebRequest request) {
        //出现异常转到error页面，并将错误信息打印到此页面
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("errorMessage", exception.getMessage());
        return modelAndView;
    }

    //@ModelAttribute可以将所有键值添加到全局中，所有@RequestMapping注解都可以获得
    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("msg", "额外信息");
    }

    //待续。。。
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.setDisallowedFields("id");
    }
}

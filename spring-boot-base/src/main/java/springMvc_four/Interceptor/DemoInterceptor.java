package springMvc_four.Interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器继承类HandlerInterceptorAdapter
 * 拦截器实现对每一个请求处理前后进行相关的业务处理
 */
public class DemoInterceptor extends HandlerInterceptorAdapter {

    //请求发生之后执行：
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        super.postHandle(request, response, handler, modelAndView);

    long startTime=(Long) request.getAttribute("startTime");
    request.removeAttribute("startTime");
    long endTime=System.currentTimeMillis();
    System.out.println("本次请求处理的时间为："+new Long(endTime-startTime)+"ms");
    }
    //请求发生之前执行：
    @Override
    public boolean preHandle(HttpServletRequest request, //2
                             HttpServletResponse response, Object handler) throws Exception {
        //当前计算机的时间
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);
        return true;
    }
}

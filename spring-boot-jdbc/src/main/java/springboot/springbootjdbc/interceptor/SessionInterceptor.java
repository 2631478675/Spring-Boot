//package springboot.springbootjdbc.interceptor;
//
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * reference: http://elim.iteye.com/blog/1750680
// */
////这里拦截器会拦截静态资源，但是我不知道怎么办
//public class SessionInterceptor implements HandlerInterceptor{
//
//    /**
//     * 在controller处理之前调用
//     * 返回false的话，整个请求就结束了
//     * @param request
//     * @param response
//     * @param handler
//     * @return
//     */
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
//        //登录不需要做验证
//        if(request.getRequestURI().equals("/login")||request.getRequestURI().equals("/heihei/image/**")){
//            return true;
//        }
//        //验证session是否存在
//        System.out.println(request.getRequestURI());
//        Object object=request.getSession().getAttribute("session_user");
//        if(object==null){
//            //do something
//            return false;
//        }
//        return true;
//    }
//
//    /**
//     * 只有preHandler返回为true，才会执行
//     * Controller处理之后，DispatcherServlet进行视图渲染之前执行
//     * 可以对ModelAndView进行操作
//     * @param request
//     * @param response
//     * @param handler
//     * @param modelAndView
//     */
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
//
//    }
//
//
//    /**
//     * DispatcherServlet渲染视图后执行，当preHandle方法为true则执行
//     * @param request
//     * @param response
//     * @param handler
//     * @param ex
//     */
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
//
//    }
//}

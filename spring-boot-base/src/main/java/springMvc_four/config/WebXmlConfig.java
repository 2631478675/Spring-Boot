package springMvc_four.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

/**
 * 等价于web.xml,？？?
 */
//WebApplicationInitializer配置servlet3.0+的接口，实现此接口代替web.xml
public class WebXmlConfig  implements WebApplicationInitializer{
    //启动servlet容器
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext configWebApplicationContext= new AnnotationConfigWebApplicationContext();

        configWebApplicationContext.register(Dispatcher_servletConfig.class);
        configWebApplicationContext.setServletContext(servletContext);

        Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(configWebApplicationContext));
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);
        servlet.setAsyncSupported(true);
    }
}

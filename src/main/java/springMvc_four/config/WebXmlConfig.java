package springMvc_four.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * 等价于web.xml,？？?
 */
public class WebXmlConfig  implements WebApplicationInitializer{
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

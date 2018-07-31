package springMvc_four.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import springMvc_four.Interceptor.DemoInterceptor;

/**
 * 等价于dispatcher-servlet.xml
 */
@Configuration
//开启web mvc方法：开启一些默认配置如：ViewResolver等
//开启springmvc的直接，否则重写addResourceHandlers方法无效
@EnableWebMvc
@ComponentScan("springMvc_four")
public class Dispatcher_servletConfig extends WebMvcConfigurerAdapter{
    /**
     * InternalResourceViewResolver继承UrlBasedViewResolver（使用model，request，response对象，对视图（HTML，json，xml，PDF等）进行渲染）
     */
    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
        viewResolver.setPrefix("");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }

    //支持程序的静态文件需直接访问，继承WebMvcConfigurerAdapter，重写此方法
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        super.addResourceHandlers(registry);
        //addResourceHandler:对外暴露的访问路径；addResourceLocations：文件存放的位置
        registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
    }

    /**
     * 拦截器的配置
     * @return
     */
    @Bean
    public DemoInterceptor demoInterceptor(){
        return  new DemoInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(demoInterceptor());
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("index").setViewName("/index");
        registry.addViewController("/toUpload").setViewName("/upload");
    }

    //实现文件上传
    public MultipartResolver multipartResolver(){
        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(100000000);
        return multipartResolver;
    }

}

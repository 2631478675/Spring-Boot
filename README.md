# Spring-Boot
###### 大致实现一下Spring Boot实战的代码
#### 第一章（springBase_one）
- aop
   - ioc
   - javaConfig配置（@Bean、@Configuration的使用）
#### 第二章（springConfig_two）
- scope注解的基本使用（补充中。。。）
- springEL（@Value实现资源的注入）
- beanLife
#### 第三章（springAdvanced_three）
- aware(让bean可以获取spring的资源)
    - AwareService 实现 BeanNameAware,ResourceLoaderAware等接口
- thread
#### 第四章（springMvc_four）
- 快速搭建springmvc（baseCreate）
- springmvc常用注解(annotation)
    - @Controller：控制器bean，dispatcher Servlet会自动扫描有此注解的类
    - @RequestMapping：映射web请求{produces：response的媒体类型和字符集，value：路径}
    - @PathVariable：用来接收路径上的参数
    - @ResponseBody：返回值可以放到response中，而不是返回一个页面
    - @RestController；组合注解；@Controller+@ResponseBody
- 静态资源映射
    - 使用注解@EnableWebMvc，开启springmvc的直接，否则重写addResourceHandlers方法无效
    - 配置类Dispatcher_servlet继承WebMvcConfigurerAdapter父类，重写addResourceHandlers()方法
- 拦截器（interceptor）
    - 定义bean
    - 在配置类中注册bean，重写addInterceptors()注册拦截器
-  全局异常处理（advice）
    - @ControllerAdvice：做全局处理(全局异常处理)
    - @ExceptionHandler的value属性过滤拦截条件
- 文件上传
    - 编写upload.jsp页面
    - 配置MultipartResolver来实现上传文件（spring控制器中通过）
    - MultipartFile file接收文件，MultipartFile[] files接收多个文件
    - 配置addViewController实现页面跳转，这有啥用？？？
    
      
- springMvc_four的配置（config）
   - WebXmlConfig
   - Dispatcher_servlet
        

# Spring-Boot
###### 大致实现一下Spring Boot实战的代码
[超大佬博客，推荐一下](https://www.jianshu.com/p/9a08417e4e84)
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
---
> ps:前四章主要是为了从xml向0配置过渡，不过有些地方没做笔记或实现代码，原因是自认为现在能力不能理解或者用不到。

---  

#### 第五章
> 大概讲述怎么创建springBoot项目，可自行百度

- 创建成功springboot项目中src下的自动生成文件
    - main
        - java
            - *Application :自动生成的入口类（.java中有讲解）
        - resources
            - static：存放脚本样式，图片等静态文件
            - templates：存放页面（如：index.html）
            - application.properties:spring boot 配置文件,可以修改springboot默认配置
    - test
        - java
            - *Application

- [csdn创建springboot项目博客地址](https://blog.csdn.net/typa01_kk/article/details/76696618)



#### 第六章（spring-boot-base）
- 提倡0配置，无xml配置
- 基于jar包运行
- 入口类
    - @SpringBootApplication的使用
- yml使用：配置文件代替以前的.xml（YMLUse待续。。。）  
- @Value和@ConfigurationProperties对比,（Person） 
    - @PropertySource注解使用场景
    - 导入spring的配置文件，让配置文件里面的内容生效,在SpringBootBaseApplication中添加此注解(TestImportResouceService )   但是！！！不推荐使用      
    - 使用config代替@ImportResouce
- Profile的使用（现无使用场景）
- 使用slf4j和logback创建日志，spring boot已经为我们配置了日志
    - 在SpringBootBaseApplicationTests使用下
    - spring boot默认使用的是info级别的，可以再application.properties上可以更改
    - 可以自己设置logback.xml，只需要放对位置并命对名（寻找适当应用环境）
> spring boot 能自动适配所有日志，而且底层使用slf4j+logback的方式记录日志
    
> ps:这章很多在讲springboot原理（可以自己找源码看，或者看书。。。）

#### 第七章（spring-boot-web）
- spring-boot-starter-web提供嵌入的Tomcat和springmvc的依赖
- 引入Thymeleaf代替jsp
    - 原因：内嵌的Tomcat不支持以jar形式运行jsp 
    - 类似js(水平垃圾，之后会看js)
- **==web相关配置==**
    - 自动配置ViewResolver
    - 自动配置静态资源
    - 静态首页的支持
    - 待续。。。
    - ps:可以自己实现相关配置：自己的配置和spring boot的自动配置**同时有效**
- 第七章待续。。。
#### 第七章（spring-boot-web-atguigu）
- 静态资源的引入（前端？）
    - 默认：只需引入jQuery的包
    - 自己建立静态资源（放对地方）
        - public
        - static
        - templates
- 不支持jsp，使用别的模板引擎（Thymeleaf）
    - 引入thymeleaf包
    - 页面放到templates中
    - thymeleaf使用&&语法
        - 待续，嘿嘿
> spring boot底层到底对springmvc做了哪些配置？？？
- 自动配置
    - HttpMessageConverter:SpringMvc用来转换Http请求和响应的；User-->json
    - 内含Formatter格式化器
    - 内含Converter转换器
- springmvc的自动配置
    - [官网地址](https://docs.spring.io/spring-boot/docs/1.5.10.RELEASE/reference/htmlsingle/#boot-features-developing-web-applications)

#### 第八章
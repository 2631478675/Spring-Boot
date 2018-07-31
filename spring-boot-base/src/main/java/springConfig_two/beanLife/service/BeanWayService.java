package springConfig_two.beanLife.service;

/**
 * bean的生命周期之java配置方式
 */
public class BeanWayService {
    public void init(){
        System.out.println("@Bean-init-method");
    }
    public BeanWayService(){
        System.out.println("初始化构造函数-BeanWayService");
    }
    public void destory(){
        System.out.println("@Bean-destory-method");
    }
}

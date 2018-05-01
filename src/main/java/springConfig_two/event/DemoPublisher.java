package springConfig_two.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 * 事件发布类
 */
public class DemoPublisher {
    //使用ApplicationContext继承了父类 ApplicationEventPublisher中的 void publishEvent(ApplicationEvent var1)方法
    @Autowired
    ApplicationContext applicationContext;

    public void publish(String message){
        applicationContext.publishEvent(new DemoEvent(message,this));
    }
}

package springConfig_two.event;

import org.springframework.context.ApplicationListener;


/**
 * 实现事件监听器：实现接口ApplicationListener
 */
public class DemoListener implements ApplicationListener<DemoEvent> {
    //对接收的事件进行处理
    public void onApplicationEvent(DemoEvent demoEvent) {
        String message=demoEvent.getMessage();
        System.out.println("我（ DemoListener）接收到了发布的消息"+message);
    }
}

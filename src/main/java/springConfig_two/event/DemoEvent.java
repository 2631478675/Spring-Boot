package springConfig_two.event;


import org.springframework.context.ApplicationEvent;

/**
 * 自定义事件：继承ApplicationEvent
 */
public class DemoEvent extends ApplicationEvent{
    private String message;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DemoEvent(String message, Object source){
        super(source);
        this.message=message;
    }
}

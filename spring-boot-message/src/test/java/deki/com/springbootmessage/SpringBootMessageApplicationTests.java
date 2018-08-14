package deki.com.springbootmessage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMessageApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    static {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("test", "i am a boy");
    }

    @Test
    public void contextLoads() {
        //发送的是object转化为message
//		rabbitTemplate.send();
        //直接发送object
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("test", "i am a boy");
        rabbitTemplate.convertAndSend("deki.direct", "deki", map);
    }

    /**
     * 一次默认拿一条数据（先进入队列的优先）
     * 在queue中为序列化后的数据，取出后为原类型，如map:{test=i am a boy}
     */
    @Test
    public void receive() {
        Object o = rabbitTemplate.receiveAndConvert("deki");
        System.out.println(o);
    }

    /**
     * 解决queue中的数据变为json类型
     */
}

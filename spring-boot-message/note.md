#### 使用场景
- 进行异步操作的优化
    - 自己去脑补，，，
---
#### RabbitMQ的基本使用
- 导入依赖
```
<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-amqp</artifactId>
        </dependency>
```
- 配置文件中配置mq(我所配置的参数都是默认的，就算不配置也可以)
```
spring: 
    rabbitmq:
        host: localhost
        port: 5672
        username: guest
        password: guest

```
- @EnableRabbit : 开启注解的使用
---
#### 常用注解
- @EnableRabbit : 开启注解的使用
- **@RabbitListener** ： 监听queue中的消息
#### AmqpAdmin的使用：
- 创建queue、exchange、binding：declare*（）
- 删除queue、exchange、binding

---
#### RabbitMQ问题
- 解决queue中存储的数据为json的问题（一步步分析）
    - RabbitTemplate对message进行操作，因此查看RabbitTemplate.class源码
    - 需要将消息转换，在字节码文件中查找converter，默认使用的是SimpleMessageConverter
    ```
    private volatile MessageConverter messageConverter = new SimpleMessageConverter();
    ```
    - 查看MessageConverter接口的所有实现类，找到：Jackson2JsonMessageConverter
    - 编写配置文件，查看package deki.com.springbootmessage.config
---
#### ⚠
- 取数据的时候一次默认拿一条数据（先进入队列的优先），如何解决？待续。。。
---
#### RabbitMQ整合Spring boot基本使用

- @RabbitMQListener注解使用
    - queues = "Queue"
    - queuesToEdclare = @Queue("Queue") : 创建队列
    - bindings = @QueueBinding(
        - exchange = @Exchange("Exchange"),
        - value = @Queue("Queue")) : 创建队列和交换机，并绑定
---
## Spring cloud Stream
> 与只使用rabbitMQ有什么区别？？？
#### 基本使用
- 导入中间件的依赖

```
 <dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-stream-rabbit</artifactId>
 </dependency>
```
- 在配置文件中配置rabbitMQ（如果你没配置的话）
```
spring: 
    rabbitmq:
        host: localhost
        port: 5672
        username: guest
        password: guest

```
- 创建接口，StreamClient
    - 定义@Input
    - 定义@Output

```
public interface StreamClient {

    public static String MESSAGE = "mymessqge";

    @Input(StreamClient.MESSAGE)
    SubscribableChannel input();
    
    @Output(StreamClient.MESSAGE)
    MessageChannel output();
}
```

- 创建消息接受端
    - 使用注解@EnableBinding(StreamClient.class)
    - 使用注解@StreamListener("message")

```
@Component
@EnableBinding(StreamClient.class) //自定义接口的名字
public class StreamReceiver {
    @StreamListener((StreamClient.MESSAGE))
    public void process(Object message){ //形参是接收到的消息
      //todo  
    }
}
```
- 创建消息发送端
    - 引入创建的 StreamClient
    - 发送消息,注意MessageBuilder需要引入的包

```
import org.springframework.integration.support.MessageBuilder;
  @Autowired
    StreamClient streamClient;
    
    public void process(){
        streamClient.output().send(MessageBuilder.withPayload("发送的消息").build());
    }
```
- 出现的问题，部署多实例，只要求指定实例接收到消息
    - 配置下Stream的分组

```
spring:
    stream:
      bindings:
        message: #定义的消息的名字
          group: order #自己定义
```
- 将消息进行json保存
    - 在配置中配置 

```
spring:
    stream:
      bindings:
        message: #定义的消息的名字
          group: order #自己定义
          content-type: application/json
```
- 接收者接收消费完后如何通知系统我已经消费完了？
    - 使用注解@SendTo(StreamClient.MESSAGE2)
    - 新的接收者将即做消费者又做发送者的返回着打印出来

```
    @StreamListener((StreamClient.MESSAGE2))
    public void process(Object message){ //形参是接收到的消息
      //todo  
    }
```

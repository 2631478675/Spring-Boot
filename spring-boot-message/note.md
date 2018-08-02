#### 使用场景
- 进行异步操作的优化
    - 自己去脑补，，，
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

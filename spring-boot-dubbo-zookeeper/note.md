#### Zookeeper和Dubbo的初见面
- Zookeeper：用来做注册中心（婚姻介绍所）
- Dubbo：A、B模块的远程调用框架
![image](http://p3379ff71.bkt.clouddn.com/3.png)

---
#### Spring boot整合Zookeeper和Dubbo
- 使用brew安装Zookeeper
- 使用idea编写模块A、B（建立多模块）
- 导入pom中的依赖

```
<dependency>
	<groupId>com.alibaba.boot</groupId>
	<artifactId>dubbo-spring-boot-starter</artifactId>
	<version>0.1.0</version>
</dependency>

<!--引入zookeeper的客户端工具-->
<!-- https://mvnrepository.com/artifact/com.github.sgroschupf/zkclient -->
<dependency>
	<groupId>com.github.sgroschupf</groupId>
	<artifactId>zkclient</artifactId>
	<version>0.1</version>
</dependency>
```
- 配置application.yml中dubbo的属性

```
dubbo.application.name=provider-ticket

dubbo.registry.address=zookeeper://118.24.44.169:2181

dubbo.scan.base-packages=com.atguigu.ticket.service
```

```
dubbo.application.name=consumer-user

dubbo.registry.address=zookeeper://118.24.44.169:2181
```


- 使用注解@Service将服务发布出去，**注意这需要使用的包**

```
com.alibaba.dubbo.config.annotation.Service
```

- 在B模块中的service中使用@Reference代替@Autowired使用
>⚠️：以上笔记全部整合来源于尚硅谷！！！！
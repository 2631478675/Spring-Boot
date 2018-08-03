## Spring boot整合Spring cloud

---

#### 编写eureka，主要关注配置文件
- 编写配置文件

```
server:
  port: 8761
eureka:
  instance:
    hostname: eureka-server #eureka的主机名
  client:
    register-with-eureka: false #不将自己作为模块注册到eureka上
    fetch-registry: false #不从eureka上获取信息
    service-url:
      defaultZone: http://localhost:8761/eureka
```
- 在入口开启注册的注解@EnableEurekaServer

---

#### 编写provider
- 编写配置文件

```
spring:
  application:
    name: provider
server:
  port: 8001

eureka:
  instance:
    prefer-ip-address: true # 注册服务的时候使用服务的ip地址
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka/

```
#### 编写consumer
- 编写配置文件，基本和上面一致

```
spring:
  application:
    name: consumer
server:
  port: 8200

eureka:
  instance:
    prefer-ip-address: true # 注册服务的时候使用服务的ip地址
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka/

```
- 开启发现服务注解@EnableDiscoveryClient
- 使用RestTemplate发送http请求

```
    @LoadBalanced //使用负载均衡机制，之后学习
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
```
- 使用RestTemplate获取数据
    - PROVIDER-TICKET：请求的服务名（在eureka中）
    - /ticket：请求的URL
```
String s = restTemplate.getForObject("http://PROVIDER-TICKET/ticket", String.class);
```

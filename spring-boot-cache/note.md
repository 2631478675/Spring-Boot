#### 注解的使用
- @Cacheable
    - 使用场景：查询数据
    - 常用注解属性：查看 package deki.com.springbootcache.service.Impl
- @CachePut
    - 使用场景：增添或者更新数据
    - 常用注解属性 ： 等同于@Cacheable
    - 注意点⚠️：
- @CacheEvict
    - 使用场景 ：删除数据
    - 常用注解属性 ： 
        - allEntries = true：指定清除这个缓存中所有的数据
        - beforeInvocation = false：缓存的清除是否在方法之前执行，默认代表缓存清除操作是在方法执行之后执行;如果出现异常缓存就不会清除
        - beforeInvocation = true：代表清除缓存操作是在方法运行之前执行，无论方法是否出现异常，缓存都清除
#### [整合redis作为缓存中间件（可以实时查看缓存的内容)](https://www.cnblogs.com/wscy/p/9241747.html)
- 两个操作redis缓存的template
    - stringRedisTemplate：操作的k-v都是字符串
    - redisTemplate ：操作的k-v都是对象
- redis默认缓存的是序列化后的数据，我们将解决掉这个问题，使得缓存的是json
    - 引入了redis的starter，cacheManager变为 RedisCacheManager；
    - 默认创建的 RedisCacheManager 操作redis的时候使用的是 RedisTemplate<Object, Object>,RedisTemplate<Object, Object> 是 默认使用jdk的序列化机制
#### 整合Spring boot2.0遇到的坑
- [解决方法](http://wsghawk.com/2018/03/19/Redis%E7%BC%93%E5%AD%98%E9%85%8D%E7%BD%AE%E9%97%AE%E9%A2%98/)
![image](http://p3379ff71.bkt.clouddn.com/6.40.48.png)
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
#### 整合redis作为缓存中间件    
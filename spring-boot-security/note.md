#### Spring boot整合Spring security
- 导入security的包

```
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-security</artifactId>
</dependency>
```
- 编写配置类，[参考官网](https://github.com/spring-projects/spring-security/tree/5.0.7.RELEASE/samples/boot/helloworld)

```
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	// @formatter:off
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
					.antMatchers("/css/**", "/index").permitAll()
					.antMatchers("/user/**").hasRole("USER")
					.and()
				.formLogin()
				.loginPage("/login")
				.failureUrl("/login-error");
	}
	// @formatter:on




    /**
    *注意这在高的Spring security版本中password使用的是加密后的
    *参考文献 https://blog.csdn.net/canon_in_d_major/article/details/79675033
    */
	// @formatter:off
	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //inMemoryAuthentication 从内存中获取  
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("user1").password(new BCryptPasswordEncoder().encode("123456")).roles("USER");
    }

	<!--public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {-->
	<!--	auth-->
	<!--		.inMemoryAuthentication()-->
	<!--			.withUser(User.withDefaultPasswordEncoder().username("user").password("password").roles("USER"));-->
	<!--}-->
	// @formatter:on
}
```
#### 分析授权

```
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
					.antMatchers("/css/**", "/index").permitAll()
					.antMatchers("/user/**").hasRole("USER")
					.and()
				.formLogin()
				.loginPage("/login")
				.failureUrl("/login-error");
	}
```
- 对相应的路径匹配，设计授权规则

```
http
	.authorizeRequests()
		.antMatchers("/css/**", "/index").permitAll()
		.antMatchers("/user/**").hasRole("USER")；
```
- 登陆功能
    - 默认含有一个/login页面（自定义login页面）
    - 如果登陆失败，默认重定向到/login?error页面

```
http.formLogin()
                .loginPage("/userlogin")； //自定义login页面，URL为/userlogin
```

- 注销功能
    - 默认又一个/loginout页面
    - 默认退出后会返回到/login?logout页面(可以自定义注销成功后返回的页面)

```
http.logout().logoutSuccessUrl("/");
```
- 记住我功能
    - 浏览器会存储一个remember-me的cookie
    - 点击退出会删除这个cookie

```
http.rememberMe()；
```

#### thymeleaf整和security，实现不同角色看到页面不同，待续。。。。

---
#### 使用数据库中的数据整合security
- ⚠️：[首先要注册，才能测试，自己insert进的数据中密码没有进行加密](http://www.spring4all.com/article/421)
- 要实现
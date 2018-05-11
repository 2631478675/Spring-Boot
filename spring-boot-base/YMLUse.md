###基本语法
> k: v 表示一对键值对（空格要有）;空格很敏感
### 2、值的写法

#### 字面量：普通的值（数字，字符串，布尔）

​- k: v：字面直接来写；
  - 字符串默认不用加上单引号或者双引号；
    - " "：双引号；不会转义字符串里面的特殊字符；特殊字符会作为本身想表示的意思
    - ' '：单引号；会出现转义特殊字符，不做任何处理
```
name:   ‘zhangsan \n lisi’：输出；zhangsan \n  lisi
```
#### 对象、Map（属性和值）（键值对）：
```yaml
friends:
		lastName: zhangsan
		age: 20
```
#### 数组（List、Set）：
```yaml
pets:
 - cat
 - dog
 - pig
```



## 3、配置文件值注入
```yaml
person:
    lastName: hello
    age: 18
    boss: false
    birth: 2017/12/12
    maps: {k1: v1,k2: 12}
    lists:
      - lisi
      - zhaoliu
    dog:
      name: 小狗
      age: 12
```
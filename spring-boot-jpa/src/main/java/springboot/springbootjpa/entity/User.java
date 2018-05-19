package springboot.springbootjpa.entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity     //指明该java类为实体类，将映射到指定的数据库表上
/*
当实体类与其映射的数据库表名不同名时需要使用 @Table 标注说明，该标注与 @Entity 标注并列使用
@Table 标注的常用选项是 name，指明数据库的表名
@Table标注还有一个两个选项 catalog 和 schema 用于设置表所属的数据库目录或模式，通常为数据库名
 */
@Table(name = "user")
public class User extends BaseEntity implements Serializable {

    @Id  //这是数据库的主键列
    /*
    @GeneratedValue  用于标注主键的生成策略，通过 strategy 属性指定。默认情况下，
    JPA 自动选择一个最适合底层数据库的主键生成策略：SqlServer 对应 identity，MySQL 对应 auto increment。
     */
    //reference : https://blog.csdn.net/carl4254/article/details/69664004
    @GeneratedValue(strategy = GenerationType.IDENTITY)   //注意，假如在设计数据库表的时候主键设置了自增，则需要加上strategy = GenerationType.IDENTITY
    /*
    当实体的属性与其映射的数据库表的列不同名时需要使用@Column 标注说明
     */
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_name")
    private  String name;

    @Column(name = "user_age")
    private int age;

    @Column(name = "user_address")
    private String address;

    @Column(name = "user_password")
    private String password;

    public User() {
    }

    public User(String name, int age, String address, String password) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

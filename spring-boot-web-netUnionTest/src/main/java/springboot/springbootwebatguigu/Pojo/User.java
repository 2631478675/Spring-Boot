package springboot.springbootwebatguigu.Pojo;

import org.springframework.validation.annotation.Validated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

/**
 * https://blog.csdn.net/kangbin825/article/details/74557132
 */
@Validated
@Entity(name = "test")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

//    @Pattern(regexp = "^[a-zA-Z](\\d\\w{4}|\\w\\d\\w{3}|\\w{2}\\d\\w{2}|\\w{3}\\d\\w|\\w{4}\\d)$")
	@NotEmpty
	private String username;

	@NotNull
	@Size(min = 6, max = 12) // ，此注解只能用于Array,Collection,Map,String
	private String password;

	/**
	 * 以后接着改格式
	 */
	@Pattern(regexp = "^[1][3,4,5,7,8][0-9]{9}$")
	private String phoneNumber;

	@Email
	private String email;

	public User() {

	}

	public User(String username, String password, String phoneNumber, String email) {
		this.username = username;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", phoneNumber=" + phoneNumber
				+ ", email=" + email + "]";
	}

}

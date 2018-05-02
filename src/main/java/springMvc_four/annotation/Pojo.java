package springMvc_four.annotation;

/**
 * 此对象用来通过Jackson转化为json：注意要有无参构造器
 */
public class Pojo {
    private Long id;
    private String name;

    public Pojo() {
        super();
    }
    public Pojo(Long id, String name) {
        super();
        this.id = id;
        this.name = name;
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

}

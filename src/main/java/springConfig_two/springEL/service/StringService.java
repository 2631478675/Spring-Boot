package springConfig_two.springEL.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @Value在参数的使用
 */
@Service
@Scope("singleton")
public class StringService {
    @Value("普通字符串")
    private String string;

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
}

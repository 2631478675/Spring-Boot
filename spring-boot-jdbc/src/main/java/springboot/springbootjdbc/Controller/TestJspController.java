package springboot.springbootjdbc.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestJspController {
    @GetMapping(value = "/testJsp")
    public String intergration(){
        return "intergration.jsp";
    }
}

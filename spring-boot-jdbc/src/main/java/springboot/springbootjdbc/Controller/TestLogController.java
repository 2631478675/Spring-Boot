package springboot.springbootjdbc.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestLogController {
    private final static Logger LOGGER = LoggerFactory.getLogger(UpLoadFileController.class);


    @GetMapping(value = "/testLog")

    public  String testLog(){

//        LOGGER.debug("输出调试日志");

        LOGGER.info("输出打印日志");

        LOGGER.error("输出错误日志");

        return "日志测试成功";
    }




}

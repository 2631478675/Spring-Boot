package springMvc_four.upAndLoad;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class upLoadController {
    @RequestMapping(value = "/upload" ,method = RequestMethod.POST)
    public String upload (MultipartFile file){
        try {
            // FileUtils.writeByteArrayToFile快速将文件写到磁盘中
            FileUtils.writeByteArrayToFile(new File("classpath:upload/"),file.getBytes());
            return "ok";
        } catch (IOException e) {
            e.printStackTrace();
            return  "wrong";
        }

    }
}

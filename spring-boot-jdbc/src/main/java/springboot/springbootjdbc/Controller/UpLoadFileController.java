package springboot.springbootjdbc.Controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;


@Controller
public class UpLoadFileController {

    private final static Logger LOGGER = LoggerFactory.getLogger(UpLoadFileController.class);


    @GetMapping(value = "/jump")
    public  String jump(){
        return "upLoadFile";
    }


    @PostMapping(value = "/upload")
    @ResponseBody //不加的话直接跳转页面
    public String upload(HttpServletRequest request, MultipartFile file){
        //白痴
        if(file == null){
            return "fail";
        }
        String uploadDir = request.getSession().getServletContext().getRealPath("/upload/");
        File dir = new File(uploadDir);
        //如果目录不存在
        if(!dir.exists()){
            dir.mkdir();
        }
        //截取文件后缀名
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        //使用UUID生成新的文件名
        String fileName = UUID.randomUUID() + suffix ;
        //将文件保存在服务端，此时是文件名
        File serverFile = new File(uploadDir + fileName);
        try {
            file.transferTo(serverFile);
        } catch (IOException e) {
            e.printStackTrace();
            return "fail";
        }
        return "success" ;
    }



}

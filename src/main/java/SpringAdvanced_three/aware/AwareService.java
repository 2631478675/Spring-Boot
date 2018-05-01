package SpringAdvanced_three.aware;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;

/**
 * 使bean意识到Spring的存在，调用spring提供的资源
 */
public class AwareService implements BeanNameAware,ResourceLoaderAware{
    private String beanName;

    private ResourceLoader loader;
    //实现BeanNameAware，获取容器bean的名字
    public void setBeanName(String s) {
        this.beanName=s;
    }
    //实现ResourceLoaderAware，获取资源加载器，可以获取外部资源文件
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.loader=resourceLoader;
    }


    public void outResult(){
        Resource resource=loader.getResource("classpath:resources/aware.txt");
        try {
            System.out.println(IOUtils.toString(resource.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

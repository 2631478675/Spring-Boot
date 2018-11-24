package com.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component

@ConfigurationProperties(prefix="ems.spring.datasource")
public class DataSourceConfig {


    private Map<String , Object> tomcat;

    public Map<String, Object> getTomcat() {
        return tomcat;
    }

    public void setTomcat(Map<String, Object> tomcat) {
        this.tomcat = tomcat;
    }
}

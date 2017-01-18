package com.example.myproject.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by wangle on 2017/1/18.
 */
@ConfigurationProperties(prefix = "user")
public class HelloServiceProperties {
    private String name ;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}

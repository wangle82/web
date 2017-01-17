package com.example.myproject.action;

import com.example.myproject.mapper.UserMapper;
import com.example.myproject.model.User;
import com.example.myproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by wangle on 2017/1/16.
 */
@RestController
@ConfigurationProperties(prefix = "author")
public class HelloAction {
    private String name ;
    private String age;

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    String home() {
        User userInfo = userService.getUserInfo();
        System.out.println("userInfo = " + userInfo);
        return " 现在时间：" + (new Date()).toLocaleString() + " Hello World!" + "name = "+name + " age = " + age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }
}

package com.example.myproject.action;

import com.example.myproject.model.User;
import com.example.myproject.properties.HelloServiceProperties;
import com.example.myproject.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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

    private Logger logger = Logger.getLogger(HelloAction.class);
    @Autowired
    private UserService userService;

    @Autowired
    private HelloServiceProperties helloServiceProperties;

    @RequestMapping("/")
    String home() {
        logger.info(" helloServiceProperties = " + helloServiceProperties );

        User userInfo = userService.getUserInfo();
        logger.info(userInfo.getName() + " " + userInfo.getAge() );
        return " 现在时间：" + (new Date()).toLocaleString() + " Hello World!" + "name = "+name + " age = " + age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }
}

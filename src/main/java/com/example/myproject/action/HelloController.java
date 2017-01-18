package com.example.myproject.action;

import com.example.myproject.model.User;
import com.example.myproject.properties.HelloServiceProperties;
import com.example.myproject.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * Created by wangle on 2017/1/16.
 */
@RestController
@ConfigurationProperties(prefix = "author")
public class HelloController {
    private String name ;
    private String age;

    private Logger logger = Logger.getLogger(HelloController.class);
    @Autowired
    private UserService userService;

    @Autowired
    private HelloServiceProperties helloServiceProperties;

    @RequestMapping("/hello")
    public ModelAndView home(Model model) {
        logger.info(" helloServiceProperties = " + helloServiceProperties );
        User userInfo = userService.getUserInfo();
        logger.info(userInfo.getName() + " " + userInfo.getAge() );
        model.addAttribute("info"," 现在时间：" + (new Date()).toLocaleString() + " Hello World!" + "name = "+name + " age = " + age);
        ModelAndView mv = new ModelAndView("hello");//如果使用@RestController注解，必须使用ModelAndView将返回的界面封装一下
        return mv;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }
}

package com.example.springbootdemo.controller;

import com.alibaba.fastjson.JSON;
import com.example.springbootdemo.Service.UserService;
import com.example.springbootdemo.bean.UserInfo;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@EnableAutoConfiguration
public class HelloController {

    private static Logger log = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private UserService userSerivce;

    @RequestMapping(value = "hello",method = RequestMethod.GET)
    private String index(){
        return "Hello World";
    }

    @RequestMapping(value = "hello2",method = RequestMethod.GET)
    private String hello( Map<String ,Object> map){
        log.info("获取用户信息222"+JSON.toJSONString(userSerivce.queryUserById(1)));
//        map.put("name","ccc");
//        System.out.println("DemoController.hello()");
        map.put("hello","from TemplateController.helloHtml");
        return JSON.toJSONString(userSerivce.queryUserById(1));
    }

    @RequestMapping(value = "getJson/{id}")
    @ResponseBody
    private UserInfo query(@PathVariable("id") int id){
        log.info("获取用户的信息"+JSON.toJSONString(userSerivce.queryUserById(id)) + " 结束");
        return userSerivce.queryUserById(id);
    }

    @ResponseBody
    @RequestMapping("insert/{name}")
    private String insertUserInfo(@PathVariable("name") String name){
        Map<String ,String > map = new HashMap<>();
        map.put("name",name);
        int i = userSerivce.insertUserInfo(map);
        log.info("成功插入"+i+"条信息，姓名为"+name);
        return "成功插入"+i+"条信息，姓名为"+name;
    }

    @ResponseBody
    @RequestMapping("allUserInfos")
    private List<UserInfo> allUserInfos(){

        List<UserInfo> maps = userSerivce.allUserInfos();
        for (UserInfo userInfo:maps){
            log.info("id:"+userInfo.getId() + " ;name:"+userInfo.getName());
        }
        return maps;
    }
}

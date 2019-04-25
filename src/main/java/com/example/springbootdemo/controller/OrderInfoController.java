package com.example.springbootdemo.controller;

import com.example.springbootdemo.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.spring.annotation.MapperScan;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/order")
@MapperScan(value = "com.example.springbootdemo.mapper")
public class OrderInfoController {

    @Autowired
    private OrderMapper orderMapper;

    @GetMapping("/insertOrder")
    public void insertOrder(){
        Map<String,Object> map = new HashMap<>();
        map.put("id",1);
        orderMapper.insert(map);
    }
}

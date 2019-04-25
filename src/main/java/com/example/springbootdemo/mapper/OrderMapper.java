package com.example.springbootdemo.mapper;


import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface OrderMapper {
    int insert(Map<String,Object> map);
}

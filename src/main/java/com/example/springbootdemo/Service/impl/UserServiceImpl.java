package com.example.springbootdemo.Service.impl;

import com.example.springbootdemo.Service.UserService;
import com.example.springbootdemo.bean.UserInfo;
import com.example.springbootdemo.dao.UserDao;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("userSerivce")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserInfo queryUserById(int id) {
        return userDao.queryUserByid(id);
    }

    @Override
    public int insertUserInfo(Map<String, String> map) {
        return userDao.insertUserInfo(map);
    }

    @Override
    public List<UserInfo> allUserInfos() {
        PageHelper.startPage(0,1);
        return userDao.allUserInfos();
    }
}

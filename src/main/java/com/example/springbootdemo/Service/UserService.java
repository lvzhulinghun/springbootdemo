package com.example.springbootdemo.Service;

import com.example.springbootdemo.bean.UserInfo;

import java.util.List;
import java.util.Map;

public interface UserService {

    public UserInfo queryUserById(int id);

    int insertUserInfo(Map<String,String > map);

    List<UserInfo> allUserInfos();
}

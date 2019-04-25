package com.example.springbootdemo.dao;

import com.example.springbootdemo.bean.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserDao {

    @Select("SELECT * FROM USER2 WHERE ID = #{id}")
    UserInfo queryUserByid(@Param("id") int id);

    @Insert("insert into user2(name) values(#{name})")
    int insertUserInfo(Map<String,String> map);

    @Select("select * from user2")
    List<UserInfo> allUserInfos();
}

package com.example.springbootdemo.bean;

public class SubAutoClose implements  AutoCloseable {

    public void readResource(){
        System.out.println("读取资源");
    }

    @Override
    public void close() throws Exception {
        System.out.println("关闭资源");
        throw new Exception("关闭异常");
    }
}

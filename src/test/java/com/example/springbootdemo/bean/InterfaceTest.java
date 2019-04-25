package com.example.springbootdemo.bean;

public interface InterfaceTest {

    static void method(){
        System.out.println("默认方法");
    }
    default void methodA(){
        System.out.println("AA");
    }
}

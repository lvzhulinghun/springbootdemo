package com.example.springbootdemo.bean;

public class Student implements InterfaceTest,Comparable{

    @Override
    public void methodA() {

    }
    public Student(){
    }
    public Student(String name,int age){
        this.name= name;
        this.age = age;
    }




    private String name;

    private int age;

    private String address;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public int hashCode() {
        return 12;
    }

    @Override
    public int compareTo(Object o) {
        Student stu = (Student) o;
        if(stu.getAge() > this.getAge()){
            return 1;
        }else if(stu.getAge() < this.getAge()){
            return -1;
        }
        return 0;
    }
}

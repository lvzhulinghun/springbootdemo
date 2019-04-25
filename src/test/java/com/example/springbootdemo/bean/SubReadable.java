package com.example.springbootdemo.bean;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Scanner;

public class SubReadable implements  Readable {

    private int count;

    public SubReadable(int count) {
        this.count = count;
    }



    @Override
    public int read(CharBuffer cb) throws IOException {
        System.out.println("进入read中：");
        if(count-- == 0) return -1;
        cb = getCharBuffer(cb);
        cb.append("\n");
        return 1;
    }

    public CharBuffer getCharBuffer(CharBuffer charBuffer){
        System.out.println("请输出数据。。。");
//        Scanner scanner = new Scanner(System.in);
//        String s = scanner.next();
        return charBuffer.append("sadadaddasda");
    }



}

package com.example.springbootdemo.ThreadTest;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapThread implements Runnable {

    private ConcurrentHashMap<String,Integer> map  = null;

    private int total;

    public ConcurrentHashMapThread(ConcurrentHashMap map,int total) {
        this.map = map;
        this.total = total;
    }

    @Override
    public void run() {
        long a  = System.currentTimeMillis();
        for(int i=0;i< total ; i++){
            map.put("key"+i,i);
        }
        long b = System.currentTimeMillis();
        System.out.println("ConcurrentHashMap插入使用的时间--》"+(b-a)/1000+"秒"+" ;size："+map.size());
    }
}

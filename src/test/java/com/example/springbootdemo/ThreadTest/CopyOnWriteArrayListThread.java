package com.example.springbootdemo.ThreadTest;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class CopyOnWriteArrayListThread implements  Runnable {

    private CopyOnWriteArrayList<Integer> cowal = null;
    private CopyOnWriteArraySet<Integer> copyOnWriteArraySet = null;

    public CopyOnWriteArrayListThread(CopyOnWriteArrayList<Integer> cowal,CopyOnWriteArraySet<Integer> copyOnWriteArraySet) {
        this.cowal = cowal;
        this.copyOnWriteArraySet = copyOnWriteArraySet;
    }

    @Override
    public void run() {
        try {
                for(int i =0 ; i <=20;i++){
                    cowal.add(i);
                    copyOnWriteArraySet.add(i);
                    Thread.sleep(20);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

    }
}

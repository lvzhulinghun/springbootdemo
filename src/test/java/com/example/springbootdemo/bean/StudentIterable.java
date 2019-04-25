package com.example.springbootdemo.bean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class StudentIterable implements  Iterable<Object> {
    List arrayList = new ArrayList();

    public void add(String str){
        arrayList.add(str);
    }

    @Override
    public Iterator<Object> iterator() {
        return arrayList.iterator();
    }

//    @Override
//    public void forEach(Consumer<? super Object> action) {
//
//    }

    @Override
    public Spliterator<Object> spliterator() {
        return null;
    }
}

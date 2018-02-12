package com.logistics.bean;

/**
 * Created by Administrator on 2016/10/27.
 */
public class Statistics {
    String name;
    int count;

    public Statistics(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public Statistics() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

package com.logistics.bean;

/**
 * Created by Administrator on 2016/10/27.
 */
public class CarType {
    int id;
    String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public CarType() {
    }

    public CarType(int id, String type) {
        this.id = id;
        this.type = type;
    }
}

package com.logistics.bean;

/**
 * Created by Administrator on 2016/10/27.
 */
public class CarLong {
    int id;
    String carsLong;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarsLong() {
        return carsLong;
    }

    public void setCarsLong(String carsLong) {
        this.carsLong = carsLong;
    }

    public CarLong(int id, String carsLong) {
        this.id = id;
        this.carsLong = carsLong;
    }

    public CarLong() {
    }
}

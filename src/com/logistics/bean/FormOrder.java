package com.logistics.bean;

/**
 * Created by Administrator on 2016/10/28.
 */
public class FormOrder {
    String orderNum;
    String startProvince;
    String startCity;
    String toProvince;
    String toCity;
    String goodsName;
    String goodsWeight;
    String time;
    String carNum;
    String owner;
    int state;
    /*int goodsId;
    int carId;
    int state;*/

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }


    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getStartProvince() {
        return startProvince;
    }

    public void setStartProvince(String startProvince) {
        this.startProvince = startProvince;
    }

    public String getStartCity() {
        return startCity;
    }

    public void setStartCity(String startCity) {
        this.startCity = startCity;
    }

    public String getToProvince() {
        return toProvince;
    }

    public void setToProvince(String toProvince) {
        this.toProvince = toProvince;
    }

    public String getToCity() {
        return toCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsWeight() {
        return goodsWeight;
    }

    public void setGoodsWeight(String goodsWeight) {
        this.goodsWeight = goodsWeight;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public FormOrder() {

    }

    public FormOrder(String orderNum, String startProvince, String startCity, String toProvince, String toCity, String goodsName, String goodsWeight, String time, String carNum, String owner, int state) {
        this.orderNum = orderNum;
        this.startProvince = startProvince;
        this.startCity = startCity;
        this.toProvince = toProvince;
        this.toCity = toCity;
        this.goodsName = goodsName;
        this.goodsWeight = goodsWeight;
        this.time = time;
        this.carNum = carNum;
        this.owner = owner;
        this.state = state;
    }
}



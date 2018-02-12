package com.logistics.bean;

/**
 * Created by Administrator on 2016/10/26.
 */
public class CarInfo {
    String carNum;
    String carLong;
    String carType;
    String coachType;
    String startCity;
    String startProvince;
    String toProvince;
    String toCity;
    String carPic;
    String owner;
    int id;

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public String getCarLong() {
        return carLong;
    }

    public void setCarLong(String carLong) {
        this.carLong = carLong;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCoachType() {
        return coachType;
    }

    public void setCoachType(String coachType) {
        this.coachType = coachType;
    }

    public String getStartCity() {
        return startCity;
    }

    public void setStartCity(String startCity) {
        this.startCity = startCity;
    }

    public String getStartProvince() {
        return startProvince;
    }

    public void setStartProvince(String startProvince) {
        this.startProvince = startProvince;
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

    public String getCarPic() {
        return carPic;
    }

    public void setCarPic(String carPic) {
        this.carPic = carPic;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CarInfo() {
    }

    public CarInfo(String carPic,String carNum,String owner,String carLong, String carType, String coachType, String startProvince,String startCity,  String toProvince, String toCity) {
        this.carPic = carPic;
        this.carNum = carNum;
        this.owner = owner;
        this.carLong = carLong;
        this.carType = carType;
        this.coachType = coachType;
        this.startProvince = startProvince;
        this.startCity = startCity;
        this.toProvince = toProvince;
        this.toCity = toCity;


    }

    public CarInfo(int id,String carPic,String carNum,String owner,String carLong, String carType, String coachType, String startProvince,String startCity,  String toProvince, String toCity) {
        this.id = id;
        this.carPic = carPic;
        this.carNum = carNum;
        this.owner = owner;
        this.carLong = carLong;
        this.carType = carType;
        this.coachType = coachType;
        this.startProvince = startProvince;
        this.startCity = startCity;
        this.toProvince = toProvince;
        this.toCity = toCity;

    }
}

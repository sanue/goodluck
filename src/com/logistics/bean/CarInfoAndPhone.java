package com.logistics.bean;

/**
 * Created by Administrator on 2016/11/1.
 */
public class CarInfoAndPhone extends CarInfo {
    String phone;

    public CarInfoAndPhone() {
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public CarInfoAndPhone(int id, String carPic, String carNum, String owner, String carLong, String carType, String coachType, String startProvince, String startCity, String toProvince, String toCity, String phone) {
        super(id, carPic, carNum, owner, carLong, carType, coachType, startProvince, startCity, toProvince, toCity);
        this.phone = phone;
    }
}

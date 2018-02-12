package com.logistics.bean;

/**
 * Created by Administrator on 2016/11/1.
 */
public class GoodsAndPhone extends Goods {
    String phone;

    public GoodsAndPhone(int id, String shipper, String name, String weight, int carTypeId, String carType, int coachTypeId, String coachType, int carLongId, String carLong, String startProvince, String startCity, String toProvince, String toCity, String shipmentTime, String pic, String phone) {
        super(id, shipper, name, weight, carTypeId, carType, coachTypeId, coachType, carLongId, carLong, startProvince, startCity, toProvince, toCity, shipmentTime, pic);
        this.phone = phone;
    }

    public GoodsAndPhone() {

    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

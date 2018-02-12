package com.logistics.bean;

/**
 * Created by Administrator on 2016/10/26.
 */
public class Goods {
    int id;
    String shipper;
    String name ;
    String weight;
    int carTypeId;
    String carType;
    int coachTypeId;
    String coachType;
    int carLongId;
    String carLong;
    /*String loading;
    String unloading;*/
    String startProvince;
    String startCity;
    String toProvince;
    String toCity;
    String shipmentTime;
    String pic;/*货源图片*/

    public String getShipper() {
        return shipper;
    }

    public void setShipper(String shipper) {
        this.shipper = shipper;
    }

    public Goods(int id, String shipper, String name, String weight, int carTypeId, String carType, int coachTypeId, String coachType, int carLongId, String carLong, String startProvince, String startCity, String toProvince, String toCity, String shipmentTime, String pic) {
        this.id = id;
        this.shipper = shipper;
        this.name = name;
        this.weight = weight;
        this.carTypeId = carTypeId;
        this.carType = carType;
        this.coachTypeId = coachTypeId;
        this.coachType = coachType;
        this.carLongId = carLongId;
        this.carLong = carLong;
        this.startProvince = startProvince;
        this.startCity = startCity;
        this.toProvince = toProvince;
        this.toCity = toCity;
        this.shipmentTime = shipmentTime;
        this.pic = pic;
    }
    public Goods(int id, String shipper, String name, String weight, int carTypeId, int coachTypeId, int carLongId, String startProvince, String startCity, String toProvince, String toCity, String shipmentTime, String pic) {
        this.id = id;
        this.shipper = shipper;
        this.name = name;
        this.weight = weight;
        this.carTypeId = carTypeId;
        this.coachTypeId = coachTypeId;
        this.carLongId = carLongId;
        this.startProvince = startProvince;
        this.startCity = startCity;
        this.toProvince = toProvince;
        this.toCity = toCity;
        this.shipmentTime = shipmentTime;
        this.pic = pic;
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

    public String getCarLong() {
        return carLong;
    }

    public void setCarLong(String carLong) {
        this.carLong = carLong;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public int getCarTypeId() {
        return carTypeId;
    }

    public void setCarTypeId(int carTypeId) {
        this.carTypeId = carTypeId;
    }

    public int getCoachTypeId() {
        return coachTypeId;
    }

    public void setCoachTypeId(int coachTypeId) {
        this.coachTypeId = coachTypeId;
    }

    public int getCarLongId() {
        return carLongId;
    }

    public void setCarLongId(int carLongId) {
        this.carLongId = carLongId;
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

    public String getStartCity() {
        return startCity;
    }

    public void setStartCity(String startCity) {
        this.startCity = startCity;
    }

    public String getToCity() {
        return toCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    public String getShipmentTime() {
        return shipmentTime;
    }

    public void setShipmentTime(String shipmentTime) {
        this.shipmentTime = shipmentTime;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Goods() {

    }

}

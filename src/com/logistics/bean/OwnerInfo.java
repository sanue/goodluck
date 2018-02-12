package com.logistics.bean;

/**
 * Created by Administrator on 2016/10/26.
 */
public class OwnerInfo {
    String name;
    String password;
    String sex;
    String telephoneNum;
    int identity;
    int status;
    String trueName;
    /*车牌号why+*/
    String carNum;
    String carLong;
    String carType;
    String coachType;
    String startProvince;
    String toProvince;
    String startCity;
    String toCity;
    String headPic;
    String driversLicensePic;
    String pic;

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getDriversLicensePic() {
        return driversLicensePic;
    }

    public void setDriversLicensePic(String driversLicensePic) {
        this.driversLicensePic = driversLicensePic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTelephoneNum() {
        return telephoneNum;
    }

    public void setTelephoneNum(String telephoneNum) {
        this.telephoneNum = telephoneNum;
    }

    public int getIdentity() {
        return identity;
    }

    public void setIdentity(int identity) {
        this.identity = identity;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

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

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public OwnerInfo(String name, String toCity, String startCity, String toProvince, String startProvince, String coachType, String carType, String carLong, String carNum, String telephoneNum,String trueName,String driversLicensePic,String headPic,String pic) {
        this.name = name;
        this.toCity = toCity;
        this.startCity = startCity;
        this.toProvince = toProvince;
        this.startProvince = startProvince;
        this.coachType = coachType;
        this.carType = carType;
        this.carLong = carLong;
        this.carNum = carNum;
        this.telephoneNum = telephoneNum;
        this.trueName = trueName;
        this.driversLicensePic = driversLicensePic;
        this.headPic = headPic;
        this.pic = pic;

    }

    public OwnerInfo(String name, String password, String sex, String telephoneNum, int status) {
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.telephoneNum = telephoneNum;

        this.status = status;
    }

    public OwnerInfo(String name, String trueName,String sex, String telephoneNum, int identity, int status) {
        this.name = name;
        this.trueName=trueName;
        this.sex = sex;
        this.telephoneNum = telephoneNum;
        this.identity = identity;
        this.status = status;
    }
    //name,trueName,sex,telephoneNum,identity,status
    public OwnerInfo() {

    }



    public OwnerInfo(String name, String password, String sex,  int status, String telephoneNum) {
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.telephoneNum = telephoneNum;

        this.status = status;
    }
//ownerName,toCity,startCity,toProvince,startProvince,coachType,carType,carLong,carNum,telephoneNum,headPic
    //ownerName,toCity,startCity,toProvince,startProvince,coachType,carType,carLong,carNum,telephoneNum,headPic

    public OwnerInfo(String name, String sex, String telephoneNum, int identity, int status, String trueName,String headPic) {
        this.name = name;
        this.sex = sex;
        this.telephoneNum = telephoneNum;
        this.identity = identity;
        this.status = status;
        this.trueName = trueName;
        this.headPic=headPic;
    }
   public OwnerInfo(String name,String toCity,String startCity,String toProvince,String startProvince,String coachType, String carType, String carLong,String carNum,String telephoneNum,String headPic){
       this.name = name;
       this.toCity=toCity;
       this.startCity=startCity;
       this.toProvince=toProvince;
       this.startProvince=startProvince;
       this.coachType=coachType;
       this.carType=carType;
       this.carLong=carLong;
       this.carNum=carNum;
       this.telephoneNum=telephoneNum;
       this.headPic=headPic;
   }
//    ownerName,toCity,startCity,toProvince,startProvince,coachType,carType,carLong,carNum,telephoneNum

    public OwnerInfo(String name, String toCity, String startCity, String toProvince, String startProvince, String coachType, String carType, String carLong, String carNum, String telephoneNum) {
        this.name = name;
        this.toCity = toCity;
        this.startCity = startCity;
        this.toProvince = toProvince;
        this.startProvince = startProvince;
        this.coachType = coachType;
        this.carType = carType;
        this.carLong = carLong;
        this.carNum = carNum;
        this.telephoneNum = telephoneNum;
    }
}

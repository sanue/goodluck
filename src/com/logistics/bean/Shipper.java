package com.logistics.bean;

/**
 * Created by Administrator on 2016/10/26.
 */
public class Shipper {
    String name;
    String password;
    String sex;
    String telephoneNum;
    int identity;
    int Status;
    /*认证信息*/
    String trueName;
    String identityCard;
    String pic;/*头像*/

    public Shipper(String name, String password, String sex, String telephoneNum, int identity, int status, String trueName, String identityCard, String pic) {
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.telephoneNum = telephoneNum;
        this.identity = identity;
        Status = status;
        this.trueName = trueName;
        this.identityCard = identityCard;
        this.pic = pic;
    }

    public Shipper() {

    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
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
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }
}

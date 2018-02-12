package com.logistics.bean;

/**
 * Created by Administrator on 2016/10/26.
 */
public class BaseInfo {
    String name;
    String password;
    String sex;
    String telephoneNum;
    int identity;
    int Status;

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

    public BaseInfo() {

    }

    public BaseInfo(String name, String password, String sex, String telephoneNum, int identity, int status) {

        this.name = name;
        this.password = password;
        this.sex = sex;
        this.telephoneNum = telephoneNum;
        this.identity = identity;
        Status = status;
    }
}

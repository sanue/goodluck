package com.logistics.bean;

/**
 * Created by Administrator on 2016/10/26.
 */
public class Register {
    String name;
    String password;
    String sex;
    String telephoeNum;
    int identity;
    int status;

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

    public String getTelephoeNum() {
        return telephoeNum;
    }

    public void setTelephoeNum(String telephoeNum) {
        this.telephoeNum = telephoeNum;
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

    public Register() {

    }

    public Register(String name, String password, String sex, String telephoeNum, int identity, int status) {
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.telephoeNum = telephoeNum;
        this.identity = identity;
        this.status = status;
    }
}

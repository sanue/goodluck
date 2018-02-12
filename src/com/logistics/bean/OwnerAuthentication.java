package com.logistics.bean;

/**
 * Created by Administrator on 2016/10/26.
 */
public class OwnerAuthentication {
    String ownerName;
    String trueName;
    String headPic;
    String drivesLicensePic;
    String carNum;
    String identityPic;
    int status;
    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public String getDrivesLicensePic() {
        return drivesLicensePic;
    }

    public void setDrivesLicensePic(String drivesLicensePic) {
        this.drivesLicensePic = drivesLicensePic;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public String getIdentityPic() {
        return identityPic;
    }

    public void setIdentityPic(String identityPic) {
        this.identityPic = identityPic;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public OwnerAuthentication() {
    }

    public OwnerAuthentication(String ownerName, String trueName, String headPic, String drivesLicensePic, String carNum, String identityPic) {
        this.ownerName = ownerName;
        this.trueName = trueName;
        this.drivesLicensePic = drivesLicensePic;
        this.carNum = carNum;
        this.identityPic = identityPic;
        this.headPic=headPic;
    }

    public OwnerAuthentication(String trueName, String headPic, String drivesLicensePic, String carNum, String identityPic,int status,String ownerName) {
        this.trueName = trueName;
        this.headPic = headPic;
        this.drivesLicensePic = drivesLicensePic;
        this.carNum = carNum;
        this.identityPic = identityPic;
        this.status=status;
        this.ownerName=ownerName;
    }

}

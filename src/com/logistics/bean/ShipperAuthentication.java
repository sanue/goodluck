package com.logistics.bean;

/**
 * Created by Administrator on 2016/10/26.
 */
public class ShipperAuthentication {
    String shipperName;
    String trueName;
    String identityCard;
    String pic;/*头像*/
    int status;

    public ShipperAuthentication(String shipperName, String trueName, String identityCard, String pic, int status) {
        this.shipperName = shipperName;
        this.trueName = trueName;
        this.identityCard = identityCard;
        this.pic = pic;
        this.status = status;
    }

    public String getShipperName() {
        return shipperName;
    }

    public void setShipperName(String shipperName) {
        this.shipperName = shipperName;
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

    public ShipperAuthentication() {

    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

package com.logistics.bean;

/**
 * Created by Administrator on 2016/10/28.
 */
public class Advertisement {
    int id;
    String image;
    int state;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Advertisement() {

    }

    public Advertisement(int id, String image, int state) {

        this.id = id;
        this.image = image;
        this.state = state;
    }
    public Advertisement(int id, String image) {
        this.id = id;
        this.image = image;
    }
}

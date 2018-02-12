package com.logistics.bean;

/**
 * Created by Administrator on 2016/10/28.
 */
public class CoachType {
    private int  id;
    private  String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public CoachType(int id, String type) {
        this.id = id;
        this.type = type;
    }

}

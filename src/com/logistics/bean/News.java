package com.logistics.bean;

/**
 * Created by Administrator on 2016/10/27.
 */
public class News {
    int id;
    String date;
    String title;
    String content;

    public News() {
    }

    public News(int id, String date, String title, String content) {

        this.id = id;
        this.date = date;
        this.title = title;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

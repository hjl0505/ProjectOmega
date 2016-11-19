package com.example.admin.myapplication.backend;

/**
 * The object model for the data we are sending through endpoints
 */
public class MyBean {

    private String name;
    private int id;
    private String bodypart;


    public String getData() {
        return name;
    }

    public void setData(String name, String bodypart, int id) {

        this.name = name;
        this.bodypart = bodypart;
        this.id = id;

    }
}
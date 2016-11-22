package com.example.admin.myapplication.backend;

import java.util.ArrayList;
import java.util.List;

public class ExerciseDetailData {

    private String name;
    private int difficulty;
    private String warning;
    private String link;
    private String description;
    private String direction;
    private List<String> equipments = new ArrayList<String>();
    private List<String> bodyparts = new ArrayList<String>();
    private List<String> injuries = new ArrayList<String>();


    public String getName() {
        return name;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public String getWarning() {
        return warning;
    }

    public String getLink() {
        return link;
    }

    public String getDescription () {
        return description;
    }

    public String getDirection() {
        return direction;
    }

    public List<String> getEquipments() {
        return equipments;
    }

    public List<String> getBodyparts() {
        return bodyparts;
    }

    public List<String> getInjuries() {
        return injuries;
    }

    public Object[] getData () {
        System.out.println("Getting detail data");
        Object[] data = new Object[9];
        data[0] = name;
        data[1] = difficulty;
        data[2] = warning;
        data[3] = link;
        data[4] = description;
        data[5] = direction;
        data[6] = equipments;
        data[7] = bodyparts;
        data[8] = injuries;
        return data;
    }

    public void setData(String name, int difficulty, String warning, String link, String description, String direction, String equipment, String bodypart, String injury) {

        System.out.println("SetDATA in Exercise Detail Data CALLED");

        this.name = name;
        this.difficulty = difficulty;
        if (warning!= null) {
            this.warning = warning;
        } else {
            warning = "";
        }
        if (link != null) {
            this.link = link;
        } else {
            link = "";
        }
        this.description = description;
        this.direction = direction;
        if (equipment != null) {
            addToList(equipments, equipment);
        }
        addToList(bodyparts, bodypart);

        if (injury != null) {
            addToList(injuries, injury);
        }

    }

    private void addToList(List list, String item) {
        // add item to list if doesn't already exist
        if (list.isEmpty()) {
            list.add(item);
        }
        else if (!list.contains(item)) {
            list.add(item);
        }
    }
}
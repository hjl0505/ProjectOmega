package com.example.admin.myapplication.backend;

import java.util.ArrayList;
import java.util.List;

public class ExerciseListData {

    private List<String> exercises = new ArrayList<String>();

    public List<String> getExercises() {
        return exercises;
    }

    public void setData(String exercise) {
        addToList(exercises, exercise);
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

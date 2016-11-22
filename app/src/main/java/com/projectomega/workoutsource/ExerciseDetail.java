package com.projectomega.workoutsource;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ExerciseDetail extends AppCompatActivity {
    public String exerciseName = "";
    private String name;
    private int difficulty;
    private String warning;
    private String link;
    private String description;
    private String direction;
    private List<String> equipments;
    private List<String> bodyparts;
    private List<String> injuries;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //////////////////////////////
        String exName = "bench press";
        //////////////////////////////

        queryDetails(exerciseName);
        super.onCreate(savedInstanceState);
    }

    public void display(Object[] data) {
        setContentView(R.layout.activity_exercise_detail);
        setTitle(R.string.exercise_detail);

        System.out.println("ExerciseDetail.java -- display() DISPLAY STUFF that's in the Data array");
    }

    public void queryDetails (String exName) {
        new ExerciseDetailAsyncTask(this, exName).execute();
    }
}

package com.projectomega.workoutsource;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ExerciseDetail extends AppCompatActivity {
    public String exerciseName = "";
    private String name; // 0
    private int difficulty;// 1
    private String warning; // 2
    private String link; // 3
    private String description; // 4
    private String direction; // 5
    private List<String> equipments; // 6
    private List<String> bodyparts; // 7
    private List<String> injuries; // 8


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //////////////////////////////
        String exName = getIntent().getStringExtra("body_part");
        //////////////////////////////

        queryDetails(exName);
        super.onCreate(savedInstanceState);
    }

    public void display(Object[] data) {
        setContentView(R.layout.activity_exercise_detail);
        setTitle(R.string.exercise_detail);
        TextView t = (TextView)findViewById(R.id.nameTextView);
        if (data[0] != null && data[0] instanceof String) // name
            t.setText(data[0].toString());
        TextView t1 = (TextView)findViewById(R.id.difficultyTextView);
        if (data[1] != null && data[1] instanceof BigDecimal) // difficulty
            t1.setText(data[1].toString());
        TextView t2 = (TextView)findViewById(R.id.descriptionTextView);
        if (data[4] != null && data[4] instanceof String) // description
            t2.setText(data[4].toString());
        System.out.println(data[0]);
        System.out.println(data[1]);
        System.out.println(data[2]);
        System.out.println(data[3]);
        System.out.println(data[4]);
        System.out.println(data[5]);
        System.out.println("ExerciseDetail.java -- display() DISPLAY STUFF that's in the Data array");
    }

    public void queryDetails (String exName) {
        new ExerciseDetailAsyncTask(this, exName).execute();
    }
}

package com.projectomega.workoutsource;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ExerciseDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_detail);
        setTitle(R.string.exercise_detail);
    }
}

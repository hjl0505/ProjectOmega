package com.projectomega.workoutsource;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class ExerciseList extends AppCompatActivity {

    public ListView listView;

    public List<String> bpList;
    public String[] workoutArray = {"a", "b", "c", "d"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ///////////////////////
        ///////////////////////
        bpList = new ArrayList<String>();
        bpList = getIntent().getStringArrayListExtra("body_part_list");
        /////////////////////////
        ////////////////////////

        queryExercises(bpList);
        super.onCreate(savedInstanceState);
    }

    public void display() {
        setContentView(R.layout.activity_exercise_list);
        setTitle(R.string.exercise_list);

        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.activity_listview, workoutArray);

        listView = (ListView) findViewById(R.id.workout_list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?>adapter, View v, int position, long id){
                String item = (String) adapter.getItemAtPosition(position);
                Intent intent = new Intent(ExerciseList.this,ExerciseDetail.class);
                intent.putExtra("body_part", item);
                startActivity(intent);
            }
        });
    }

    public void queryExercises (List<String> bpList) {
        new ExerciseListAsyncTask(this, bpList).execute();
    }

    public boolean setExerciseList(List<String> list) {
        if (list!= null) {
            workoutArray = new String[list.size()];
            for (int i = 0; i < list.size(); i++) {
                workoutArray[i] = list.get(i);
            }
            System.out.println();
        } else {
            System.out.println("ExerciseList is NULL -- ExerciseList.java");
        }

        return true;
    }
}

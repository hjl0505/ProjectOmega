package com.projectomega.workoutsource;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.widget.AdapterView.OnItemClickListener;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.view.View;

public class ExerciseList extends AppCompatActivity {

    public ListView listView;
    private String[] workoutArray = {"a", "b", "c", "d"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_list);
        setTitle(R.string.exercise_list);

        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.activity_listview, workoutArray);

        listView = (ListView) findViewById(R.id.workout_list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?>adapter, View v, int position, long id){
                Object item = adapter.getItemAtPosition(position);

                Intent intent = new Intent(ExerciseList.this,ExerciseDetail.class);
                //based on item add info to intent
                startActivity(intent);
            }
        });
    }

}

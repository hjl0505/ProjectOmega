package com.projectomega.workoutsource;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private boolean[] IsSelected;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IsSelected = new boolean[6];
        for (int i = 0; i < IsSelected.length; i++)
            IsSelected[i] = false;
    }

    public void queryWorkout(View view) {
        Intent intent = new Intent(this, ExerciseList.class);
        ArrayList<String> body_part_list = new ArrayList<String>();
        // check the boolean body part array and add the selected body part into a body part array list
        for (int i = 0; i < IsSelected.length; i++)
        {
            if (IsSelected[i])
              switch(i)
              {
                  case 0: body_part_list.add("chest");
                      break;
                  case 1: body_part_list.add("bicep");
                      break;
                  case 2: body_part_list.add("leg");
                      break;
                  case 3: body_part_list.add("shoulder");
                      break;
                  case 4: body_part_list.add("back");
                      break;
                  case 5: body_part_list.add("tricep");
                      break;
              }
        }
        intent.putStringArrayListExtra("body_part_list", body_part_list);
        startActivity(intent);
    }

    public void selectButton(View view) {
        switch(view.getId())
        {
            case R.id.button :
                IsSelected[0] = !IsSelected[0]; // Chest
                setBackgroundColor(view, IsSelected[0]);
                Toast.makeText(MainActivity.this,Boolean.toString(IsSelected[0]), Toast.LENGTH_SHORT).show();
                break;
            case R.id.button2 :
                IsSelected[1] = !IsSelected[1]; // Biceps
                setBackgroundColor(view, IsSelected[1]);
                Toast.makeText(MainActivity.this,Boolean.toString(IsSelected[1]), Toast.LENGTH_SHORT).show();
                break;
            case R.id.button3 :
                IsSelected[2] = !IsSelected[2]; // Legs
                setBackgroundColor(view, IsSelected[2]);
                Toast.makeText(MainActivity.this,Boolean.toString(IsSelected[2]), Toast.LENGTH_SHORT).show();
                break;
            case R.id.button4 :
                IsSelected[3] = !IsSelected[3]; // Shoulders
                setBackgroundColor(view, IsSelected[3]);
                Toast.makeText(MainActivity.this,Boolean.toString(IsSelected[3]), Toast.LENGTH_SHORT).show();
                break;
            case R.id.button5 :
                IsSelected[4] = !IsSelected[4]; // Back
                setBackgroundColor(view, IsSelected[4]);
                Toast.makeText(MainActivity.this,Boolean.toString(IsSelected[4]), Toast.LENGTH_SHORT).show();
                break;
            case R.id.button6 :
                IsSelected[5] = !IsSelected[5]; // Triceps
                setBackgroundColor(view, IsSelected[5]);
                Toast.makeText(MainActivity.this,Boolean.toString(IsSelected[5]), Toast.LENGTH_SHORT).show();
                break;
        }

    }
    public void setBackgroundColor(View view, boolean isSelected)
    {
        if (isSelected)
            view.setBackgroundColor(0xFFE57373);
        else
            view.setBackgroundColor(0xFFE0E0E0);
    }
}

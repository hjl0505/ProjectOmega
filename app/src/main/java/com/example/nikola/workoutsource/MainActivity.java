package com.example.nikola.workoutsource;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;



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

    void selectButton(View view)
    {
        switch(view.getId())
        {
            case R.id.button :
                IsSelected[0] = !IsSelected[0]; // Chest
                Toast.makeText(MainActivity.this,Boolean.toString(IsSelected[0]), Toast.LENGTH_SHORT).show();
                break;
            case R.id.button2 :
                IsSelected[1] = !IsSelected[1]; // Biceps
                Toast.makeText(MainActivity.this,Boolean.toString(IsSelected[1]), Toast.LENGTH_SHORT).show();
                break;
            case R.id.button3 :
                IsSelected[2] = !IsSelected[2]; // Legs
                Toast.makeText(MainActivity.this,Boolean.toString(IsSelected[2]), Toast.LENGTH_SHORT).show();
                break;
            case R.id.button4 :
                IsSelected[3] = !IsSelected[3]; // Shoulders
                Toast.makeText(MainActivity.this,Boolean.toString(IsSelected[3]), Toast.LENGTH_SHORT).show();
                break;
            case R.id.button5 :
                IsSelected[4] = !IsSelected[4]; // Back
                Toast.makeText(MainActivity.this,Boolean.toString(IsSelected[4]), Toast.LENGTH_SHORT).show();
                break;
            case R.id.button6 :
                IsSelected[5] = !IsSelected[5]; // Triceps
                Toast.makeText(MainActivity.this,Boolean.toString(IsSelected[5]), Toast.LENGTH_SHORT).show();
                break;
        }
    }
}

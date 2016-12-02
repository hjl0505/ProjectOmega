package com.projectomega.workoutsource;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URL;
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

    public void display(Object[] data)  {
        setContentView(R.layout.activity_exercise_detail);
        setTitle(R.string.exercise_detail);

        TextView t = (TextView)findViewById(R.id.nameTextView);
        if (data[0] != null && data[0] instanceof String) // name
            t.setText(data[0].toString());
        t = (TextView)findViewById(R.id.difficultyTextView);
        if (data[1] != null && data[1] instanceof BigDecimal) // difficulty
            t.setText(data[1].toString());
        t = (TextView)findViewById(R.id.warningTextView);
        if (data[2] != null && data[1] instanceof String) // warning
            t.setText(data[2].toString());

        new DownloadImageTask((ImageView) findViewById(R.id.workoutImageView))
                .execute(data[3].toString());

        t = (TextView)findViewById(R.id.descriptionTextView);
        if (data[4] != null && data[4] instanceof String) // description
            t.setText(data[4].toString());
        t = (TextView)findViewById(R.id.directionTextView);
        if (data[5] != null && data[5] instanceof String) // direction
            t.setText(data[5].toString());
        t = (TextView)findViewById(R.id.equipmentsTextView);
        if (data[6] != null && data[6] instanceof List) // description
            t.setText(data[6].toString());
        t = (TextView)findViewById(R.id.bodyPartsTextView);
        if (data[7] != null && data[7] instanceof List) // direction
            t.setText(data[7].toString());

        System.out.println(data[0]);
        System.out.println(data[1]);
        System.out.println(data[2]);
        System.out.println(data[3]);
        System.out.println(data[4]);
        System.out.println(data[5]);
        System.out.println(data[6]);
        System.out.println(data[7]);
        //System.out.println(data[8]); ArrayIndexOutOfBoundsException: length=8; index =8
        System.out.println("ExerciseDetail.java -- display() DISPLAY STUFF that's in the Data array");
    }

    public void queryDetails (String exName) {
        new ExerciseDetailAsyncTask(this, exName).execute();
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
}

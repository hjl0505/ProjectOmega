package com.projectomega.workoutsource;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;

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

        new DownloadImageTask((ImageView) findViewById(R.id.workoutImageView))
                .execute(data[3].toString());



        System.out.println("data size " + data.length);
        System.out.println("data[0] = " + data[0].toString());



        TextView t = null;
        for (int i = 0; i < data.length && data != null; i++)
        {
            switch(i)
            {
                case 0:
                    t = (TextView)findViewById(R.id.nameTextView);
                    break;
                case 1:
                    t = (TextView)findViewById(R.id.difficultyTextView);
                    break;
                case 2:
                    t = (TextView)findViewById(R.id.warningTextView);
                    break;
                case 4:
                    t = (TextView)findViewById(R.id.descriptionTextView);
                    break;
                case 5:
                    t = (TextView)findViewById(R.id.directionTextView);
                    break;
                case 6:
                    t = (TextView)findViewById(R.id.equipmentsTextView);
                    break;
                case 7:
                    t = (TextView)findViewById(R.id.bodyPartsTextView);
                    break;
            }
            if ((data[i] != null) && (data[i] instanceof String ||
                    data[i] instanceof BigDecimal || data[i] instanceof List) && (i != 3))
                t.setText(data[i].toString());
        }
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

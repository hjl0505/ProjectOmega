package com.projectomega.workoutsource;

import android.os.AsyncTask;

import com.example.admin.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;
import java.util.List;


class ExerciseDetailAsyncTask extends AsyncTask<Void, Void, List<Object>> {
    private static MyApi myApiService = null;
    ExerciseDetail exDetailClass;
    String exName;

    public ExerciseDetailAsyncTask (ExerciseDetail exDetailClass, String exName) {
        this.exDetailClass = exDetailClass;
        this.exName = exName;
    }

    @Override
    protected List<Object> doInBackground(Void... params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://projectomega-149302.appspot.com/_ah/api/");
            myApiService = builder.build();
        }

        try {
            List<Object> result = null;
            result = myApiService.getExerciseDetail(exName).execute().getData();
            return result;
        } catch (IOException e) {
            System.err.println("IO exeception in EndpointAsyncTask");
            return null;
        }
    }

    @Override
    protected void onPostExecute(List<Object> result) {
        if (result != null) {
            Object[] data = new Object[result.size()];
            for (int i = 0; i < result.size(); i++) {
                data[i] = result.get(i);
            }
            exDetailClass.display(data);
        } else {
            exDetailClass.display(null);
            System.out.println("ExerciseDetailAsyncTask.onPostExecute data is NULL");
        }
    }
}

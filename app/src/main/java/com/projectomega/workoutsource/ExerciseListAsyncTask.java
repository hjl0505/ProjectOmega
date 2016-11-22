package com.projectomega.workoutsource;


import android.os.AsyncTask;

import com.example.admin.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;
import java.util.List;

class ExerciseListAsyncTask extends AsyncTask<Void, Void, List<String>> {

    private static MyApi myApiService = null;
    ExerciseList exListClass;
    List<String> bpList;

    public ExerciseListAsyncTask (ExerciseList exListClass, List<String> bpList) {
        this.exListClass = exListClass;
        this.bpList = bpList;
    }

    @Override
    protected List<String> doInBackground(Void... params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://projectomega-149302.appspot.com/_ah/api/");
            myApiService = builder.build();
        }

        try {
            List<String> list = myApiService.getExerciseList(bpList).execute().getExercises();
            return list;
        } catch (IOException e) {
            System.err.println("IO exeception in EndpointAsyncTask");
            return null;
        }
    }

    @Override
    protected void onPostExecute(List<String> result) {
        exListClass.setExerciseList(result);
        exListClass.display();
    }
}

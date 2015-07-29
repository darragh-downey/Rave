package com.downeydarragh.rave;

import android.graphics.*;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.MalformedInputException;
import java.util.ArrayList;

/**
 * Created by Darragh on 29/07/2015.
 */
public class DownloadTask extends AsyncTask<URL, Void, ArrayList<Movie>> {
    private static final String TAG = DownloadTask.class.getSimpleName();

    @Override
    protected void onPreExecute() {
        // build url based on users selection
    }

    @Override
    protected ArrayList<Movie> doInBackground(URL... urls) {
        ArrayList<Movie> movies;
        URL url;
        HttpURLConnection urlConnection;
        try {
            url = new URL("");
            urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            readStream(in);

            urlConnection.disconnect();
        }catch (IOException e) {
            Log.e(TAG, e.getMessage());
        }catch(MalformedURLException e){

        }
        return movies;
    }

    @Override
    protected void onPostExecute(ArrayList<Movie> films) {

    }
}

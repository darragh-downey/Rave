package com.downeydarragh.rave;

import android.util.Log;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ProgressBar;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

/**
 * Created by Darragh on 29/07/2015.
 */
public class DownloadTask extends AsyncTask<String, Integer, ArrayList<Movie>> {
    private static final String LOG_TAG = DownloadTask.class.getSimpleName();

    private Context context;
    private URL url;
    private InputStream inputStream;
    private HttpURLConnection connection;
    private ProgressBar progressBar;
    private MovieAdapter adapter;
    private MovieGridFragment movieGridFragment;

    public DownloadTask(Context context){
        this.context = context;
        this.movieGridFragment = new MovieGridFragment();
        this.adapter = new MovieAdapter(context);
    }

    @Override
    protected void onPreExecute(){
        super.onPreExecute();
        //progressBar = (ProgressBar) findViewById(R.id.progress_circular);
    }

    @Override
    protected ArrayList<Movie> doInBackground(String... resources) {
        String resource = resources[0];
        String responseJson = null;
        BufferedReader bufferedReader = null;
        ArrayList<Movie> movies = new ArrayList<>();
        try{
            url = new URL(resource);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            try{
                //inputStream = new BufferedInputStream(connection.getInputStream());
                InputStreamReader inputStreamReader = new InputStreamReader(connection.getInputStream());
                if(connection.getInputStream() == null)
                    return null;
                /*
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder(inputStream.available());
                String line;
                while ((line = reader.readLine()) != null){
                    stringBuilder.append(line);
                }
                */
                // create array list of movies here
                MovieBuilder movieBuilder = new MovieBuilder();
                if (movies != null) {
                    movies.addAll(movieBuilder.getMovies(inputStreamReader));
                }
            }catch (IOException e){
                Log.e(LOG_TAG, "Error", e);
            }
        }catch (IOException e){
            Log.e(LOG_TAG, "IOException error", e);
            // If the code didn't successfully get the weather data, there's no point in attemping
            // to parse it.
            return null;
        } finally{
            if (connection != null) {
                connection.disconnect();
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (final IOException e) {
                    Log.e("PlaceholderFragment", "Error closing stream", e);
                }
            }
        }
        return movies;
    }

    @Override
    protected void onProgressUpdate(Integer... params) {
        //setProgressPercent(params[0]);
    } 

    @Override
    protected void onPostExecute(ArrayList<Movie> result){
        if(!adapter.movies.isEmpty()){
            adapter.movies.clear();
        }
        adapter.movies.addAll(result);
        adapter.notifyDataSetChanged();
    }
}

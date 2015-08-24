package com.downeydarragh.rave;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import java.net.URL;
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
    private View rootView;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private MovieAdapter adapter;

    public DownloadTask(Context context){
        this.context = context;
        rootView = ((Activity)context).getWindow().findViewById(R.id.root_view);
    }

    @Override
    protected void onPreExecute(){
        super.onPreExecute();
        //progressBar = (ProgressBar) findViewById(R.id.progress_circular);
    }

    @Override
    protected ArrayList<Movie> doInBackground(String... resources) {
        String resource = resources[0];
        ArrayList<Movie> movies = new ArrayList<>();
        try{
            url = new URL(resource);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            try{
                inputStream = new BufferedInputStream(connection.getInputStream());
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                if(inputStream == null)
                    return null;

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
    protected void onPostExecute(ArrayList<Movie> result){
        adapter = new MovieAdapter(context, result);
        adapter.notifyDataSetChanged();
        recyclerView = (RecyclerView) rootView.findViewById(R.id.movie_recycler_view);
        recyclerView.setAdapter(adapter);
    }
}

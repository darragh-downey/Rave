package com.downeydarragh.rave;

<<<<<<< HEAD
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;

import org.apache.http.params.HttpParams;
=======
import android.graphics.*;
import android.os.AsyncTask;
import android.util.Log;
>>>>>>> origin/master

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
<<<<<<< HEAD
import java.net.URL;
import java.net.URLConnection;
=======
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.MalformedInputException;
>>>>>>> origin/master
import java.util.ArrayList;

/**
 * Created by Darragh on 29/07/2015.
 */
<<<<<<< HEAD
public class DownloadTask extends AsyncTask<String, Integer, MovieAdapter> {
    private static final String LOG_TAG = DownloadTask.class.getSimpleName();

    private Context context;
    private URL url;
    private InputStream inputStream;
    private HttpURLConnection connection;
    private ProgressDialog progressDialog;

    public DownloadTask(Context context){
        this.context = context;
    }

    @Override
    protected void onPreExecute(){
        super.onPreExecute();
        progressDialog = ProgressDialog.show(context, "Wait", "Getting the latest films");
    }

    /**
     * Override this method to perform a computation on a background thread. The
     * specified parameters are the parameters passed to {@link #execute}
     * by the caller of this task.
     * <p/>
     * This method can call {@link #publishProgress} to publish updates
     * on the UI thread.
     *
     * @param resources The parameters of the task.
     * @return A result, defined by the subclass of this task.
     * @see #onPreExecute()
     * @see #onPostExecute
     * @see #publishProgress
     */
    @Override
    protected MovieAdapter doInBackground(String... resources) {
        String resource = resources[0];
        try{
            url = new URL(resource);
            connection = (HttpURLConnection) url.openConnection();
            inputStream = new BufferedInputStream(connection.getInputStream());

            byte[] buffer = new byte[1024 * 4];
            int size = 0;
            while ((size = inputStream.read(buffer)) != -1){

            }
        }catch (IOException e){
            Log.e(LOG_TAG, "IOException error", e);
        }finally {
            connection.disconnect();
        }

        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... params) {
        //setProgressPercent(params[0]);
    } 

    @Override
    protected void onPostExecute(MovieAdapter result){
=======
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
>>>>>>> origin/master

    }
}

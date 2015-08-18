package com.downeydarragh.rave;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Movie> movies = new ArrayList<Movie>();
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new DownloadTask(this).execute();

        mRecyclerView = (RecyclerView) findViewById(R.id.movie_recycler_view);

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new GridLayoutManager(this, 4);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new MovieAdapter(movies);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        DownloadTask downloadTask = null;
        RequestBuilder requestBuilder = new RequestBuilder(this);

        switch (item.getItemId()){
            case R.id.action_popular:
                downloadTask = new DownloadTask(this);
                downloadTask.execute(requestBuilder.getPopularMovies());
                return true;
            case R.id.action_highest:
                downloadTask = new DownloadTask(this);
                downloadTask.execute(requestBuilder.getHighestRated());
                return true;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

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
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private RequestBuilder requestBuilder = new RequestBuilder(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new DownloadTask(this).execute(requestBuilder.getPopularMovies());
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

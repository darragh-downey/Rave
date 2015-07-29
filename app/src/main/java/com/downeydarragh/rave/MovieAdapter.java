package com.downeydarragh.rave;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Darragh on 29/07/2015.
 */
public class MovieAdapter extends BaseAdapter {

    private Context mContext;
    private final ArrayList<Movie> mMovies;

    public MovieAdapter(Context context, ArrayList<Movie> films) {
        mContext = context;
        mMovies = films;
    }

    @Override
    public int getCount() {
        return mMovies.size();
    }

    @Override
    public Movie getItem(int position) {
        return mMovies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            grid = new View(mContext);
            grid = inflater.inflate(R.layout.movie_detail_fragment, null);
            TextView textView = (TextView) grid.findViewById(R.id.movie_title);
            ImageView imageView = (ImageView)grid.findViewById(R.id.movie_poster);
            textView.setText(mMovies.get(position).getTitle());
            imageView.setImageResource(mMovies.get(position).getPosterId());
        } else {
            grid = (View) convertView;
        }
        return grid;
    }
}

package com.downeydarragh.rave;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
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
<<<<<<< HEAD
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder>{
    private List<Movie> movies;


    public MovieAdapter(ArrayList<Movie> movies){
        this.movies = movies;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_card_view, parent, false);
        //set the view's size, margins, paddings and layout parameters

        MovieViewHolder viewHolder = new MovieViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        // set card information
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {

        public MovieViewHolder(View view){
            super(view);
=======
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
>>>>>>> origin/master

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

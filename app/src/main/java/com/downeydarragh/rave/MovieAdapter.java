package com.downeydarragh.rave;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Darragh on 29/07/2015.
 */
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder>{
    static ArrayList<Movie> movies = new ArrayList<>();
    static View.OnClickListener posterClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            MovieViewHolder movieViewHolder = (MovieViewHolder) v.getTag();
            int position = movieViewHolder.getAdapterPosition();
            Movie movie = movies.get(position);
            Toast.makeText(v.getContext(), movie.getTitle(), Toast.LENGTH_LONG).show();
        }
    };
    static Context context;

    public MovieAdapter(Context context, ArrayList<Movie> result){
        this.context = context;
        this.movies = result;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_card_view, parent, false);
        //set the view's size, margins, paddings and layout parameters
        MovieViewHolder viewHolder = new MovieViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final MovieViewHolder holder, int position) {
        // set card information
        Movie movie = movies.get(position);
        holder.bindMovie(movie);
        holder.imageView.setTag(holder);
        holder.imageView.setOnClickListener(posterClickListener);
        Picasso.with(context).load(movie.getPosterURI()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        protected Movie movie;
        protected ImageView imageView;

        public MovieViewHolder(View view) {
            super(view);
            // update the rest of the data  i.e. posters and titles
            imageView = (ImageView) view.findViewById(R.id.cardmovie_poster);
        }

        public void bindMovie(Movie movie) {
            this.movie = movie;
        }
    }
}

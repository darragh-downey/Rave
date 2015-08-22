package com.downeydarragh.rave;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Darragh on 29/07/2015.
 */
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder>{
    static List<Movie> movies;

    public MovieAdapter(ArrayList<Movie> movies){
        this.movies = movies;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_card_view, parent, false);
        //set the view's size, margins, paddings and layout parameters
        view.setOnClickListener(new OnPosterClickListener(){
            public void onClick(View v){
                Toast.makeText(parent.getContext(), "Clicked " + parent.indexOfChild(v), Toast.LENGTH_LONG).show();
            }
        });

        MovieViewHolder viewHolder = new MovieViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        // set card information
        ImageView imageView = (ImageView) holder.itemView.findViewById(R.id.cardmovie_poster);
        Picasso.with(holder.itemView.getContext()).load(movies.get(position).getPosterUri()).into(imageView);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public MovieViewHolder(View view) {
            super(view);
            // update the rest of the data  i.e. posters and titles
            view.setOnClickListener(this);
            ImageView imageView = (ImageView) view.findViewById(R.id.cardmovie_poster);
            Picasso.with(imageView.getContext()).load(movies.get(getAdapterPosition()).getPosterUri()).into(imageView);
        }

        /**
         * Called when a view has been clicked.
         *
         * @param v The view that was clicked.
         */
        @Override
        public void onClick(final View v) {
            //int posterPosition =
        }
    }
}

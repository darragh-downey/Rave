package com.downeydarragh.rave;

import com.downeydarragh.rave.*;
import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
/**
 * Created by darraghdowney on 17/08/15.
 */
public class RequestBuilder {
    private String requestURL;
    private Uri.Builder uriBuilder;
    private Context context;

    public RequestBuilder(Context context){
        this.context = context;
    }

    // http://api.themoviedb.org/3/discover/movie?sort_by=popularity.desc&api_key=1594010f449c11caf1fba711c8613b2c
    public String getPopularMovies(){
        requestURL = null;
        uriBuilder = new Uri.Builder();
        uriBuilder.scheme("http")
                .authority("api.themoviedb.org")
                .appendPath("3")
                .appendPath("discover")
                .appendPath("movie")
                .appendQueryParameter("sort_by", "popularity.desc")
                .appendQueryParameter("api_key", context.getString(R.string.api_key));
        requestURL = uriBuilder.build().toString();
        return requestURL;
    }

    // http://api.themoviedb.org/3/movie/top_rated?sort_by=popularity.desc&api_key=1594010f449c11caf1fba711c8613b2c
    public String getHighestRated(){
        requestURL = null;
        uriBuilder = new Uri.Builder();
        uriBuilder.scheme("http")
                .authority("api.themoviedb.org")
                .appendPath("3")
                .appendPath("movie")
                .appendPath("top_rated")
                .appendQueryParameter("sort_by", "popularity.desc")
                .appendQueryParameter("api_key", context.getString(R.string.api_key));
        requestURL = uriBuilder.build().toString();
        return requestURL;
    }
}
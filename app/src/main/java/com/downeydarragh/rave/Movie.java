package com.downeydarragh.rave;

import android.net.Uri;

/**
 * Created by Darragh on 29/07/2015.
 */
public class Movie {
    private int mId;
    private String mReleaseDate;
    private String mTitle;
    private String mPosterURI;
    private String mDescription;
    private int mRating;
    private Uri posterUri;

    public Movie(String title, String posterUri, String description){
        mTitle = title;
        mPosterURI = posterUri;
        mDescription = description;
    }

    public String getTitle(){
        return mTitle;
    }

    public String getPosterURI(){
        return mPosterURI;
    }

    public String getDescription(){
        return mDescription;
    }

    public Uri getPosterUri() {
        return posterUri;
    }
}

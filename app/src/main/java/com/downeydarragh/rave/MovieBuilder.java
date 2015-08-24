package com.downeydarragh.rave;

import android.util.JsonReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Darragh on 22/08/2015.
 */
public class MovieBuilder {

    public MovieBuilder(){}


    public ArrayList<Movie> getMovies(InputStreamReader inputStreamReader) throws IOException {
        JsonReader reader = new JsonReader(inputStreamReader);
        reader.setLenient(true);
        try{
            return readJsonObject(reader);
        }finally{
            reader.close();
        }
    }

    private ArrayList<Movie> readJsonObject(JsonReader reader) throws IOException {
        ArrayList<Movie> movies = new ArrayList<>();
        reader.beginObject();
        while (reader.hasNext()){
            String name = reader.nextName();
            if(name.equalsIgnoreCase("results"))
                movies = readJsonArray(reader);
            else
                reader.skipValue();
        }
        reader.endObject();
        return movies;
    }

    private ArrayList<Movie> readJsonArray(JsonReader reader) throws IOException {
        ArrayList<Movie> movieList = new ArrayList<>();
        reader.beginArray();
        while (reader.hasNext()){
            movieList.add(readMovie(reader));
        }
        reader.endArray();
        return movieList;
    }

    private Movie readMovie(JsonReader reader) throws IOException {
        Movie movie = new Movie();
        reader.beginObject();
        while (reader.hasNext()){
            String name = reader.nextName();
            if (name.equalsIgnoreCase("title")){
                movie.setTitle(reader.nextString());
            }else if(name.equalsIgnoreCase("overview")){
                movie.setSynopsis(reader.nextString());
            }else if(name.equalsIgnoreCase("release_date")){
                movie.setReleaseDate(reader.nextString());
            }else if(name.equalsIgnoreCase("poster_path")){
                movie.setPosterPath(reader.nextString());
            }else if(name.equalsIgnoreCase("vote_average")){
                movie.setAverageVote(reader.nextDouble());
            }else if(name.equalsIgnoreCase("id")){
                movie.setId(reader.nextInt());
            }else if(name.equalsIgnoreCase("popularity")){
                movie.setPopularity(reader.nextDouble());
            }else
                reader.skipValue();
        }
        reader.endObject();
        return movie;
    }
}
package com.downeydarragh.rave;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Darragh on 19/08/2015.
 */
public class MovieGridFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private MovieAdapter adapter;

    public MovieGridFragment(){}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie_grid, null);

        recyclerView = (RecyclerView) view.findViewById(R.id.movie_recycler_view);

        layoutManager = new GridLayoutManager(getActivity(), 4);

        recyclerView.setLayoutManager(layoutManager);

        adapter = new MovieAdapter(getActivity());
        adapter.setOnItemClickListener(new OnPosterClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Toast.makeText(getActivity(), "Hit poster number " + position, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onClick(View v) {

            }
        });
        recyclerView.setAdapter(adapter);
        return view;
    }


}

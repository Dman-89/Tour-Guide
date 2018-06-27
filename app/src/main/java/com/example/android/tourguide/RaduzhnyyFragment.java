package com.example.android.tourguide;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class RaduzhnyyFragment extends Fragment {

    public RaduzhnyyFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.sight_list, container, false);

        ArrayList<Sight> sights = new ArrayList<>();
        sights.add(new Sight(getResources().getString(R.string.bmp), getResources().getString(R.string.bmp_description), R.drawable.bmp));
        sights.add(new Sight(getResources().getString(R.string.chernobyl_monument), getResources().getString(R.string.chernobyl_monument_description), R.drawable.chernobyl_monument));
        sights.add(new Sight(getResources().getString(R.string.dragon), getResources().getString(R.string.dragon_description), R.drawable.dragon));
        sights.add(new Sight(getResources().getString(R.string.fountain), getResources().getString(R.string.fountain_description), R.drawable.fountain_raduzhnyy));
        sights.add(new Sight(getResources().getString(R.string.kosminov_monument), getResources().getString(R.string.kosminov_monument_description), R.drawable.kosminov_monument));
        sights.add(new Sight(getResources().getString(R.string.seamen_monument), getResources().getString(R.string.seamen_monument_description), R.drawable.monument_to_dead_seamen));
        sights.add(new Sight(getResources().getString(R.string.pentagon), getResources().getString(R.string.pentagon_description), R.drawable.pentagon));
        sights.add(new Sight(getResources().getString(R.string.stella), getResources().getString(R.string.stella_description), R.drawable.stella));

        SightAdapter adapter = new SightAdapter(getContext(), sights);

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.list);

        recyclerView.setAdapter(adapter);

        // ?? this is where one chooses in which layout RecyclerView should appear
        // in this case Linear (like ListView)
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // default 1dp line item divider in RecyclerView
        DividerItemDecoration itemDecor = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecor);

        return rootView;
    }
}

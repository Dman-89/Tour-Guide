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
public class SuzdalFragment extends Fragment {

    public SuzdalFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.sight_list, container, false);

        ArrayList<Sight> sights = new ArrayList<>();
        sights.add(new Sight(getResources().getString(R.string.eternal_fire), getResources().getString(R.string.eternal_fire_description), R.drawable.eternal_fire));
        sights.add(new Sight(getResources().getString(R.string.mead), getResources().getString(R.string.mead_description), R.drawable.mead));
        sights.add(new Sight(getResources().getString(R.string.pokrovskiy_monastery), getResources().getString(R.string.pokrovskiy_monastery_description), R.drawable.pokrovskiy_monastery));
        sights.add(new Sight(getResources().getString(R.string.pozharskiy_monument), getResources().getString(R.string.pozharskiy_monument_description), R.drawable.pozharskiy_monument));
        sights.add(new Sight(getResources().getString(R.string.rizopolozhenskiy_monastery), getResources().getString(R.string.rizopolozhenskiy_monastery_description), R.drawable.rizopolozhenskiy_monastery));
        sights.add(new Sight(getResources().getString(R.string.spaso_efimyev_monastery), getResources().getString(R.string.spaso_efimyev_monastery_description), R.drawable.spaso_efimyev_monastery));
        sights.add(new Sight(getResources().getString(R.string.suzdal_kremlin), getResources().getString(R.string.suzdal_kremlin_description), R.drawable.suzdal_kremlin));
        sights.add(new Sight(getResources().getString(R.string.trading_area), getResources().getString(R.string.trading_area_description), R.drawable.trading_area));
        sights.add(new Sight(getResources().getString(R.string.wooden_archtecture_museum), getResources().getString(R.string.wooden_archtecture_museum_description), R.drawable.wooden_architecture_museum));

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

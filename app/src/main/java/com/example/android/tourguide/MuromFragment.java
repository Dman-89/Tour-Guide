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
public class MuromFragment extends Fragment {

    public MuromFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.sight_list, container, false);

        ArrayList<Sight> sights = new ArrayList<>();
        sights.add(new Sight(getResources().getString(R.string.monument_to_ilya_muromets), getResources().getString(R.string.monument_to_ilya_muromets_address), getResources().getString(R.string.monument_to_ilya_muromets_description), R.drawable.monument_to_ilya_muromec));
        sights.add(new Sight(getResources().getString(R.string.karacharovo), getResources().getString(R.string.karacharovo_address), getResources().getString(R.string.karacharovo_description), R.drawable.karacharovo));
        sights.add(new Sight(getResources().getString(R.string.armored_train), getResources().getString(R.string.armored_train_address), getResources().getString(R.string.armored_train_description), R.drawable.ilya_muromec_armored_train));
        sights.add(new Sight(getResources().getString(R.string.murom_bridge), getResources().getString(R.string.murom_bridge_address), getResources().getString(R.string.murom_bridge_description), R.drawable.murom_bridge));
        sights.add(new Sight(getResources().getString(R.string.railway_museum), getResources().getString(R.string.railway_museum_address), getResources().getString(R.string.railway_museum_description), R.drawable.railway_station_and_museum));
        sights.add(new Sight(getResources().getString(R.string.spaso_preobrazhenskiy_monastery), getResources().getString(R.string.spaso_preobrazhenskiy_monastery_address), getResources().getString(R.string.spaso_preobrazhenskiy_monastery_description), R.drawable.spaso_preobrazhenskiy_monastery));
        sights.add(new Sight(getResources().getString(R.string.svyato_voznesenskiy_cathedral), getResources().getString(R.string.svyato_voznesenskiy_cathedral_address), getResources().getString(R.string.svyato_voznesenskiy_cathedral_description), R.drawable.svyato_voznesenskiy_cathedral));
        sights.add(new Sight(getResources().getString(R.string.ww2_monument_verbovchany), getResources().getString(R.string.ww2_monument_verbovchany_address), getResources().getString(R.string.ww2_monument_verbovchany_description), R.drawable.ww2_monument_verbovchany));
        sights.add(new Sight(getResources().getString(R.string.zvorykin_monument), getResources().getString(R.string.zvorykin_monument_address), getResources().getString(R.string.zvorykin_monument_description), R.drawable.zvorykin_monument));

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

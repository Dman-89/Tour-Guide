package com.example.android.tourguide;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class VladimirFragment extends Fragment {

    public VladimirFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.sight_list, container, false);

        ArrayList<Sight> sights = new ArrayList<>();
        sights.add(new Sight(getResources().getString(R.string.golden_gates), getResources().getString(R.string.golden_gates_address), getResources().getString(R.string.golden_gates_description), R.drawable.golden_gates));
        sights.add(new Sight(getResources().getString(R.string.central_park), getResources().getString(R.string.central_park_address), getResources().getString(R.string.central_park_description), R.drawable.central_park));
        sights.add(new Sight(getResources().getString(R.string.city_council), getResources().getString(R.string.city_council_address), getResources().getString(R.string.city_council_description), R.drawable.city_council));
        sights.add(new Sight(getResources().getString(R.string.crystal_museum), getResources().getString(R.string.crystal_museum_address), getResources().getString(R.string.crystal_museum_description), R.drawable.crystal_museum));
        sights.add(new Sight(getResources().getString(R.string.alexander_nevskiy_square), getResources().getString(R.string.alexander_nevskiy_square_address), getResources().getString(R.string.alexander_nevskiy_square_description), R.drawable.alexander_nevskiy_square));
        sights.add(new Sight(getResources().getString(R.string.dmitrievskiy_cathedral), getResources().getString(R.string.dmitrievskiy_cathedral_address), getResources().getString(R.string.dmitrieskiy_cathedral_description), R.drawable.dmitrievskiy_cathedral));
        sights.add(new Sight(getResources().getString(R.string.georgievakaya_street), getResources().getString(R.string.georgievakaya_street_address), getResources().getString(R.string.georgievakaya_street_description), R.drawable.georgievskaya_street));
        sights.add(new Sight(getResources().getString(R.string.lunacharskiy_theatre), getResources().getString(R.string.lunacharskiy_theatre_address), getResources().getString(R.string.lunacharskiy_theatre_description), R.drawable.lunacharskiy_theatre));
        sights.add(new Sight(getResources().getString(R.string.observation_deck), getResources().getString(R.string.observation_deck_address), getResources().getString(R.string.observation_deck_description), R.drawable.observation_deck));
        sights.add(new Sight(getResources().getString(R.string.old_pharmacy), getResources().getString(R.string.old_pharmacy_address), getResources().getString(R.string.old_pharmacy_description), R.drawable.old_pharmacy));
        sights.add(new Sight(getResources().getString(R.string.patriarchal_gardens), getResources().getString(R.string.patriarchal_gardens_address), getResources().getString(R.string.patriarchal_gardens_description), R.drawable.patriarchal_gardens));
        sights.add(new Sight(getResources().getString(R.string.spasskiy_hill), getResources().getString(R.string.spasskiy_hill_address), getResources().getString(R.string.spasskiy_hill_description), R.drawable.spasskiy_hill));
        sights.add(new Sight(getResources().getString(R.string.uspenskiy_cathedral), getResources().getString(R.string.uspenskiy_cathedral_address), getResources().getString(R.string.uspenskiy_cathedral_description), R.drawable.uspenskiy_cathedral));
        sights.add(new Sight(getResources().getString(R.string.water_tower), getResources().getString(R.string.water_tower_address), getResources().getString(R.string.water_tower_description), R.drawable.water_tower));
        sights.add(new Sight(getResources().getString(R.string.ww2_memorial), getResources().getString(R.string.ww2_memorial_address), getResources().getString(R.string.ww2_memorial_description), R.drawable.ww2memorial));

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

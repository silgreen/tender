package com.example.tender.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tender.R;
import com.example.tender.entities.Drink;
import com.example.tender.recyclerItemDesign.HomeItemAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        super.onViewCreated(view, savedInstanceState);
        BottomNavigationView bottomNavigationView = requireActivity().findViewById(R.id.nav_view);
        bottomNavigationView.setVisibility(View.VISIBLE);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewHomeItem);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        List<Drink> drinks = new ArrayList<>();
        Drink d1 = new Drink();
        Drink d2 = new Drink();
        d1.setNomeDrink("acqua");
        d1.setCategoria(Drink.tipoDrink.COCKTAIL);
        d2.setNomeDrink("caffe");
        d2.setCategoria(Drink.tipoDrink.FRULLATO);
        drinks.add(d1);
        drinks.add(d2);
        recyclerView.setAdapter(new HomeItemAdapter(drinks));
        return view ;
    }
}
package com.example.tender.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tender.R;
import com.example.tender.communication.SocketClient;
import com.example.tender.entities.Drink;
import com.example.tender.entities.Ingredients;
import com.example.tender.recyclerItemDesign.CocktailItemAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CocktailFragment extends Fragment {
    public static CocktailFragment newInstance(int data) {
        Bundle args = new Bundle();
        CocktailFragment fragment = new CocktailFragment();
        args.putInt("cocktail",data);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cocktail, container, false);
        super.onViewCreated(view, savedInstanceState);
        BottomNavigationView bottomNavigationView = requireActivity().findViewById(R.id.nav_view);
        bottomNavigationView.setVisibility(View.VISIBLE);

        List<Drink> listDrinks = new ArrayList<>();
        List<Ingredients> listIngredient = new ArrayList<>();
        SocketClient socketClient = new SocketClient(getContext());
        socketClient.retriveveCocktails(listDrinks,listIngredient);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewCocktailItem);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        //listDrinks.sort(Comparator.comparingInt(Drink::getVendite));
        recyclerView.setAdapter(new CocktailItemAdapter(listDrinks));
        for (Drink d:listDrinks) {
            d.addIngredientList(listIngredient);
        }
        return view ;
    }
}

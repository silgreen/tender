package com.example.tender.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tender.R;
import com.example.tender.communication.SocketClient;
import com.example.tender.entities.Drink;
import com.example.tender.entities.Ingredients;
import com.example.tender.recyclerItemDesign.HomeItemAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        super.onViewCreated(view, savedInstanceState);
        BottomNavigationView bottomNavigationView = requireActivity().findViewById(R.id.nav_view);
        bottomNavigationView.setVisibility(View.VISIBLE);

        List<Drink> listDrinks = new ArrayList<>();
        List<Ingredients> listIngredient = new ArrayList<>();
        SocketClient socketClient = new SocketClient(getContext());
        socketClient.startHomePage(listDrinks,listIngredient);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewHomeItem);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(new HomeItemAdapter(listDrinks));

        for (Drink d:listDrinks) {
            d.addIngredientList(listIngredient);
        }
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {

            }
        });
        return view ;
    }
}
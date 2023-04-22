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
import com.example.tender.fragments.adapter.HomeAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);
        List<Drink> drinkList = new ArrayList<>();
        drinkList.add(new Drink("palumbas"));
        HomeAdapter homeAdapter = new HomeAdapter(drinkList);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(homeAdapter);
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
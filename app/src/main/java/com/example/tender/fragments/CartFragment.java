package com.example.tender.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tender.R;
import com.example.tender.entities.Drink;
import com.example.tender.entities.Order;
import com.example.tender.recyclerItemDesign.CartItemAdapter;
import com.example.tender.recyclerItemDesign.HomeItemAdapter;

import java.util.ArrayList;
import java.util.List;

public class CartFragment extends Fragment {
    private TextView textViewTotale;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cart, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewCartItem);
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
        recyclerView.setAdapter(new CartItemAdapter(drinks));

        /*
        textViewTotale = view.findViewById(R.id.textViewTotaleCosto);
        String totale = Double.toString(new Order().getTotale());
        textViewTotale.setText(totale);
         */

        return view;
    }
}

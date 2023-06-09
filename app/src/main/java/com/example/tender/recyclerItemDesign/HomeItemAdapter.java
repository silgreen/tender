package com.example.tender.recyclerItemDesign;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tender.R;
import com.example.tender.entities.Drink;
import com.example.tender.entities.Ingredients;
import com.example.tender.entities.Order;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class HomeItemAdapter extends RecyclerView.Adapter<HomeItemAdapter.HomeItemHolder> {
    List<Drink> drinkList;
    List<Ingredients> ingredientsList;

    public HomeItemAdapter(List<Drink> drinkList){
        this.drinkList=drinkList;
    }
    @NonNull
    @Override
    public HomeItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_home_item,parent,false);
        return new HomeItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeItemHolder holder, int position) {
        if(drinkList.get(position).getCategoria() == Drink.tipoDrink.COCKTAIL)
            holder.tipoDrink.setText("Cocktail");
        else holder.tipoDrink.setText("Frullato");
        holder.nomeDrink.setText(drinkList.get(position).getNomeDrink());
        holder.descrizioneDrink.setText(drinkList.get(position).getDescrizione());
        holder.costoDrink.setText(String.format(Locale.getDefault(),"%.2f",drinkList.get(position).getCosto()));
        holder.venditeDrink.setText(String.format(Locale.getDefault(),"%d",drinkList.get(position).getVendite()));

        ingredientsList = new ArrayList<>(); //non so se serve
        ingredientsList.addAll(drinkList.get(position).getIngredientsList());//non so se serve
        holder.ins.addAll(ingredientsList);
    }

    @Override
    public int getItemCount() {
        if(drinkList.isEmpty())return 0;
        return drinkList.size();
    }

    public static class HomeItemHolder extends RecyclerView.ViewHolder{
        private final FloatingActionButton floatingActionButton;
        private final TextView nomeDrink;
        private final TextView descrizioneDrink;
        private final TextView costoDrink;
        private final TextView venditeDrink;
        private final TextView tipoDrink;
        private final List<Ingredients> ins;

        public HomeItemHolder(@NonNull View itemView) {
            super(itemView);
            tipoDrink = itemView.findViewById(R.id.textViewTipoDrink);
            nomeDrink = itemView.findViewById(R.id.textViewNomeDrink);
            /* codice da modificare */
            descrizioneDrink = itemView.findViewById(R.id.textViewDescrizione);
            costoDrink = itemView.findViewById(R.id.textViewCosto);
            venditeDrink = itemView.findViewById(R.id.textViewVendite);
            ins = new ArrayList<>();
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("ingredientList", ins + "");
                }
            });
            /*fine codice da modificare*/
            floatingActionButton = itemView.findViewById(R.id.floatingActionButtonAdd);

            floatingActionButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Drink drink = new Drink();
                    drink.setNomeDrink(nomeDrink.getText().toString());
                    drink.setDescrizione(descrizioneDrink.getText().toString());
                    drink.setCategoria(Drink.tipoDrink.valueOf(tipoDrink.getText().toString()));
                    drink.setCosto(Float.parseFloat(costoDrink.getText().toString()));
                    Order.getInstance().getDrinkList().add(drink);
                    Toast.makeText(view.getContext(), "Drink aggiunto al carrello", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}

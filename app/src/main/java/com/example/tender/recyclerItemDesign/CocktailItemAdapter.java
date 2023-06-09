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

public class CocktailItemAdapter extends RecyclerView.Adapter<CocktailItemAdapter.CocktailItemHolder> {
    List<Drink> drinkList;
    List<Ingredients> ingredientsList;

    public CocktailItemAdapter(List<Drink> drinkList){
        this.drinkList=drinkList;
    }

    @NonNull
    @Override
    public CocktailItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_cocktail_item,parent,false);
        return new CocktailItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CocktailItemHolder holder, int position) {
        holder.tipoDrink.setText("Cocktail");
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


    public static class CocktailItemHolder extends RecyclerView.ViewHolder{
        private final FloatingActionButton floatingActionButton;
        private final TextView nomeDrink;
        private final TextView descrizioneDrink;
        private final TextView costoDrink;
        private final TextView venditeDrink;
        private final TextView tipoDrink;
        private final List<Ingredients> ins;

        public CocktailItemHolder(@NonNull View itemView) {
            super(itemView);
            tipoDrink = itemView.findViewById(R.id.textViewCocktailTipoDrink);
            nomeDrink = itemView.findViewById(R.id.textViewNomeDrinkCocktail);
            /* codice da modificare */
            descrizioneDrink = new TextView(itemView.getContext());
            costoDrink = new TextView(itemView.getContext());
            venditeDrink = new TextView(itemView.getContext());
            ins = new ArrayList<>();
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("ingredientList", ins + "");
                }
            });
            /*fine codice da modificare*/
            floatingActionButton = itemView.findViewById(R.id.floatingActionButtonAddCocktail);

            floatingActionButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Drink drink = new Drink();
                    drink.setNomeDrink(nomeDrink.getText().toString());
                    drink.setCosto(Float.parseFloat(costoDrink.getText().toString()));
                    Order.getInstance().getDrinkList().add(drink);
                    Toast.makeText(view.getContext(), "Drink aggiunto al carrello", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}

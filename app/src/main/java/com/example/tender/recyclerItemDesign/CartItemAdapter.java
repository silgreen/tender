package com.example.tender.recyclerItemDesign;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tender.R;
import com.example.tender.entities.Drink;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class CartItemAdapter extends RecyclerView.Adapter<CartItemAdapter.CartItemHolder> {
    List<Drink> drinkList;

    public CartItemAdapter(List<Drink> drinkList){
        this.drinkList=drinkList;
    }
    @NonNull
    @Override
    public CartItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_cart_item,parent,false);
        return new CartItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartItemHolder holder, int position) {
        if(drinkList.get(position).getCategoria() == Drink.tipoDrink.COCKTAIL)
            holder.tipoDrink.setText("Cocktail");
        else holder.tipoDrink.setText("Frullato");
        holder.nomeDrink.setText(drinkList.get(position).getNomeDrink());
    }

    @Override
    public int getItemCount() {
        return drinkList.size();
    }

    public static class CartItemHolder extends RecyclerView.ViewHolder{
        private final FloatingActionButton floatingActionButton;
        private final TextView nomeDrink;
        private final TextView tipoDrink;
        public CartItemHolder(@NonNull View itemView) {
            super(itemView);
            tipoDrink = itemView.findViewById(R.id.textViewTipoDrinkCart);
            nomeDrink = itemView.findViewById(R.id.textViewNomeDrinkCart);
            floatingActionButton = itemView.findViewById(R.id.floatingActionButtonRemove);

            floatingActionButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //remove drink on cart
                    //aggiorna il totale
                }
            });
        }
    }
}

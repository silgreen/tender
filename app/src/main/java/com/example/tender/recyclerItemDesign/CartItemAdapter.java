package com.example.tender.recyclerItemDesign;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tender.R;
import com.example.tender.entities.Drink;
import com.example.tender.entities.Order;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;
import java.util.Locale;

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
        holder.descrizioneDrink.setText(drinkList.get(position).getDescrizione());
        holder.costoDrink.setText(String.format(Locale.getDefault(),"%.2f",drinkList.get(position).getCosto()));
        holder.venditeDrink.setText(String.format(Locale.getDefault(),"%d",drinkList.get(position).getVendite()));
        holder.floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Order.getInstance().getDrinkList().remove(drinkList.get(holder.getAdapterPosition()));
                Toast.makeText(view.getContext(), "Drink rimosso dal carrello", Toast.LENGTH_SHORT).show();
                notifyItemRemoved(holder.getAdapterPosition());
                TextView textView = view.getRootView().findViewById(R.id.textViewTotaleCosto);
                String tot = String.format(Locale.getDefault(),"%.2f",Order.getInstance().getTotale());
                textView.setText(tot);

            }
        });
    }

    @Override
    public int getItemCount() {
        if(drinkList == null) return 0;
        return drinkList.size();
    }


    public static class CartItemHolder extends RecyclerView.ViewHolder{
        private final FloatingActionButton floatingActionButton;
        private final TextView nomeDrink;
        private final TextView tipoDrink;
        private final TextView descrizioneDrink;
        private final TextView costoDrink;
        private final TextView venditeDrink;

        public CartItemHolder(@NonNull View itemView) {
            super(itemView);
            tipoDrink = itemView.findViewById(R.id.textViewTipoDrinkCart);
            nomeDrink = itemView.findViewById(R.id.textViewNomeDrinkCart);

            /* codice da modificare */
            descrizioneDrink = new TextView(itemView.getContext());
            costoDrink = new TextView(itemView.getContext());
            venditeDrink = new TextView(itemView.getContext());
            /*fine codice da modificare*/
            floatingActionButton = itemView.findViewById(R.id.floatingActionButtonRemove);

        }
    }
}

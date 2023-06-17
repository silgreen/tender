package com.example.tender.fragments.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.tender.R;
import com.example.tender.entities.Drink;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    private final List<Drink> drinkList;
    public HomeAdapter(List<Drink> drinkList) {
        this.drinkList = drinkList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.getNomeDrink().setText(drinkList.get(position).getNomeDrink());
        holder.getDescrizioneDrink().setText(drinkList.get(position).getDescrizione());
        holder.getImageViewDrink().setImageResource(R.drawable.drink);
    }

    @Override
    public int getItemCount() {
        return drinkList.size();
    }

    public static class  ViewHolder extends RecyclerView.ViewHolder {
        private final TextView nomeDrink;
        private final ImageView imageViewDrink;
        private final TextView descrizioneDrink;
        private final FloatingActionButton addDrinkButton;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nomeDrink = itemView.findViewById(R.id.usernameLabel);
            imageViewDrink = itemView.findViewById(R.id.imageView);
            descrizioneDrink = itemView.findViewById(R.id.nome_ingrediente);
            addDrinkButton = itemView.findViewById(R.id.floatingActionButton);
        }

        public FloatingActionButton getAddDrinkButton() {
            return addDrinkButton;
        }

        public ImageView getImageViewDrink() {
            return imageViewDrink;
        }

        public TextView getDescrizioneDrink() {
            return descrizioneDrink;
        }

        public TextView getNomeDrink() {
            return nomeDrink;
        }
    }
}

package com.example.tender.fragments.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tender.R;
import com.example.tender.entities.Ingredients;

import java.util.List;

public class IngredientsAdapter extends RecyclerView.Adapter<IngredientsAdapter.ViewHolder>{

    private final List<Ingredients> ingredientList;

    public IngredientsAdapter(List<Ingredients> ingredientList) {
        this.ingredientList = ingredientList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ingredient_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.getNomeIngrediente().setText(ingredientList.get(position).getNomeIngrediente());
    }

    @Override
    public int getItemCount() {
        return ingredientList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView nomeIngrediente;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nomeIngrediente = itemView.findViewById(R.id.nome_ingrediente);
        }

        public TextView getNomeIngrediente() {
            return nomeIngrediente;
        }
    }
}

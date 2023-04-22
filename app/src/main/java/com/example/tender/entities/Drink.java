package com.example.tender.entities;

import java.util.ArrayList;
import java.util.List;

public class Drink {

    private String nomeDrink;
    private String descrizione;
    private List<Ingredients> ingredientsList;

    public Drink(String nomeDrink) {
        this.nomeDrink = nomeDrink;
        ingredientsList = new ArrayList<>();
        ingredientsList.add(new Ingredients("ingrediente strano"));
    }

    public List<Ingredients> getIngredientsList() {
        return ingredientsList;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public String getNomeDrink() {
        return nomeDrink;
    }

    public void setIngredientsList(List<Ingredients> ingredientsList) {
        this.ingredientsList = ingredientsList;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setNomeDrink(String nomeDrink) {
        this.nomeDrink = nomeDrink;
    }
}

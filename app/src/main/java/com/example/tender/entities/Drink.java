package com.example.tender.entities;

import java.util.List;

public class Drink {

    private String nomeDrink;
    private String descrizione;
    private List<Ingredients> ingredientsList;

    //INIZIO modifiche ale
    private int vendite; // potrebbe servire per il criterio dei consigli dei drink
    private double costo;
    private boolean category; // false = cocktail ; true = frullato ;; si potrebbe anche cambiare il tipo in un enumerazione
    public enum tipoDrink {COCKTAIL,FRULLATO};
    private tipoDrink categoria;

    public int getVendite() {
        return vendite;
    }
    public void addVendita(){
        vendite++;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public tipoDrink getCategoria() {
        return categoria;
    }

    public void setCategoria(tipoDrink categoria) {
        this.categoria = categoria;
    }

    //FINE modifiche ale

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

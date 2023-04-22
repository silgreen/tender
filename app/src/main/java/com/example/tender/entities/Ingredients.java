package com.example.tender.entities;

public class Ingredients {
    private String nomeIngrediente;

    public Ingredients(String nomeIngrediente) {
        this.nomeIngrediente = nomeIngrediente;
    }

    public String getNomeIngrediente() {
        return nomeIngrediente;
    }

    public void setNomeIngrediente(String nomeIngrediente) {
        this.nomeIngrediente = nomeIngrediente;
    }
}

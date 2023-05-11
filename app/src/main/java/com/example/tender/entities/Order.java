package com.example.tender.entities;

import java.util.List;

public class Order {
    private User user;
    private List<Drink> drinkList;

    public List<Drink> getDrinkList() {
        return drinkList;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setDrinkList(List<Drink> drinkList) {
        this.drinkList = drinkList;
    }

    public User getUser() {
        return user;
    }

    //modifiche ale
    public double getTotale(){
        double totale = 0;
        for (Drink d : drinkList) {
            totale+=d.getCosto();
        }
        return totale;
    }
    //fine modifiche
}

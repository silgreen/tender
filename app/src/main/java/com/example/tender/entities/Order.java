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
        return drinkList.stream().mapToDouble(Drink::getCosto).sum();
    }
    //fine modifiche
}

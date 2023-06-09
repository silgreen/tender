package com.example.tender.entities;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private static Order instance = null;
    private User user;
    private List<Drink> drinkList;

    private Order(){
        drinkList = new ArrayList<>();
    }

    public static Order getInstance() {
        if(instance == null) instance = new Order();
        return instance;
    }

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


    public float getTotale(){
        /*Mi da errore*/
        //return drinkList.stream().mapToDouble(Drink::getCosto).sum();
        float totale = 0.0f;
        if(drinkList!=null){
            for (Drink d:drinkList) {
                totale += d.getCosto();
            }
        }
        return totale;
    }
}

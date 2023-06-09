package com.example.tender.entities;

public class User {

    private String username;

    //modifiche ale
    private String password; //se si vuole anche la password ,potrebbe non servire
    private float portafoglio; // per fare acquisti

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public float getPortafoglio() {
        return portafoglio;
    }
    public void addMoney(double money){
        portafoglio+=money;
    }

    //fine modifiche ale
    public String getUsername() {
        return username;
    }

    public void setPortafoglio(float portafoglio) {
        this.portafoglio = portafoglio;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}

package com.example.tender.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavHost;
import androidx.navigation.fragment.NavHostFragment;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.tender.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences sharedPreferences = getSharedPreferences("info",MODE_PRIVATE);
        boolean logged = sharedPreferences.getBoolean("logged",false);
        if(!logged) {

        }
    }
}
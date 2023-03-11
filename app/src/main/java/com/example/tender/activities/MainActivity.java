package com.example.tender.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.NavHost;
import androidx.navigation.fragment.NavHostFragment;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.tender.R;
import com.example.tender.fragments.HomeFragment;
import com.example.tender.fragments.LoginFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.nav_host_fragment);
        NavController navController = navHostFragment.getNavController();
        SharedPreferences sharedPreferences = getSharedPreferences("info",MODE_PRIVATE);
        boolean logged = sharedPreferences.getBoolean("logged",false);
        if(!logged) navController.navigate(R.id.loginFragment2);
    }
}
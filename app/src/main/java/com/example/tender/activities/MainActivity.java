package com.example.tender.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.NavHost;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.tender.R;
import com.example.tender.fragments.HomeFragment;
import com.example.tender.fragments.LoginFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navView= findViewById(R.id.nav_view);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home,R.id.navigation_search,R.id.navigation_carrello,R.id.navigation_profile
        ).build();

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.nav_host_fragment);
        NavController navController = navHostFragment.getNavController();
        NavigationUI.setupActionBarWithNavController(this,navController,appBarConfiguration);
        NavigationUI.setupWithNavController(navView,navController);
        navView.setVisibility(View.GONE);
        SharedPreferences sharedPreferences = getSharedPreferences("info",MODE_PRIVATE);
        boolean logged = sharedPreferences.getBoolean("logged",false);
        //if(!logged)
        navController.navigate(R.id.navigation_home);


    }
}
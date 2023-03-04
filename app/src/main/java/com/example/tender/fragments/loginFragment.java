package com.example.tender.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tender.R;

public class loginFragment extends Fragment {

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login,container,false);
        EditText usernameEditText = view.findViewById(R.id.usernameEditText);
        EditText passwordEditText = view.findViewById(R.id.passwordEditText);
        view.findViewById(R.id.loginButton).setOnClickListener(view1 -> {
            String usernameString = usernameEditText.getText().toString();
            String passwordString = passwordEditText.getText().toString();
            String responseLogin; //attesa risposta da login
            if(responseLogin.equals("OK")) {
                SharedPreferences.Editor editor = view.getContext().getSharedPreferences("info", Context.MODE_PRIVATE).edit();
                editor.putBoolean("logged",true);
                editor.apply();
                //changeFragment to Homepage
            } else {
                Toast.makeText(view.getContext(), responseLogin, Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
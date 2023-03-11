package com.example.tender.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tender.R;

public class LoginFragment extends Fragment {

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
            //attesa risposta da login per ora usiamo i campi direttamente
            if(!usernameString.isEmpty() && !passwordString.isEmpty()) {
                SharedPreferences.Editor editor = view.getContext().getSharedPreferences("info", Context.MODE_PRIVATE).edit();
                editor.putBoolean("logged",true);
                editor.apply();
                Navigation.findNavController(view).popBackStack(R.id.homeFragment,false);

            } else {
                Toast.makeText(view.getContext(), "Username o password errati", Toast.LENGTH_SHORT).show();
            }
        });
        view.findViewById(R.id.registratiLabel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.registerFragment);
            }
        });
        return view;
    }
}
package com.example.tender.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tender.R;
import com.example.tender.communication.SocketClient;
import com.example.tender.entities.User;

public class LoginFragment extends Fragment {

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login,container,false);
        EditText usernameEditText = view.findViewById(R.id.usernameEditText);
        EditText passwordEditText = view.findViewById(R.id.passwordEditText);
        SocketClient socketClient = new SocketClient(getContext());
        view.findViewById(R.id.loginButton).setOnClickListener(view1 -> {
            String usernameString = usernameEditText.getText().toString();
            String passwordString = passwordEditText.getText().toString();
            User user = new User();
            user.setUsername(usernameString);
            user.setPassword(passwordString);
            if(!usernameString.isEmpty() && !passwordString.isEmpty() && socketClient.requestLogin(user)) {
                SharedPreferences preferences = getActivity().getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putBoolean("logged",true);
                editor.putString("username",user.getUsername());
                editor.putFloat("portafoglio",user.getPortafoglio());
                editor.apply();
                Navigation.findNavController(view).navigate(R.id.navigation_home);
            } else {
                Toast.makeText(view.getContext(), "Username o password errati", Toast.LENGTH_SHORT).show();
            }
        });
        view.findViewById(R.id.registratiLabel).setOnClickListener(
                v -> Navigation.findNavController(view).navigate(R.id.registerFragment));
        return view;
    }
}
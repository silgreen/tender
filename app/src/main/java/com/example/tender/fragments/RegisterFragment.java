package com.example.tender.fragments;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
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

public class RegisterFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        EditText userameEditText = view.findViewById(R.id.usernameEditText);
        EditText passwordEditText = view.findViewById(R.id.passwordEditText);

        SocketClient socketClient = new SocketClient(getContext());
        view.findViewById(R.id.registratiButton).setOnClickListener(view1 -> {
            String username = userameEditText.getText().toString();
            String password = passwordEditText.getText().toString();
            if(!username.isEmpty() && !password.isEmpty()) {
                User user = new User();
                user.setUsername(username);
                user.setPassword(password);

                if (socketClient.requestRegistrazione(user)) {
                    Toast.makeText(getContext(), "Registrato", Toast.LENGTH_SHORT).show();
                    Navigation.findNavController(view).navigate(R.id.loginFragment2);
                }else
                    Toast.makeText(getContext(), "Username già esistente", Toast.LENGTH_SHORT).show();
            }
        });
        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Registrati");
        }
        return view;
    }
}
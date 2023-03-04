package com.example.tender.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.example.tender.R;

public class RegisterActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.tender.R.layout.activity_register);
        EditText username = findViewById(R.id.usernameEditText);
        EditText password = findViewById(R.id.passwordEditText);
        findViewById(R.id.loginButton).setOnClickListener(view -> {
            String usernameString = username.getText().toString();
            String passwordString = password.getText().toString();
            if(!usernameString.isEmpty() && !passwordString.isEmpty()) {
                Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
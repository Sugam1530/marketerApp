package com.example.marketer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class activity_signin_password extends AppCompatActivity {

    Button loginbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin_password);

        loginbtn = findViewById(R.id.loggingbtn);

        loginbtn.setOnClickListener(v -> {
           Intent intent = new Intent(getApplicationContext(), MainActivity.class);
           startActivity(intent);
        });
    }
}
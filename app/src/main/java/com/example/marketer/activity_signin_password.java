package com.example.marketer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class activity_signin_password extends AppCompatActivity {

    Button loginbtn;
    SharedPreferences sharedPreferences;
    EditText username;

    public static final String userName = "userName";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin_password);

        loginbtn = findViewById(R.id.loggingbtn);
        sharedPreferences = getSharedPreferences(userName, Context.MODE_PRIVATE);
        username = findViewById(R.id.username);

        loginbtn.setOnClickListener(v -> {
            String cacheUsername = username.getText().toString();
            SharedPreferences.Editor editor = sharedPreferences.edit() ;
            editor.putString("uName",cacheUsername) ;
            editor.putBoolean("userLoggedInFlag", true) ;
            editor.apply();
           Intent intent = new Intent(getApplicationContext(), MainActivity.class);
           startActivity(intent);
        });
    }
}
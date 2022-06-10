package com.example.marketer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;

public class splash_screen extends AppCompatActivity {

    LauncherManager launcherManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        launcherManager = new LauncherManager(this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sharedPreferencesUserSpecific = getSharedPreferences("userName", Context.MODE_PRIVATE);
                if(sharedPreferencesUserSpecific.getBoolean("userLoggedInFlag", false))
                {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                }
                else {
                    startActivity(new Intent(getApplicationContext(), activity_signin_password.class));

                }

            }
        }, 2000);
    }
}
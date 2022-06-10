package com.example.marketer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    LinearLayout layoutWalletbalance, layoutfarmerList, farmerProfile;
    SharedPreferences sharedPreferences;
    TextView userName;
    public static final String userNameKey = "userName";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layoutWalletbalance = findViewById(R.id.layoutWalletbalance);
        layoutfarmerList = findViewById(R.id.layoutfarmerList);
        farmerProfile = findViewById(R.id.farmerProfile);
        userName = findViewById(R.id.userName);
        SharedPreferences sharedPreferences = getSharedPreferences(userNameKey, Context.MODE_PRIVATE);
        userName.setText(sharedPreferences.getString("uName",""));
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationMenu);

        bottomNavigationView.setSelectedItemId(R.id.menuHome);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menuFarmerList:
                        startActivity(new Intent(getApplicationContext(),
                                farmer_list.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.menuHome:
                        return true;
                    case R.id.menuProfile:
                        startActivity(new Intent(getApplicationContext(),
                                profile.class));
                        overridePendingTransition(0,0);
                }
                return false;
            }
        });

        layoutWalletbalance.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), activity_transaction_history.class);
            startActivity(intent);
        });

        layoutfarmerList.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), farmer_list.class);
            startActivity(intent);
        });

        farmerProfile.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), profile.class);
            startActivity(intent);
        });
    }
}
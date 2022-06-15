package com.example.marketer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

import Adapter.FarmerAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class farmer_list extends AppCompatActivity {

    ApiInterface apiInterface;
    RecyclerView recyclerView;
    Button addFarmer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_list);

        apiInterface = RetrofitInstance.getRetrofit().create(ApiInterface.class);
        recyclerView = findViewById(R.id.recyclerView);
        addFarmer = findViewById(R.id.textAddFarmer);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(farmer_list.this);
        String userId = preferences.getString("userId", "");
        apiInterface.getAllFarmerListbyMarketer(Integer.parseInt(userId)).enqueue(new Callback<ResponseArrayFarmerOverview>() {
            @Override
            public void onResponse(Call<ResponseArrayFarmerOverview> call, Response<ResponseArrayFarmerOverview> response) {
                if (response.body() != null){
                    List<FarmerOverview> farmerList = response.body().getResponse();
                    FarmerAdapter farmerAdapter = new FarmerAdapter(farmer_list.this, farmerList);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(farmer_list.this);
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setAdapter(farmerAdapter);
                }
            }

            @Override
            public void onFailure(Call<ResponseArrayFarmerOverview> call, Throwable t) {
                Toast.makeText(farmer_list.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        addFarmer.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), activity_add_farmer.class);
            startActivity(intent);
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationMenu);

        bottomNavigationView.setSelectedItemId(R.id.menuFarmerList);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menuFarmerList:
                        return true;
                    case R.id.menuHome:
                        startActivity(new Intent(getApplicationContext(),
                                MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.menuProfile:
                        startActivity(new Intent(getApplicationContext(),
                                profile.class));
                        overridePendingTransition(0,0);
                }
                return false;
            }
        });
    }
}
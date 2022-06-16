package com.example.marketer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    LinearLayout layoutWalletbalance, layoutfarmerList, farmerProfile;
    SharedPreferences sharedPreferences;
    TextView userName, walletAmount, marketerName, marketerEmail, farmerNumber;
    public static final String userNameKey = "userName";
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layoutWalletbalance = findViewById(R.id.layoutWalletbalance);
        layoutfarmerList = findViewById(R.id.layoutfarmerList);
        farmerProfile = findViewById(R.id.farmerProfile);
        userName = findViewById(R.id.userName);
        walletAmount = findViewById(R.id.walletAmount);
        marketerName = findViewById(R.id.farmerName);
        marketerEmail = findViewById(R.id.farmerId);
        farmerNumber = findViewById(R.id.farmerNumber);

        SharedPreferences sharedPreferences = getSharedPreferences(userNameKey, Context.MODE_PRIVATE);
//        userName.setText(sharedPreferences.getString("uName",""));
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationMenu);
        apiInterface = RetrofitInstance.getRetrofit().create(ApiInterface.class);


        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        String userId = preferences.getString("userId", "");
        apiInterface.getMarketerProfile(Integer.parseInt(userId)).enqueue(new Callback<ResponseArrayMarketerProfileOverview>() {
            @Override
            public void onResponse(Call<ResponseArrayMarketerProfileOverview> call, Response<ResponseArrayMarketerProfileOverview> response) {
                if (response.body() != null && response.body().getResponse() != null){
                    walletAmount.setText(response.body().getResponse().getWallet_balance());
                    marketerName.setText(response.body().getResponse().getName());
                    marketerEmail.setText(response.body().getResponse().getEmail());
                }
            }

            @Override
            public void onFailure(Call<ResponseArrayMarketerProfileOverview> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        apiInterface.getAllFarmerListbyMarketer(Integer.parseInt(userId)).enqueue(new Callback<ResponseArrayFarmerOverview>() {
            @Override
            public void onResponse(Call<ResponseArrayFarmerOverview> call, Response<ResponseArrayFarmerOverview> response) {
                if (response.body() != null){
                    farmerNumber.setText(Integer.toString(response.body().getResponse().size()));
                }
            }

            @Override
            public void onFailure(Call<ResponseArrayFarmerOverview> call, Throwable t) {

            }
        });

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
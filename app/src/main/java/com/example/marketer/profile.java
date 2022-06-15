package com.example.marketer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class profile extends AppCompatActivity {

    ApiInterface apiInterface;
    TextView tvName, tvEmail, tvWalletBalance, tvPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        tvName = findViewById(R.id.tvname);
        tvEmail = findViewById(R.id.tvemail);
        tvWalletBalance = findViewById(R.id.tvwalletbalance);
        tvPassword = findViewById(R.id.tvUserPassword);
        apiInterface = RetrofitInstance.getRetrofit().create(ApiInterface.class);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(profile.this);
        String userId = preferences.getString("userId", "");
        apiInterface.getMarketerProfile(Integer.parseInt(userId)).enqueue(new Callback<ResponseArrayMarketerProfileOverview>() {
            @Override
            public void onResponse(Call<ResponseArrayMarketerProfileOverview> call, Response<ResponseArrayMarketerProfileOverview> response) {
                if (response.body() != null && response.body().getResponse() != null){
                    tvName.setText(response.body().getResponse().getName());
                    tvPassword.setText(response.body().getResponse().getUsername());
                    tvEmail.setText(response.body().getResponse().getEmail());
                    tvWalletBalance.setText(response.body().getResponse().getWallet_balance());
                }
            }

            @Override
            public void onFailure(Call<ResponseArrayMarketerProfileOverview> call, Throwable t) {
                Toast.makeText(profile.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationMenu);

        bottomNavigationView.setSelectedItemId(R.id.menuProfile);

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
                        startActivity(new Intent(getApplicationContext(),
                                MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.menuProfile:
                        return true;
                }
                return false;
            }
        });
    }
}
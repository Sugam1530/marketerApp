package com.example.marketer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import Adapter.TransactionAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class activity_transaction_history extends AppCompatActivity {

    TextView btnBack;
    ApiInterface apiInterface;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_history);

        apiInterface = RetrofitInstance.getRetrofit().create(ApiInterface.class);
        recyclerView = findViewById(R.id.recyclerView);
        btnBack = findViewById(R.id.btnBack);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(activity_transaction_history.this);
        String userId = preferences.getString("userId", "");
        apiInterface.getAllTransaction(Integer.parseInt(userId), "farmer").enqueue(new Callback<ResponseArrayAllTransactionOverview>() {
            @Override
            public void onResponse(Call<ResponseArrayAllTransactionOverview> call, Response<ResponseArrayAllTransactionOverview> response) {
                if (response.body() != null){
                    List<AllTransactionOverview> transactionList = response.body().getResponse();
                    TransactionAdapter adapter = new TransactionAdapter(activity_transaction_history.this, transactionList);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity_transaction_history.this);
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ResponseArrayAllTransactionOverview> call, Throwable t) {

            }
        });

        btnBack.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        });
    }
}
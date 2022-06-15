package com.example.marketer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class activity_add_farmer extends AppCompatActivity {

    TextView tvName, tvUserEmail,tvUserName, tvPassword, tvConfirmPassword;
    Button btnSubmit;
    SharedPreferences sharedPreferences;
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_farmer);

        tvName = findViewById(R.id.tvName);
        tvUserEmail = findViewById(R.id.tvUserEmail);
        tvUserName = findViewById(R.id.tvUserName);
        tvPassword = findViewById(R.id.tvPassword);
        tvConfirmPassword = findViewById(R.id.tvConfirmPassword);
        btnSubmit = findViewById(R.id.btnSubmit);
        apiInterface = RetrofitInstance.getRetrofit().create(ApiInterface.class);

        btnSubmit.setOnClickListener(v -> {
            if (!tvName.getText().toString().isEmpty() &&
                    !tvUserEmail.getText().toString().isEmpty() && !tvUserName.getText().toString().isEmpty() &&
                    !tvPassword.getText().toString().isEmpty() && !tvConfirmPassword.getText().toString().isEmpty()){
                final RequestBody Name = RequestBody.create(MediaType.parse("text/plain"), tvName.getText().toString());
                final RequestBody UserEmail = RequestBody.create(MediaType.parse("text/plain"), tvUserEmail.getText().toString());
                final RequestBody UserName = RequestBody.create(MediaType.parse("text/plain"), tvUserName.getText().toString());
                final RequestBody Password = RequestBody.create(MediaType.parse("text/plain"), tvPassword.getText().toString());
                final RequestBody ConfirmPassword = RequestBody.create(MediaType.parse("text/plain"), tvConfirmPassword.getText().toString());
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(activity_add_farmer.this);
                String userId = preferences.getString("userId", "");
                final RequestBody mkt_id = RequestBody.create(MediaType.parse("text/plain"), userId);
                apiInterface.postAddFarmer(Name, UserEmail, UserName, Password, ConfirmPassword, mkt_id).enqueue(new Callback<AddFarmerOverview>() {
                    @Override
                    public void onResponse(Call<AddFarmerOverview> call, Response<AddFarmerOverview> response) {
                        if (response.body() != null && response.body().getStatus() == 1){
                            Intent intent = new Intent(getApplicationContext(), farmer_list.class);
                            startActivity(intent);
                            Toast.makeText(activity_add_farmer.this, "Farmer has successfully added", Toast.LENGTH_SHORT).show();
                        } else{
                            Toast.makeText(activity_add_farmer.this, "Please Fill Proper Details", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<AddFarmerOverview> call, Throwable t) {

                    }
                });
            }
            else{
                Toast.makeText(this, "Please Fill All The Required Field", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
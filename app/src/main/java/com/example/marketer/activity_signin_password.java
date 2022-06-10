package com.example.marketer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class activity_signin_password extends AppCompatActivity {

    Button loginbtn;
    SharedPreferences sharedPreferences;
    EditText userNameText;
    TextInputLayout passwordText;
    ApiInterface apiInterface;

    public static final String userName = "userName";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin_password);

        loginbtn = findViewById(R.id.loggingbtn);
        sharedPreferences = getSharedPreferences(userName, Context.MODE_PRIVATE);
        userNameText = findViewById(R.id.username);
        apiInterface = RetrofitInstance.getRetrofit().create(ApiInterface.class);
        loginbtn = findViewById(R.id.loggingbtn);
        passwordText = findViewById(R.id.password);

        loginbtn.setOnClickListener(v -> {

            if (!userNameText.getText().toString().isEmpty() &&
                    !passwordText.getEditText().getText().toString().isEmpty()) {
                final RequestBody userName = RequestBody.create(MediaType.parse("text/plain"), userNameText.getText().toString());
                final RequestBody password = RequestBody.create(MediaType.parse("text/plain"), passwordText.getEditText().getText().toString());
                apiInterface.postMarketerLogin(userName, password).enqueue(new Callback<ResponseArrayMarketerLoginOverview>() {
                    @Override
                    public void onResponse(Call<ResponseArrayMarketerLoginOverview> call, Response<ResponseArrayMarketerLoginOverview> response) {
                        if (response.body() != null && response.body().getStatus() == 1){
                            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity_signin_password.this);
                            SharedPreferences.Editor editor = sharedPreferences.edit();

                            editor.putBoolean("userLoggedInFlag", true);
                            editor.putString("userId", response.body().getResponse().getId());

                            editor.apply();
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseArrayMarketerLoginOverview> call, Throwable t) {
                        Toast.makeText(activity_signin_password.this, "User Name or Password is incorrect", Toast.LENGTH_SHORT).show();

                    }
                });


            } else {
                Toast.makeText(activity_signin_password.this, "Please Fill All The Required Fields", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
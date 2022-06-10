package com.example.marketer;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiInterface {

@Multipart
@POST("api/merkerter/login")
    Call<ResponseArrayMarketerLoginOverview> postMarketerLogin(@Part("username") RequestBody username, @Part("password") RequestBody password);
}

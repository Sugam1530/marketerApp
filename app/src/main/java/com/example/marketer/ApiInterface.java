package com.example.marketer;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface ApiInterface {

@GET("api/marketer/getmarkerterprofile/{num}")
    Call<ResponseArrayMarketerProfileOverview> getMarketerProfile(@Path("num") int num);

@Multipart
@POST("api/marketer/login")
    Call<ResponseArrayMarketerLoginOverview> postMarketerLogin(@Part("username") RequestBody username, @Part("password") RequestBody password);
}

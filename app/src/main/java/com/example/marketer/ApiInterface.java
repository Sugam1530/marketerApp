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

@GET("api/marketer/getsinglefarmer/{num}")
    Call<ResponseArrayFarmerOverview> getAllFarmerListbyMarketer(@Path("num") int num);

@Multipart
@POST("api/marketer/login")
    Call<ResponseArrayMarketerLoginOverview> postMarketerLogin(@Part("username") RequestBody username, @Part("password") RequestBody password);

@Multipart
@POST("api/marketer/addfarmer")
    Call<AddFarmerOverview> postAddFarmer(@Part ("name") RequestBody name, @Part("email") RequestBody email, @Part("username") RequestBody username, @Part("password") RequestBody password, @Part("cnfm_password") RequestBody cnfm_password, @Part("mkt_id") RequestBody mkt_id);
}

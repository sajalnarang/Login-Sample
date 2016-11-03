package com.example.sajalnarang.loginsample;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RetrofitInterface {
//    @GET("/login/android/")
//    Call<GsonModels.UserDetails> getUserDetails(@Query("username") String username, @Query("password") String password);

    @FormUrlEncoded
    @POST("/login/android/")
    Call<GsonModels.UserDetails> getUserDetails(@Query("username") String username, @Query("password") String password);
}

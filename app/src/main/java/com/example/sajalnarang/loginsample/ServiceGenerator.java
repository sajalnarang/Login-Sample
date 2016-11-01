package com.example.sajalnarang.loginsample;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    private static final String BASE_URL = "http://127.0.0.1/";

    private static OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();

    private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());

    public static Retrofit retrofit;

    public static <S> S createService(Class<S> serviceClass){
        retrofit = retrofitBuilder.client(clientBuilder.build()).build();
        return retrofit.create(serviceClass);
    }
}

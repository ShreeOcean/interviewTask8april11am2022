package com.ocean.myinterviewapp8thapril11am;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitApi {

    public static final String BASE_URL = "https://api.sampleapis.com";
    //public static final String API_KEY = "cd852112b111a64a51cb4cade02819d8";

    public static <S> S getInstance(Class<S> serviceClass){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
        return retrofit.create(serviceClass);
    }

}

package com.ocean.myinterviewapp8thapril11am;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiName {

    @GET("/coffee/iced")
    Call<List<CoffeeModel>> getItemDetails();
}

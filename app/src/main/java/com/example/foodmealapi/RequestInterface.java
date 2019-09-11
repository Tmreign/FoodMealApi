package com.example.foodmealapi;

//import android.telecom.Call;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RequestInterface {
    @GET("categories.php")
    Call<List<Category>> getCategoryJson();
}

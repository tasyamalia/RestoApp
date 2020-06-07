package com.tasya.restoapp.rest;

import com.tasya.restoapp.model.GetData;
import com.tasya.restoapp.model.RequestBody;
import com.tasya.restoapp.model.Users;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Service {
    @POST("user")
    Call<GetData> createReq(@Body RequestBody requestBody);
    @GET("category")
    Call<GetData> category();
    @GET("menu")
    Call<GetData> menu();
}

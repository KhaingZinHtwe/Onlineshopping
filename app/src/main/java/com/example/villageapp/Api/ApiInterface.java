package com.example.villageapp.Api;

import com.example.villageapp.TownShip;
import com.example.villageapp.Village;
import com.example.villageapp.Year;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {
    @GET("/township.php")
    Call<List<TownShip>> getTownship();

    @FormUrlEncoded//data encoded
    @POST("/village.php")
    Call<List<Village>> getVillage(@Field("tid") Integer tid);

    @FormUrlEncoded//data encoded
    @POST("/year.php")
    Call<List<Year>> getVillageDetails(@Field("vid") String vid);


}

package com.example.villageapp.Api;

public class ApiUtils {
    public static final String BASE_URL="https://regionalsurvey.000webhostapp.com/";
    public static ApiInterface getApi(){
        return ApiClient.getRetrofit(BASE_URL).create(ApiInterface.class);
    }
}

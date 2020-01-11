package com.example.villageapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.villageapp.Api.ApiInterface;
import com.example.villageapp.Api.ApiUtils;
import com.example.villageapp.adapter.VillageInfoAdapter;
import com.example.villageapp.adapter.VillageNameAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VillageDetailView extends AppCompatActivity {
    RecyclerView recyclerView;
    String vid;
    ApiInterface apiInterface;
    List<Year> villageDataList;
    VillageInfoAdapter villageInfoAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.village_data);
        Intent intent = getIntent();
        String vid=intent.getStringExtra("vid");
        final String vName=intent.getStringExtra("vName");

        //recycler view
        recyclerView=findViewById(R.id.villageView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        apiInterface= ApiUtils.getApi();
        Call<List<Year>> call=apiInterface.getVillageDetails(vid);
        call.enqueue(new Callback<List<Year>>() {
            @Override
            public void onResponse(Call<List<Year>> call, Response<List<Year>> response) {
                if (response.isSuccessful()) {
                    villageDataList = response.body();
                    if (!villageDataList.isEmpty()){
                        Log.i("Village Data",villageDataList.get(0).getArea());

                        villageInfoAdapter = new VillageInfoAdapter(getApplicationContext(), villageDataList,vName);
                        recyclerView.setAdapter(villageInfoAdapter);
                    }

                }
            }

            @Override
            public void onFailure(Call<List<Year>> call, Throwable t) {

            }
        });
    }

}

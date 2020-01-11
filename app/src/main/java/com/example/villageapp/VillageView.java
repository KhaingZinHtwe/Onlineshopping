package com.example.villageapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.villageapp.Api.ApiInterface;
import com.example.villageapp.Api.ApiUtils;
import com.example.villageapp.adapter.VillageNameAdapter;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class VillageView extends AppCompatActivity {
    RecyclerView recyclerView;
    ApiInterface apiInterface;
    List<Village> villageList;
    Context context;
    VillageNameAdapter villageNameAdapter;
    TextView villageName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.village_list);
        Intent intent=getIntent();
        Integer tid= Integer.valueOf(intent.getStringExtra("id"));
        Log.i("Village  View",tid+"");

       recyclerView= findViewById(R.id.villageViewRecycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
       recyclerView.setLayoutManager(linearLayoutManager);

        //village api
        apiInterface= ApiUtils.getApi();
        Call<List<Village>> call=apiInterface.getVillage(tid);
        call.enqueue(new Callback<List<Village>>() {
            @Override
            public void onResponse(Call<List<Village>> call, Response<List<Village>> response) {
                if (response.isSuccessful()) {
                    villageList = response.body();
                    if (!villageList.isEmpty()){
                        Log.i("Village List",villageList.get(0).getVname());

                        villageNameAdapter = new VillageNameAdapter(getApplicationContext(), villageList);
                        recyclerView.setAdapter(villageNameAdapter);
                    }

                }
            }

            @Override
            public void onFailure(Call<List<Village>> call, Throwable t) {

            }

        });



        //villageName=findViewById(R.id.village_name);

    }
}

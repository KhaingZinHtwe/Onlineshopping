package com.example.villageapp;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.villageapp.Api.ApiInterface;
import com.example.villageapp.Api.ApiUtils;
import com.example.villageapp.adapter.CityInfoAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    TextView textName;
    FragmentCommunication communication;
    String name;
    Context context;
    RecyclerView mRecyclerView;
    CityInfoAdapter cityInfoAdapter;
    ApiInterface apiInterface;
    TextView txtcity;
    List<TownShip> townInfoList;
    public HomeFragment() {
        // Required empty public constructor

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.content_main,container,false);
        mRecyclerView= (RecyclerView) view.findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        apiInterface=ApiUtils.getApi();
        Call<List<TownShip>> call=apiInterface.getTownship();
        call.enqueue(new Callback<List<TownShip>>() {
            @Override
            public void onResponse(Call<List<TownShip>> call, Response<List<TownShip>> response) {
                if (response.isSuccessful()) {
                    //Log.i("Town list@@",response.body().toString());
                    townInfoList=response.body();
                    cityInfoAdapter=new CityInfoAdapter(getContext(),townInfoList);
                    mRecyclerView.setAdapter(cityInfoAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<TownShip>> call, Throwable t) {

            }
        });

        return view;
    }
}

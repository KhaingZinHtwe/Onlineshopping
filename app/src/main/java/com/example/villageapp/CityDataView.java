package com.example.villageapp;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.villageapp.Api.ApiInterface;
import com.example.villageapp.Api.ApiUtils;
import com.example.villageapp.adapter.VillageNameAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CityDataView extends AppCompatActivity {

    Button villageData;
    ImageView imageView;
    TextView tName;
    TextView tDesc;

    ApiInterface apiInterface;
    Context context;
    String tid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.review_item);
        final Intent intent=getIntent();

//        recyclerView= findViewById(R.id.recyclerView);
//        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        imageView=findViewById(R.id.img);
        tName=findViewById(R.id.txt_townName);
        tDesc=findViewById(R.id.txt_view);

        tid=intent.getStringExtra("id");
        String name=intent.getStringExtra("name");
        String img_url=intent.getStringExtra("img");
        String description=intent.getStringExtra("desc");
        Log.i("City Data View",tid);
        tName.setText(name);
        tDesc.setText(description);

        Glide.with(this).load(ApiUtils.BASE_URL+img_url).into(imageView);

        villageData=findViewById(R.id.button);
        villageData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent1=new Intent(CityDataView.this,VillageView.class);
               intent1.putExtra("id",tid);
                CityDataView.this.startActivity(intent1);

            }
        });
    }
}

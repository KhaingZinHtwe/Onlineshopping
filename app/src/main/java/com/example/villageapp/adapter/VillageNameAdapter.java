package com.example.villageapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.villageapp.Api.ApiInterface;
import com.example.villageapp.R;
import com.example.villageapp.Village;
import com.example.villageapp.VillageDetailView;
import com.example.villageapp.Year;

import java.util.List;

import retrofit2.Callback;

public class VillageNameAdapter extends RecyclerView.Adapter<VillageNameAdapter.VillageInfoViewHolder>{
    Context context;
    List<Year> villageInfoList;
    List<Village> villageList;

    public VillageNameAdapter(Context context,List<Village> vList){
        this.villageList=vList;
        this.context=context;
    }


    @NonNull
    @Override
    public VillageInfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.village_view,parent,false);
        VillageInfoViewHolder holder = new VillageInfoViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull VillageInfoViewHolder holder, int position) {
        final Village current=villageList.get(position);
        holder.villageName.setText(current.getVname());
        holder.villageCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!villageList.isEmpty()) {
                    Log.i("Village Name", villageList.get(0).getVname());

                }
                Intent intent = new Intent(context,VillageDetailView.class);
                intent.putExtra("vid", current.getVid()).putExtra("vName",current.getVname());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return villageList.size();
    }


    public class VillageInfoViewHolder extends RecyclerView.ViewHolder {
        TextView villageName;
        CardView villageCard;
        public VillageInfoViewHolder(View view) {
            super(view);
            villageName=view.findViewById(R.id.village_name);
            villageCard=view.findViewById(R.id.village_Card);

        }
    }
}

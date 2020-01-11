package com.example.villageapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.villageapp.R;
import com.example.villageapp.Village;
import com.example.villageapp.VillageDetailView;
import com.example.villageapp.VillageView;
import com.example.villageapp.Year;

import java.util.List;

public class VillageInfoAdapter extends RecyclerView.Adapter<VillageInfoAdapter.VillageInfoViewHolder> {
    List<Year> villageInfoList;
    Context mContext;
    String name;
//    VillageInfoAdapter villageInfoAdapter;


    public VillageInfoAdapter(Context mContext,List<Year> villageInfoList,String name){
        this.villageInfoList=villageInfoList;
        this.mContext=mContext;
        this.name=name;
    }

    @NonNull
    @Override
    public VillageInfoAdapter.VillageInfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(mContext).inflate(R.layout.activity_village_data_view,parent,false);
        VillageInfoViewHolder holder= new VillageInfoViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final VillageInfoAdapter.VillageInfoViewHolder holder, int position) {
        final Year current=villageInfoList.get(position);
        final String home=current.getNoOfHome();
        final String area=current.getArea();
        final String pop=current.getTotalPopulation();
        final String male=current.getMale();
        final String female=current.getFemale();
        final String year=current.getYear();
        holder.txtName.setText("Village Name:"+name);
        holder.txtArea.setText("Village Area:"+area);
        holder.txtHome.setText("Number of Home:"+home);
        holder.txtPop.setText("Population:"+pop);
        holder.txtMale.setText("Male:"+male);
        holder.txtFemale.setText("Female:"+female);
        holder.txtYear.setText("Year:"+year);

    }

    @Override
    public int getItemCount() {
        return villageInfoList.size();
    }

    public class VillageInfoViewHolder extends RecyclerView.ViewHolder {
        CardView villageNameCard;
        TextView txtName,txtHome,txtArea,txtPop,txtMale,txtFemale,txtYear;
        public VillageInfoViewHolder(@NonNull View itemView) {
            super(itemView);
            villageNameCard=itemView.findViewById(R.id.villageCard);
            txtName=itemView.findViewById(R.id.txt_name);
            txtHome=itemView.findViewById(R.id.txt_home);
            txtArea=itemView.findViewById(R.id.txt_area);
            txtPop=itemView.findViewById(R.id.txt_population);
            txtMale=itemView.findViewById(R.id.txt_male);
            txtFemale=itemView.findViewById(R.id.txt_female);
            txtYear=itemView.findViewById(R.id.txt_year);

        }
    }
}

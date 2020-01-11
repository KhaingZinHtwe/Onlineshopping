package com.example.villageapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.villageapp.CityDataView;
import com.example.villageapp.FragmentCommunication;
import com.example.villageapp.R;
import com.example.villageapp.TownShip;

import java.util.List;
public class CityInfoAdapter extends RecyclerView.Adapter<CityInfoAdapter.CityInfoViewHolder> {
    Context mContext;
    List<TownShip> cityInfoList;
    FragmentCommunication mCommunication;

    public CityInfoAdapter(Context context, List<TownShip> mCityInfo) {
        cityInfoList=mCityInfo;
        this.mContext=context;
    }

    @Nullable
    @Override
    public CityInfoViewHolder onCreateViewHolder(@Nullable ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(mContext).inflate(R.layout.fragment_home,parent,false);
        CityInfoViewHolder holder= new CityInfoViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(@Nullable final CityInfoViewHolder holder,int position) {
        final TownShip current=cityInfoList.get(position);
        holder.cityName.setText(current.getTname());
        holder.city.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(mContext,CityDataView.class);
                intent.putExtra("id",current.getTid());
                intent.putExtra("name",current.getTname());
                intent.putExtra("img",current.getImageUrl());
                intent.putExtra("desc",current.getDescription());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return cityInfoList.size();
    }

    public class CityInfoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView cityName;
        CardView city;
        public CityInfoViewHolder(@Nullable View view) {
            super(view);
            cityName=view.findViewById(R.id.city_name);
            city=view.findViewById(R.id.cityCard);
        }

        @Override
        public void onClick(View view) {
            mCommunication.respond(getAdapterPosition());
        }
    }
}


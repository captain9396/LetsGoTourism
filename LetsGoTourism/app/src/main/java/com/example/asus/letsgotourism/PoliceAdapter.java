package com.example.asus.letsgotourism;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class PoliceAdapter extends RecyclerView.Adapter<PoliceAdapter.ViewHolder>{


    private List<PoliceItem> policeItemList;
    private Context context;


    public PoliceAdapter(List<PoliceItem> policeItems, Context context){
        this.policeItemList = policeItems;
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.police_list_item,parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        PoliceItem policeItem = policeItemList.get(position);
        holder.divistionTextView.setText(policeItem.getName());
        holder.districtTextView.setText(policeItem.getRegion() + ", "+  policeItem.getDivision());
        holder.thanaTextView.setText("");
        holder.phoneTextView.setText(policeItem.getPhoneNumber());
    }

    @Override
    public int getItemCount() {
        return policeItemList.size();
    }





    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView divistionTextView;
        public TextView districtTextView;
        public TextView thanaTextView;
        public TextView phoneTextView;


        public ViewHolder(View itemView) {
            super(itemView);
            divistionTextView = (TextView) itemView.findViewById(R.id.division_text);
            districtTextView = (TextView) itemView.findViewById(R.id.district_text);
            thanaTextView = (TextView) itemView.findViewById(R.id.thana_text);
            phoneTextView= (TextView) itemView.findViewById(R.id.phone_text);
        }
    }


}



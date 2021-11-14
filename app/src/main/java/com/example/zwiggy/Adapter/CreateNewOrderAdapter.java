package com.example.zwiggy.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zwiggy.Data.MenuItem;
import com.example.zwiggy.Data.Restaurant;
import com.example.zwiggy.Data.UserDetail;
import com.example.zwiggy.R;
import com.example.zwiggy.UI.CreateNewOrder;
import com.example.zwiggy.UI.CustomerMenuRActivity;

import java.util.ArrayList;

public class CreateNewOrderAdapter extends RecyclerView.Adapter<CreateNewOrderAdapter.CreateNewOrderAdapterViewHolder> {

    ArrayList<String> mNewOrders;
    Context mContext;

    public CreateNewOrderAdapter(Context context, ArrayList<String> orders){
        mContext = context;
        mNewOrders = orders;
    }
    @NonNull
    @Override
    public CreateNewOrderAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.activity_create_new_order_list_items, parent, false);
        CreateNewOrderAdapterViewHolder viewHolder = new CreateNewOrderAdapterViewHolder(contactView);
        return viewHolder;
    }



    @Override
    public void onBindViewHolder(@NonNull CreateNewOrderAdapterViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return mNewOrders.size();
    }

    public class CreateNewOrderAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView newOrder;

        public CreateNewOrderAdapterViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            newOrder = itemView.findViewById(R.id.rvCreateNewOrder);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
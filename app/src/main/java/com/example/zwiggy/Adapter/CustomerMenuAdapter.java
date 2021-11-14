package com.example.zwiggy.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zwiggy.R;

import java.util.ArrayList;

public class CustomerMenuAdapter extends RecyclerView.Adapter<CustomerMenuAdapter.CustomerMenuAdapterViewHolder> {

    ArrayList<String> mCustomerMenu;
    Context mContext;

    public CustomerMenuAdapter(Context context, ArrayList<String> customerMenu){
        mContext = context;
        mCustomerMenu = customerMenu;
    }
    @NonNull
    @Override
    public CustomerMenuAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.activity_customer_menu_list_item, parent, false);
        CustomerMenuAdapterViewHolder viewHolder = new CustomerMenuAdapterViewHolder(contactView);
        return viewHolder;
    }



    @Override
    public void onBindViewHolder(@NonNull CustomerMenuAdapterViewHolder holder, int position) {
        String restaurant_menu_list =mCustomerMenu.get(position);
        TextView textView = holder.customerMenuItem;
        textView.setText(restaurant_menu_list);
    }

    @Override
    public int getItemCount() {
        return mCustomerMenu.size();
    }

    public class CustomerMenuAdapterViewHolder extends RecyclerView.ViewHolder  {
        public TextView customerMenuItem;

        public CustomerMenuAdapterViewHolder(View itemView) {
            super(itemView);
            customerMenuItem = (TextView) itemView.findViewById(R.id.customerMenuItem);
        }
    }
}
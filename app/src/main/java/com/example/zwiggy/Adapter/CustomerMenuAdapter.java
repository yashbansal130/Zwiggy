package com.example.zwiggy.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zwiggy.Data.MenuItem;
import com.example.zwiggy.R;

import java.util.ArrayList;

public class CustomerMenuAdapter extends RecyclerView.Adapter<CustomerMenuAdapter.CustomerMenuAdapterViewHolder> {

    ArrayList<MenuItem> mCustomerMenu;
    Context mContext;

    public CustomerMenuAdapter(Context context, ArrayList<com.example.zwiggy.Data.MenuItem> customerMenu){
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
        MenuItem restaurant_menu_list =mCustomerMenu.get(position);
        restaurant_menu_list.setQuantity(0);
        holder.customerMenuName.setText(restaurant_menu_list.getName());
        holder.customerMenuPrice.setText(restaurant_menu_list.getPrice());
        holder.customerMenuQuantity.setText(restaurant_menu_list.getQuantity());
        holder.customerMenuDisc.setText(restaurant_menu_list.getDisc());

        holder.plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                restaurant_menu_list.setQuantity(restaurant_menu_list.getQuantity()+1);
                holder.customerMenuQuantity.setText(restaurant_menu_list.getQuantity());
            }
        });
        holder.minus.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(restaurant_menu_list.getQuantity()>0){
                    restaurant_menu_list.setQuantity(restaurant_menu_list.getQuantity()-1);
                    holder.customerMenuQuantity.setText(restaurant_menu_list.getQuantity());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mCustomerMenu.size();
    }

    public class CustomerMenuAdapterViewHolder extends RecyclerView.ViewHolder  {
        public TextView customerMenuName;
        public TextView customerMenuPrice;
        public TextView customerMenuDisc;
        public TextView customerMenuQuantity;
        public Button plus;
        public Button minus;

        public CustomerMenuAdapterViewHolder(View itemView) {
            super(itemView);
            customerMenuName = itemView.findViewById(R.id.customer_menu_name);
            customerMenuDisc = itemView.findViewById(R.id.customer_menu_disc);
            customerMenuPrice = itemView.findViewById(R.id.customer_menu_price);
            minus = itemView.findViewById(R.id.minus);
            plus = itemView.findViewById(R.id.plus);
            customerMenuQuantity = itemView.findViewById(R.id.quantity);
        }
    }
}
package com.example.zwiggy.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zwiggy.Data.MenuItem;
import com.example.zwiggy.R;

import java.util.ArrayList;

public class OwnerMenuAdapter extends RecyclerView.Adapter<OwnerMenuAdapter.OwnerMenuViewHolder> {
    Context mContext;
    ArrayList<MenuItem> mMenuItems;

    public OwnerMenuAdapter(Context context, ArrayList<MenuItem> menuItems) {
        mContext = context;
        mMenuItems = menuItems;
    }
    @NonNull
    @Override
    public OwnerMenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View contactView = inflater.inflate(R.layout.ownermenu_list_item, parent, false);
        OwnerMenuAdapter.OwnerMenuViewHolder viewHolder = new OwnerMenuViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull OwnerMenuViewHolder holder, int position) {
         MenuItem item = mMenuItems.get(position);
         //Log.i("data", item.getDisc());
        TextView name = holder.itemName;
        name.setText(item.getName());
        holder.itemPrice.setText("Rs "+Integer.toString(item.getPrice()));
        holder.itemDics.setText(item.getDisc());
    }



    @Override
    public int getItemCount() {
      return mMenuItems.size();
    }

    public class OwnerMenuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView itemName;
        public TextView itemDics;
        public TextView itemPrice;

        public OwnerMenuViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            itemName = itemView.findViewById(R.id.owner_menu_item_name);
            itemDics=itemView.findViewById(R.id.menu_item_disc);
            itemPrice=itemView.findViewById(R.id.menu_item_price);
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(mContext,Integer.toString(getAdapterPosition()),Toast.LENGTH_SHORT).show();
        }
    }
}



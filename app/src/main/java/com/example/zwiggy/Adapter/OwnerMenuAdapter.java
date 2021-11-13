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

import com.example.zwiggy.R;

import java.util.ArrayList;

public class OwnerMenuAdapter extends RecyclerView.Adapter<OwnerMenuAdapter.OwnerMenuViewHolder> {
    Context mContext;
    ArrayList<String> mMenuItems;

    public OwnerMenuAdapter(Context context, ArrayList<String> menuItems) {
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
        Log.i("data", mMenuItems.toString());
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull OwnerMenuViewHolder holder, int position) {
        String name = mMenuItems.get(position);
        TextView textView = holder.itemName;
        textView.setText(name);
    }



    @Override
    public int getItemCount() {
      return mMenuItems.size();
    }

    public class OwnerMenuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView itemName;

        public OwnerMenuViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            itemName = itemView.findViewById(R.id.owner_menu_item_name);
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(mContext,Integer.toString(getAdapterPosition()),Toast.LENGTH_SHORT).show();
        }
    }
}



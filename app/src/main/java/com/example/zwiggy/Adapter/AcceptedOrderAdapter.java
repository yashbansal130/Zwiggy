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

public class AcceptedOrderAdapter extends RecyclerView.Adapter<AcceptedOrderAdapter.AcceptedOrdersViewHolder> {

    ArrayList<String> mAccepted;
    Context mContext;

    public AcceptedOrderAdapter(Context context, ArrayList<String> accepted){
        mContext = context;
        mAccepted = accepted;
    }
    @NonNull
    @Override
    public AcceptedOrdersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.fragment_acceptedorder_list_item, parent, false);
        AcceptedOrdersViewHolder viewHolder = new AcceptedOrdersViewHolder(contactView);
        return viewHolder;
    }



    @Override
    public void onBindViewHolder(@NonNull AcceptedOrdersViewHolder holder, int position) {
        String accepted =mAccepted.get(position);
        TextView textView = holder.acceptedOrder;
        textView.setText(accepted);
    }

    @Override
    public int getItemCount() {
        return mAccepted.size();
    }

    public class AcceptedOrdersViewHolder extends RecyclerView.ViewHolder {
        public TextView acceptedOrder;

        public AcceptedOrdersViewHolder(View itemView) {
            super(itemView);
            acceptedOrder = (TextView) itemView.findViewById(R.id.list_item_AcceptedOrders);
        }
    }
}
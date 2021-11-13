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


public class PendingOrderAdapter extends RecyclerView.Adapter<PendingOrderAdapter.PendingOrdersViewHolder> {

    ArrayList<String> mPendings;
    Context mContext;

    public PendingOrderAdapter(Context context, ArrayList<String> pendings){
        mContext = context;
        mPendings = pendings;
    }
    @NonNull
    @Override
    public PendingOrdersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.fragment_pendingorders_list_item, parent, false);
        PendingOrdersViewHolder viewHolder = new PendingOrdersViewHolder(contactView);
        return viewHolder;
    }



    @Override
    public void onBindViewHolder(@NonNull PendingOrdersViewHolder holder, int position) {
        String pending =mPendings.get(position);
        TextView textView = holder.pendingOrder;
        textView.setText(pending);

    }

    @Override
    public int getItemCount() {
        return mPendings.size();
    }

    public class PendingOrdersViewHolder extends RecyclerView.ViewHolder {
        public TextView pendingOrder;

        public PendingOrdersViewHolder(View itemView) {
            super(itemView);
            pendingOrder = (TextView) itemView.findViewById(R.id.list_item_PendingOrders);
        }
    }
}

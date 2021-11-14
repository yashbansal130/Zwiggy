package com.example.zwiggy.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zwiggy.Data.OrderHistory;
import com.example.zwiggy.Data.UserDetail;
import com.example.zwiggy.R;
import com.example.zwiggy.UI.CreateNewOrder;
import com.example.zwiggy.UI.CustomerMenuRActivity;

import java.util.ArrayList;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder> {
    ArrayList<OrderHistory> history;
    Context context;
    public HistoryAdapter(Context context, ArrayList<OrderHistory> history) {
        this.history = history;
        this.context = context;
    }
    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.history_item, parent, false);
        HistoryAdapter.HistoryViewHolder viewHolder = new HistoryAdapter.HistoryViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int position) {
        holder.historyRestaurantName.setText(history.get(position).getRestaurantName());
        holder.historyOrderId.setText(history.get(position).getOrderId());
        int status=history.get(position).getStatus();
        switch (status){
            case 1:holder.historyStatus.setText("Pending");
                    holder.historyStatus.setTextColor(Color.parseColor("#FFA500"));
                    break;
            case 2:holder.historyStatus.setText("Accepted");
                    holder.historyStatus.setTextColor(Color.parseColor("#00FF00"));
                    break;
            case 3: holder.historyStatus.setText("Rejected");
                    holder.historyStatus.setTextColor(Color.parseColor("#FF0000"));
                    break;
            default: break;
        }
        holder.historyBill.setText("Rs."+Integer.toString(history.get(position).getBill()));
    }

    @Override
    public int getItemCount() {
        return history.size();
    }

    public class HistoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView historyOrderId;
        public TextView historyRestaurantName;
        public TextView historyBill;
        public TextView historyStatus;
        public HistoryViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            historyRestaurantName = itemView.findViewById(R.id.history_restaurant_name);
            historyOrderId=itemView.findViewById(R.id.history_order_id);
            historyBill=itemView.findViewById(R.id.history_bill);
            historyStatus = itemView.findViewById(R.id.history_status);
        }

        @Override
        public void onClick(View view) {
            int pos=getAdapterPosition();
            UserDetail.setMorderId(history.get(pos).getOrderId());
            UserDetail.setIntentStatus(2);
            Intent intent = new Intent(context, CreateNewOrder.class);
            context.startActivity(intent);
        }
    }
}

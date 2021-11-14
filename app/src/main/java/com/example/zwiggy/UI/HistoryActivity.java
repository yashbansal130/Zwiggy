package com.example.zwiggy.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.zwiggy.Adapter.HistoryAdapter;
import com.example.zwiggy.Data.OrderHistory;
import com.example.zwiggy.R;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {

    RecyclerView rvHistory;
    ArrayList<OrderHistory> history;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        rvHistory = findViewById(R.id.rv_history);
        history = new ArrayList<>();
//        history.add("data");
//        history.add("bata");
        HistoryAdapter historyAdapter = new HistoryAdapter(this, history);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvHistory.setLayoutManager(layoutManager);
        rvHistory.setAdapter(historyAdapter);
    }
}
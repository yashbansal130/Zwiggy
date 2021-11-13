package com.example.zwiggy.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.zwiggy.Adapter.CustomerAdapter;
import com.example.zwiggy.Adapter.PendingOrderAdapter;
import com.example.zwiggy.R;

import java.util.ArrayList;

public class CustomerActivity extends AppCompatActivity {

    ArrayList<String> restaurants;
    RecyclerView rvRestaurants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);

        restaurants = new ArrayList<String>();
        restaurants.add("Amar Punjabi");
        restaurants.add("roma.in");
        restaurants.add("satkar");

        rvRestaurants = findViewById(R.id.rvCustomer);
        CustomerAdapter adapter = new CustomerAdapter(this, restaurants);
        rvRestaurants.setAdapter(adapter);
        rvRestaurants.setLayoutManager(new LinearLayoutManager(this));
    }
}
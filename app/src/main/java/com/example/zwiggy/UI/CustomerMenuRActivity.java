package com.example.zwiggy.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.zwiggy.Adapter.CustomerMenuAdapter;
import com.example.zwiggy.R;

import java.util.ArrayList;

public class CustomerMenuRActivity extends AppCompatActivity {


    ArrayList<String> ownerMenu;
    RecyclerView rvOwnerMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_menu_ractivity);

        ownerMenu = new ArrayList<String>();
        ownerMenu.add("Dish1");
        ownerMenu.add("Dish2");
        ownerMenu.add("Dish3");

        rvOwnerMenu = findViewById(R.id.rvCustomerMenu);
        CustomerMenuAdapter adapter = new CustomerMenuAdapter(this, ownerMenu);
        rvOwnerMenu.setAdapter(adapter);
        rvOwnerMenu.setLayoutManager(new LinearLayoutManager(this));

    }
}
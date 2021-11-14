package com.example.zwiggy.UI;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.location.LocationRequest;
import android.os.Bundle;
import android.os.Looper;
import android.provider.Settings;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zwiggy.Adapter.CustomerAdapter;
import com.example.zwiggy.Adapter.CustomerMenuAdapter;
import com.example.zwiggy.R;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;

class CustomerMenuActivity extends AppCompatActivity {

    ArrayList<String> ownerMenu;
    RecyclerView rvOwnerMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_menu);

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
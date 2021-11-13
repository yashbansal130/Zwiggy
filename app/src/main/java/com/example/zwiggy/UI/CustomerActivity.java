package com.example.zwiggy.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.zwiggy.R;

import java.util.ArrayList;

public class CustomerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);

        final ArrayList<String> customers = new ArrayList<String>();
        customers.add("utkarsh");
        customers.add("yogesh");
        customers.add("bansal");
        customers.add("mittal");
        customers.add("vipul");
        customers.add("vikas");
        customers.add("anchu");
        customers.add("tushar");
        customers.add("satyam");
        customers.add("rudheer");
        customers.add("patil");


        // Lookup the recyclerview in activity layout
        RecyclerView rvCustomer = (RecyclerView) findViewById(R.id.rvCustomer);


        // Create adapter passing in the sample user data
        CustomerAdapter adapter = new CustomerAdapter(customers,this);
        // Attach the adapter to the recyclerview to populate items
        rvCustomer.setAdapter(adapter);
        // Set layout manager to position the items
        rvCustomer.setLayoutManager(new LinearLayoutManager(this));
        // That's all!

    }

    @Override
    public void onBackPressed() {
        Log.i("hello", "ho");
        System.exit(1);
        finish();
        super.onBackPressed();
    }



}
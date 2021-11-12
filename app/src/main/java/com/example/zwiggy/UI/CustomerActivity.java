package com.example.zwiggy.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.zwiggy.R;

public class CustomerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);
    }

    @Override
    public void onBackPressed() {
        Log.i("hello", "ho");
        System.exit(1);
        finish();
        super.onBackPressed();
    }
}
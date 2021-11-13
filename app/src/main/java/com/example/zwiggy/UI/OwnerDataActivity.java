package com.example.zwiggy.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.zwiggy.R;

public class OwnerDataActivity extends AppCompatActivity {

    EditText editRestaurantName;
    EditText editLocation;
    EditText editMinAmtPerOrder;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_data);

        editRestaurantName = findViewById(R.id.ownerRestaurantName);
        editLocation = findViewById(R.id.ownerRestaurantLocation);
        editMinAmtPerOrder = findViewById(R.id.ownerMinAmountPerOrder);
        button = findViewById(R.id.ownerDone);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OwnerDataActivity.this, OwnerActivity.class);
                startActivity(intent);
            }
        });
    }
}
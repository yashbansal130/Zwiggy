package com.example.zwiggy.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zwiggy.Data.UserDetail;
import com.example.zwiggy.R;

import java.util.concurrent.atomic.AtomicReference;

import io.realm.Realm;
import io.realm.mongodb.App;
import io.realm.mongodb.AppConfiguration;
import io.realm.mongodb.Credentials;
import io.realm.mongodb.User;

public class MainActivity extends AppCompatActivity {

    Button mainCustomer;
    Button mainOwner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainCustomer= findViewById(R.id.mainCustomer);
        mainOwner = findViewById(R.id.mainOwner);
        mainOwner.setOnClickListener(mainOwnerClick);
        mainCustomer.setOnClickListener(mainCustomerClick);
    }
    View.OnClickListener mainOwnerClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            UserDetail.setType(1);
            getToLogin();

        }
    };

    View.OnClickListener mainCustomerClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            UserDetail.setType(0);
            getToLogin();
        }
    };

    private void getToLogin(){
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
    }

}
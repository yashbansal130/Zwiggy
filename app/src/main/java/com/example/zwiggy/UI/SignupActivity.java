package com.example.zwiggy.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.zwiggy.R;

public class SignupActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
//        app.getEmailPassword().confirmUserAsync(email, password, it -> {
//            if (it.isSuccess()) {
//                Log.i("EXAMPLE", "Successfully registered user.");
//            } else {
//                Log.e("EXAMPLE", "Failed to register user: " + it.getError().getErrorMessage());
//            }
//        });
    }
}
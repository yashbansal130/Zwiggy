package com.example.zwiggy.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.zwiggy.R;

public class SignupActivity extends AppCompatActivity {
    EditText editSignUpName;
    EditText editSignUpEmail;
    EditText editSignUpPassword;
    Button signUpButton;
    TextView signUpToLogin;



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


        editSignUpName = findViewById(R.id.inputSignUpName);
        editSignUpEmail = findViewById(R.id.inputSignUpEmail);
        editSignUpPassword = findViewById(R.id.inputSignUpPassword);
        signUpButton = findViewById(R.id.signUpButton);
        signUpToLogin = findViewById(R.id.signUpToLogin);

//        signUpToLogin.setOnClickListener(signUpToLoginClick);
//        signUpButton.setOnClickListener(signUpButtonClick);

    }
}
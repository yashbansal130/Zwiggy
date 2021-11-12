package com.example.zwiggy.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zwiggy.R;

import io.realm.mongodb.App;
import io.realm.mongodb.AppConfiguration;

public class SignupActivity extends AppCompatActivity {
    EditText editSignUpName;
    EditText editSignUpEmail;
    EditText editSignUpPassword;
    Button signUpButton;
    TextView signUpToLogin;
    App app;
    String appID = "hackit-qyzey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        editSignUpName = findViewById(R.id.inputSignUpName);
        editSignUpEmail = findViewById(R.id.inputSignUpEmail);
        editSignUpPassword = findViewById(R.id.inputSignUpPassword);
        signUpButton = findViewById(R.id.signUpButton);
        signUpToLogin = findViewById(R.id.signUpToLogin);

       signUpToLogin.setOnClickListener(signUpToLoginClick);
       signUpButton.setOnClickListener(signUpButtonClick);

        app = new App(new AppConfiguration.Builder(appID)
                .build());

    }
    View.OnClickListener signUpButtonClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String email=editSignUpEmail.getText().toString();
            String password=editSignUpPassword.getText().toString();
            Log.i("hello", email+password);
            if(email!=null && password!=null && editSignUpName.getText().toString()!=null) {
                Log.i("hello", email+password);
                app.getEmailPassword().registerUserAsync(email, password, it -> {
                    if (it.isSuccess()) {
                        Log.i("EXAMPLE", "Successfully registered user.");
                        finish();
                    } else {
                        Log.e("EXAMPLE", "Failed to register user: " + it.getError().getErrorMessage());
                        Toast.makeText(SignupActivity.this, "SignUp Failed, Please Try Again", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }
    };
    View.OnClickListener signUpToLoginClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            finish();
        }
    };
}
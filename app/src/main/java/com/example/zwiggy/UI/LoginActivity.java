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

import io.realm.Realm;
import io.realm.mongodb.App;
import io.realm.mongodb.AppConfiguration;
import io.realm.mongodb.Credentials;

public class LoginActivity extends AppCompatActivity {

    EditText editLoginEmail;
    EditText editLoginPassword;
    Button loginButton;
    TextView loginSignup;
    App app;
    String appID = "hackit-qyzey";
    String email = "test@gmail.com";
    String password = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Realm.init(this);

        editLoginEmail = findViewById(R.id.inputLoginEmail);
        editLoginPassword = findViewById(R.id.inputLoginPassword);
        loginButton = findViewById(R.id.loginButton);
        loginSignup = findViewById(R.id.loginSignup);

        loginSignup.setOnClickListener(LoginSignupClick);
        loginButton.setOnClickListener(LoginButtonClick);

        app = new App(new AppConfiguration.Builder(appID)
                .build());
//
    }
    View.OnClickListener LoginSignupClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
            startActivity(intent);

        }
    };

    View.OnClickListener LoginButtonClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Credentials emailPasswordCredentials = Credentials.emailPassword(email, password);
            app.loginAsync(emailPasswordCredentials, it -> {
                if (it.isSuccess()) {
                    Log.i("EXAMPLE", "Successfully registered user.");
                    Toast.makeText(LoginActivity.this,"Login Successful", Toast.LENGTH_SHORT).show();
                    if(UserDetail.getType()==0){
                        Intent intent = new Intent(LoginActivity.this, CustomerActivity.class);
                        startActivity(intent);
                    }else{
                        Intent intent = new Intent(LoginActivity.this, OwnerActivity.class);
                        startActivity(intent);
                    }
                } else {
                    Log.e("EXAMPLE", "Failed to register user: " + it.getError().getErrorMessage());
                    Toast.makeText(LoginActivity.this,"Login Failed, Try Again", Toast.LENGTH_SHORT).show();
                }
            });
        }
    };
}
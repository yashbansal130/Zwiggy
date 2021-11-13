package com.example.zwiggy.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zwiggy.Data.UserDetail;
import com.example.zwiggy.Data.addUser;
import com.example.zwiggy.R;

import io.realm.mongodb.App;
import io.realm.mongodb.AppConfiguration;
import io.realm.mongodb.Credentials;

public class SignupActivity extends AppCompatActivity {
    EditText editSignUpName;
    EditText editSignUpEmail;
    EditText editSignUpPassword;
    Button signUpButton;
    TextView signUpToLogin;
    App app;
    String appID = "hackit-qyzey";
    String name, email, password;
    ProgressBar progressBar;

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
       progressBar = findViewById(R.id.progressSignup);
       progressBar.setVisibility(View.GONE);

        app = new App(new AppConfiguration.Builder(appID)
                .build());

    }
    View.OnClickListener signUpButtonClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            email=editSignUpEmail.getText().toString();
           password=editSignUpPassword.getText().toString();
            name=editSignUpName.getText().toString();
            if(email!=null && password!=null && name!=null) {
                progressBar.setVisibility(View.VISIBLE);
                app.getEmailPassword().registerUserAsync(email, password, it -> {
                    if (it.isSuccess()) {
                        Log.i("EXAMPLE", "Successfully registered user.");
                        loginUser();
                    } else {
                        Log.e("EXAMPLE", "Failed to register user: " + it.getError().getErrorMessage());
                        progressBar.setVisibility(View.GONE);
                    }
                });
            }
        }
    };
    View.OnClickListener signUpToLoginClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
    };

    void loginUser(){
        Credentials emailPasswordCredentials = Credentials.emailPassword(email, password);
        app.loginAsync(emailPasswordCredentials, it -> {
            if (it.isSuccess()) {
                UserDetail.setName(name);
                UserDetail.setUser(app.currentUser());
                UserDetail.setEmailId(email);
                UserDetail.setmUid(app.currentUser().getId());
                Log.i("EXAMPLE", "Successfully Logged In user.");
                addUser.setMongo();
                Toast.makeText(SignupActivity.this,"Login Successful", Toast.LENGTH_SHORT).show();
                if(UserDetail.getType()==0){
                    Intent intent = new Intent(SignupActivity.this, CustomerActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Intent intent = new Intent(SignupActivity.this, OwnerActivity.class);
                    startActivity(intent);
                    finish();
                }
            } else {
                progressBar.setVisibility(View.GONE);
                Log.e("EXAMPLE", "Failed to Login user: " + it.getError().getErrorMessage());
                Toast.makeText(SignupActivity.this,"Login Failed, Try Again", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
package com.example.zwiggy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.concurrent.atomic.AtomicReference;

import io.realm.Realm;
import io.realm.mongodb.App;
import io.realm.mongodb.AppConfiguration;
import io.realm.mongodb.Credentials;
import io.realm.mongodb.User;

public class MainActivity extends AppCompatActivity {
    String appID = "hackit-qyzey";
    String email = "test@gmail.com";
    String password = "password";
    Button loginBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Realm.init(this);
        App app = new App(new AppConfiguration.Builder(appID)
                .build());
        loginBtn=(Button)findViewById(R.id.loginButton);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Credentials emailPasswordCredentials = Credentials.emailPassword(email, password);
                app.loginAsync(emailPasswordCredentials, it -> {
                    if (it.isSuccess()) {
                        Log.i("EXAMPLE", "Successfully registered user.");

                    } else {
                        Log.e("EXAMPLE", "Failed to register user: " + it.getError().getErrorMessage());
                    }
                });
            }
        });

    }

}
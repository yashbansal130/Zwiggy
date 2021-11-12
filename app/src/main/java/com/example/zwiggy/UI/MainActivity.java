package com.example.zwiggy.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.zwiggy.R;

import java.util.concurrent.atomic.AtomicReference;

import io.realm.Realm;
import io.realm.mongodb.App;
import io.realm.mongodb.AppConfiguration;
import io.realm.mongodb.Credentials;
import io.realm.mongodb.User;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Realm.init(this);

        String appID = "hackit-qyzey"; // replace this with your App ID
        App app = new App(new AppConfiguration.Builder(appID)
                .build());
        String email = "test@gmail.com";
        String password = "password";
//        app.getEmailPassword().confirmUserAsync(email, password, it -> {
//            if (it.isSuccess()) {
//                Log.i("EXAMPLE", "Successfully registered user.");
//            } else {
//                Log.e("EXAMPLE", "Failed to register user: " + it.getError().getErrorMessage());
//            }
//        });
        Credentials emailPasswordCredentials = Credentials.emailPassword(email, password);
        app.loginAsync(emailPasswordCredentials, it -> {
            if (it.isSuccess()) {
                Log.i("EXAMPLE", "Successfully registered user.");
            } else {
                Log.e("EXAMPLE", "Failed to register user: " + it.getError().getErrorMessage());
            }
        });
    }
}
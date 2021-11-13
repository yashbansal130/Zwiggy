package com.example.zwiggy.UI;

import android.os.Bundle;

import com.example.zwiggy.databinding.ActivityOwnerBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.zwiggy.R;


public class OwnerActivity extends AppCompatActivity {

    private ActivityOwnerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityOwnerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        BottomNavigationView navView = findViewById(R.id.nav_view);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_pendingorders, R.id.navigation_ownermenu, R.id.navigation_acceptedorders)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_owner2);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }

}
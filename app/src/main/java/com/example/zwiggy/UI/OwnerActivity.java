package com.example.zwiggy.UI;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.zwiggy.databinding.ActivityOwnerBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.zwiggy.R;

import io.realm.mongodb.App;
import io.realm.mongodb.AppConfiguration;


public class OwnerActivity extends AppCompatActivity {

    private ActivityOwnerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityOwnerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        configureToolbar();


        BottomNavigationView navView = findViewById(R.id.nav_view);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_pendingorders, R.id.navigation_ownermenu, R.id.navigation_acceptedorders)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_owner2);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }

    private void configureToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setTitle("Zwiggy");
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menulist, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.logout){
            String appID = "hackit-qyzey";
            App app = new App(new AppConfiguration.Builder(appID).build());
            app.currentUser().logOut();
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
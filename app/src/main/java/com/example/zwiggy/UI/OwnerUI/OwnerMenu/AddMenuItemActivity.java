package com.example.zwiggy.UI.OwnerUI.OwnerMenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.zwiggy.R;

public class AddMenuItemActivity extends AppCompatActivity {

    EditText editMenuItemName;
    EditText editMenuItemPrice;
    EditText editMenuItemDiscription;
    Button proceedFromMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_menu_item);

        editMenuItemName = findViewById(R.id.menuItemName);
        editMenuItemPrice = findViewById(R.id.menuItemPrice);
        editMenuItemDiscription = findViewById(R.id.menuItemDiscription);

        proceedFromMenu = findViewById(R.id.menuDone);

    }
}
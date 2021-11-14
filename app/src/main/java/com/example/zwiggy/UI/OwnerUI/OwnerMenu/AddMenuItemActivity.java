package com.example.zwiggy.UI.OwnerUI.OwnerMenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.zwiggy.Data.UserDetail;
import com.example.zwiggy.R;
import com.example.zwiggy.UI.OwnerActivity;
import com.example.zwiggy.UI.OwnerDataActivity;

import org.bson.Document;

import io.realm.mongodb.App;
import io.realm.mongodb.AppConfiguration;
import io.realm.mongodb.User;
import io.realm.mongodb.mongo.MongoClient;
import io.realm.mongodb.mongo.MongoCollection;
import io.realm.mongodb.mongo.MongoDatabase;

public class AddMenuItemActivity extends AppCompatActivity {

    EditText editMenuItemName;
    EditText editMenuItemPrice;
    EditText editMenuItemDiscription;
    Button proceedFromMenu;
    String itemName,itemDesc;
    int itemPrice=0;
    App app;
    User user;
    String appID = "hackit-qyzey",OwnerID;
    String LOG_TAG = AddMenuItemActivity.class.getSimpleName();
    MongoClient mongoClient;
    MongoDatabase mongoDatabase;
    MongoCollection<Document> mongoCollectionOwner,mongoCollectionitem;
    Document res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_menu_item);

        editMenuItemName = findViewById(R.id.menuItemName);
        editMenuItemPrice = findViewById(R.id.menuItemPrice);
        editMenuItemDiscription = findViewById(R.id.menuItemDiscription);

        app = new App(new AppConfiguration.Builder(appID).build());
        user= UserDetail.getUser();
        mongoClient = user.getMongoClient("mongodb-atlas");
        mongoDatabase = mongoClient.getDatabase("zwiggy");
        mongoCollectionOwner = mongoDatabase.getCollection("owner");
        mongoCollectionitem = mongoDatabase.getCollection("items");


        proceedFromMenu = findViewById(R.id.menuDone);
        proceedFromMenu.setOnClickListener(proceedFromMenuClick);

    }
    View.OnClickListener proceedFromMenuClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            itemName= editMenuItemName.getText().toString();
            itemDesc= editMenuItemDiscription.getText().toString();
            itemPrice=Integer.parseInt(editMenuItemPrice.getText().toString());
            Document itemDoc=new Document("OwnerId", UserDetail.getuserOwnerid()).append("Name", itemName)
                    .append("Desc", itemDesc).append("Price", itemPrice);
            mongoCollectionitem.insertOne(itemDoc).getAsync(result -> {
                if (result.isSuccess()) {
                    Log.v(LOG_TAG, "item Insertion is successful");
                    Toast.makeText(getApplicationContext(), "Item Successfully Inserted", Toast.LENGTH_SHORT).show();

                }
                else {
                    Toast.makeText(getApplicationContext(), "Item Failed to Insert", Toast.LENGTH_SHORT).show();
                    Log.v(LOG_TAG, "Insertion was not successful" + result.getError().toString());
                }
            });
            Document queryFilter = new Document().append("OwnerId", UserDetail.getuserOwnerid());
            Document updateDocument = new Document("$addToSet", new Document("Menu", itemDoc));
            mongoCollectionOwner.updateOne(queryFilter,updateDocument).getAsync(result->
            {
                if(result.isSuccess())
                {
                    Toast.makeText(getApplicationContext(), "Item Successfully Inserted", Toast.LENGTH_SHORT).show();
                    Log.v(LOG_TAG,"ITEM ADDED IN MENU OF OWNER");
                    finish();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Item Fialed to Insert", Toast.LENGTH_SHORT).show();
                    Log.v(LOG_TAG,"FAILED TO UPDATE MENU OF OWNER: ",result.getError());
                }
            });
        }
    };
}
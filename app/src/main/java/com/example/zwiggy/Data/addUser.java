package com.example.zwiggy.Data;

import android.content.Intent;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.zwiggy.UI.CustomerActivity;
import com.example.zwiggy.UI.SignupActivity;

import org.bson.Document;

import java.lang.reflect.Array;
import java.util.ArrayList;

import io.realm.mongodb.App;
import io.realm.mongodb.AppConfiguration;
import io.realm.mongodb.User;
import io.realm.mongodb.mongo.MongoClient;
import io.realm.mongodb.mongo.MongoCollection;
import io.realm.mongodb.mongo.MongoDatabase;

public class addUser {
    MongoClient mongoClient;
    MongoDatabase mongoDatabase;
    MongoCollection<Document> mongoCollection,mongoCollectioncus;
    String useridvalue;
    String appID = "hackit-qyzey";
    User user;
    App app;
    String LOG_TAG="ADD USER DETAIL";
   public void setMongo(){

        user=UserDetail.getUser();
        app= new App(new AppConfiguration.Builder(appID).build());
        mongoClient = user.getMongoClient("mongodb-atlas");
        mongoDatabase = mongoClient.getDatabase("zwiggy");
        mongoCollection = mongoDatabase.getCollection("users");
        mongoCollection.insertOne(new Document("userId", UserDetail.getUid()).append("Name",UserDetail.getName())
                .append("email",UserDetail.getEmailId())
                .append("type", UserDetail.getType())).getAsync(result -> {
            if (result.isSuccess()) {
                useridvalue= result.get().getInsertedId().asObjectId().getValue().toString();
                addCustomer();
                UserDetail.setuserOwnerid(useridvalue);
                Log.v(LOG_TAG, "Insertion is successful");
                Log.v(LOG_TAG, "userOwner id set after signup-login  "+ useridvalue);

            } else {
                Log.v(LOG_TAG, "Insertion was not successful" + result.getError().toString());
            }
        });



    }
    public void addCustomer()
    {

        ArrayList<Document> orderList=new ArrayList<Document>();
        mongoCollectioncus = mongoDatabase.getCollection("customer");
        mongoCollectioncus.insertOne(new Document("userId", UserDetail.getUid()).append("Name",UserDetail.getName())
                .append("Orders",orderList)
                .append("OwnerId",useridvalue)).getAsync(result -> {
            if (result.isSuccess()) {
                Log.v("sign up customer", "Insertion of customer is successful");

            } else {
                Log.v("sign up customer", "Insertion of customer was not successful" + result.getError().toString());
            }
        });

    }

}

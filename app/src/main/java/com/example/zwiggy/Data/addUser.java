package com.example.zwiggy.Data;

import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import org.bson.Document;

import io.realm.mongodb.App;
import io.realm.mongodb.AppConfiguration;
import io.realm.mongodb.User;
import io.realm.mongodb.mongo.MongoClient;
import io.realm.mongodb.mongo.MongoCollection;
import io.realm.mongodb.mongo.MongoDatabase;

public class addUser {

    public static void setMongo(){
        MongoClient mongoClient;
        MongoDatabase mongoDatabase;
        MongoCollection<Document> mongoCollection;
        String appID = "hackit-qyzey";
        User user;
        App app;
        String LOG_TAG="ADD USER DETAIL";
        user=UserDetail.getUser();
        app= new App(new AppConfiguration.Builder(appID).build());
        mongoClient = user.getMongoClient("mongodb-atlas");
        mongoDatabase = mongoClient.getDatabase("zwiggy");
        mongoCollection = mongoDatabase.getCollection("users");
        mongoCollection.insertOne(new Document("userId", UserDetail.getUid()).append("Name",UserDetail.getName())
                .append("email",UserDetail.getEmailId())
                .append("type", UserDetail.getType())).getAsync(result -> {
            if (result.isSuccess()) {
                Log.v(LOG_TAG, "Insertion is successful");

            } else {
                Log.v(LOG_TAG, "INsertion was not successful" + result.getError().toString());
            }
        });
    }

}

package com.example.zwiggy.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.zwiggy.Adapter.CustomerAdapter;
import com.example.zwiggy.Adapter.HistoryAdapter;
import com.example.zwiggy.Data.OrderHistory;
import com.example.zwiggy.Data.Restaurant;
import com.example.zwiggy.Data.UserDetail;
import com.example.zwiggy.R;

import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;

import io.realm.mongodb.App;
import io.realm.mongodb.AppConfiguration;
import io.realm.mongodb.RealmResultTask;
import io.realm.mongodb.User;
import io.realm.mongodb.mongo.MongoClient;
import io.realm.mongodb.mongo.MongoCollection;
import io.realm.mongodb.mongo.MongoDatabase;
import io.realm.mongodb.mongo.iterable.MongoCursor;

public class HistoryActivity extends AppCompatActivity {

    RecyclerView rvHistory;
    ArrayList<OrderHistory> history;

    App app;
    User user;
    String appID = "hackit-qyzey";
    String LOG_TAG = CreateNewOrder.class.getSimpleName();
    MongoClient mongoClient;
    MongoDatabase mongoDatabase;
    String OwnerID;
    Document res;
    ObjectId objectId;
    MongoCollection<Document> mongoCollectionUser,mongoCollectionOwner,mongoCollectionOrder;
    int state,total;
    String OrderId,Resname,Cusname,ResId,CusId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        rvHistory = findViewById(R.id.rv_history);
        history = new ArrayList<OrderHistory>();
//        history.add("data");
//        history.add("bata");
        app = new App(new AppConfiguration.Builder(appID).build());
        user= UserDetail.getUser();
        mongoClient = user.getMongoClient("mongodb-atlas");
        mongoDatabase = mongoClient.getDatabase("zwiggy");
        mongoCollectionUser = mongoDatabase.getCollection("users");
        mongoCollectionOwner = mongoDatabase.getCollection("owner");
        mongoCollectionOrder = mongoDatabase.getCollection("orders");

        Document queryFilter = new Document().append("CusId",UserDetail.getuserOwnerid());
        RealmResultTask<MongoCursor<Document>> findTask = mongoCollectionOrder.find(queryFilter).iterator();
        findTask.getAsync(task ->
        {
            if (task.isSuccess()) {
                MongoCursor<Document> result = task.get();
                while (result.hasNext()) {
                    Document curDoc = result.next();
                    try {
                        OrderId=curDoc.getObjectId("_id").toString();
                        Resname=curDoc.getString("Res");
                        Cusname=curDoc.getString("Cus");
                        ResId=curDoc.getString("ResId");
                        CusId=curDoc.getString("CusId");
                        state=curDoc.getInteger("State");
                        total=curDoc.getInteger("Total");
                        if(state>=0) {
                            history.add(new OrderHistory(OrderId, Resname, state, total));
                        }
                        Log.i(LOG_TAG,"history orders found ");


                    } catch (Exception e) {
                        Log.v(LOG_TAG, "error in finding range rest", e);
                    }
                }
                HistoryAdapter historyAdapter = new HistoryAdapter(this, history);
                LinearLayoutManager layoutManager = new LinearLayoutManager(this);
                rvHistory.setLayoutManager(layoutManager);
                rvHistory.setAdapter(historyAdapter);
                Log.v(LOG_TAG, "successfully found order in history");
            } else {
                Log.v(LOG_TAG, "order history not found" + task.getError().toString());
            }

        });

    }
}
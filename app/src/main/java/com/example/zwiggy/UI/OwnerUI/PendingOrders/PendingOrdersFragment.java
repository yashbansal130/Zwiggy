package com.example.zwiggy.UI.OwnerUI.PendingOrders;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zwiggy.Adapter.HistoryAdapter;
import com.example.zwiggy.Adapter.PendingOrderAdapter;
import com.example.zwiggy.Data.OrderHistory;
import com.example.zwiggy.Data.PendingOrder;
import com.example.zwiggy.Data.UserDetail;
import com.example.zwiggy.R;
import com.example.zwiggy.UI.CreateNewOrder;
import com.example.zwiggy.databinding.FragmentPendingordersBinding;

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

public class PendingOrdersFragment extends Fragment {

    private PendingOrdersViewModel homeViewModel;
    private FragmentPendingordersBinding binding;
    ArrayList<PendingOrder> pendingOrders;
    RecyclerView rvPendingOrders;

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


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(PendingOrdersViewModel.class);

        binding = FragmentPendingordersBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });

        pendingOrders = new ArrayList<PendingOrder>();
//        pendingOrders.add("yash bansal");
//        pendingOrders.add("Utkarsh chutiya");
//        pendingOrders.add("Mota Bhadwa");

        rvPendingOrders = root.findViewById(R.id.rvPendingOrders);


        app = new App(new AppConfiguration.Builder(appID).build());
        user= UserDetail.getUser();
        mongoClient = user.getMongoClient("mongodb-atlas");
        mongoDatabase = mongoClient.getDatabase("zwiggy");
        mongoCollectionUser = mongoDatabase.getCollection("users");
        mongoCollectionOwner = mongoDatabase.getCollection("owner");
        mongoCollectionOrder = mongoDatabase.getCollection("orders");

        Document queryFilter = new Document().append("ResId",UserDetail.getuserOwnerid());
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
                        if(state==1) {
                            pendingOrders.add(new PendingOrder(OrderId, Cusname,total));
                        }
                        Log.i(LOG_TAG,"history orders found ");


                    } catch (Exception e) {
                        Log.v(LOG_TAG, "error in finding range rest", e);
                    }
                }
                PendingOrderAdapter adapter = new PendingOrderAdapter(getContext(), pendingOrders);
                rvPendingOrders.setAdapter(adapter);
                rvPendingOrders.setLayoutManager(new LinearLayoutManager(getContext()));
                Log.v(LOG_TAG, "successfully found pending order in history");
            } else {
                Log.v(LOG_TAG, "pending order history not found" + task.getError().toString());
            }

        });


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
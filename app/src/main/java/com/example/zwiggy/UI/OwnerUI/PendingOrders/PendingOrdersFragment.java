package com.example.zwiggy.UI.OwnerUI.PendingOrders;

import android.os.Bundle;
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

import com.example.zwiggy.Adapter.ContactsAdapter;
import com.example.zwiggy.R;
import com.example.zwiggy.databinding.FragmentPendingordersBinding;

import java.util.ArrayList;

public class PendingOrdersFragment extends Fragment {

    private PendingOrdersViewModel homeViewModel;
    private FragmentPendingordersBinding binding;

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

        setContentView(R.layout.fragment_pendingorders);

        // Lookup the recyclerview in activity layout
        RecyclerView rvContacts = (RecyclerView) findViewById(R.id.list_item_PendingOrders);

        // Initialize contacts
        contacts = Contact.createContactsList(20);
        // Create adapter passing in the sample user data
        ContactsAdapter adapter = new ContactsAdapter(contacts);
        // Attach the adapter to the recyclerview to populate items
        rvContacts.setAdapter(adapter);
        // Set layout manager to position the items
        rvContacts.setLayoutManager(new LinearLayoutManager(this));
        // That's all!


        final ArrayList<String> pendings = new ArrayList<String>();
        pendings.add("paneer");
        pendings.add("maggie");
        pendings.add("chicken");
        pendings.add("dal makhani");
        pendings.add("yogi ka korma");
        pendings.add("bansal ka achaar");
        pendings.add("mittal ka halwa");


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
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
import com.example.zwiggy.Adapter.PendingOrderAdapter;
import com.example.zwiggy.R;
import com.example.zwiggy.databinding.FragmentPendingordersBinding;

import java.util.ArrayList;

public class PendingOrdersFragment extends Fragment {

    private PendingOrdersViewModel homeViewModel;
    private FragmentPendingordersBinding binding;
    ArrayList<String> pendingOrders;
    RecyclerView rvPendingOrders;

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

        pendingOrders = new ArrayList<String>();
        pendingOrders.add("yash bansal");
        pendingOrders.add("Utkarsh chutiya");
        pendingOrders.add("Mota Bhadwa");

        rvPendingOrders = root.findViewById(R.id.rvPendingOrders);
        PendingOrderAdapter adapter = new PendingOrderAdapter(getContext(), pendingOrders);
        rvPendingOrders.setAdapter(adapter);
        rvPendingOrders.setLayoutManager(new LinearLayoutManager(getContext()));


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
package com.example.zwiggy.UI.OwnerUI.OwnerMenu;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zwiggy.Adapter.OwnerMenuAdapter;
import com.example.zwiggy.R;
import com.example.zwiggy.databinding.FragmentOwnermenuBinding;

import java.util.ArrayList;

public class OwnerMenuFragment extends Fragment {

    private OwnerMenuViewModel ownerMenuViewModel;
    private FragmentOwnermenuBinding binding;
    RecyclerView rvOwnerMenu;
    ArrayList<String> restaurants;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ownerMenuViewModel =
                new ViewModelProvider(this).get(OwnerMenuViewModel.class);

        binding = FragmentOwnermenuBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        rvOwnerMenu = root.findViewById(R.id.rvOwnerMenu);
        restaurants = new ArrayList<>();
        restaurants.add("Taj Chutiyapa");
        restaurants.add("Mughal Bakchodi");
        restaurants.add("Oberoi Group Of Bhadwas");

        OwnerMenuAdapter adapter=new OwnerMenuAdapter(getContext(), restaurants);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        rvOwnerMenu.setLayoutManager(layoutManager);
        rvOwnerMenu.setAdapter(adapter);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
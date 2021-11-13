package com.example.zwiggy.UI.OwnerUI.AcceptedOrders;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AcceptedOrdersViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AcceptedOrdersViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is notifications fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
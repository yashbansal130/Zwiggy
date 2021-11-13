package com.example.zwiggy.UI.OwnerUI.PendingOrders;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PendingOrdersViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PendingOrdersViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
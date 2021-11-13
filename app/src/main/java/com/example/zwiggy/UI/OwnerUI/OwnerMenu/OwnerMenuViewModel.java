package com.example.zwiggy.UI.OwnerUI.OwnerMenu;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class OwnerMenuViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public OwnerMenuViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
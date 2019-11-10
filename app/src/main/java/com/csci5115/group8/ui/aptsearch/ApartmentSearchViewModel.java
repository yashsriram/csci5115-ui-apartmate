package com.csci5115.group8.ui.aptsearch;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ApartmentSearchViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ApartmentSearchViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is apartment search fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
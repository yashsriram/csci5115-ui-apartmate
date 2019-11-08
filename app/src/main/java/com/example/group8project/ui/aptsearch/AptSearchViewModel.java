package com.example.group8project.ui.aptsearch;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AptSearchViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AptSearchViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is apartment search fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
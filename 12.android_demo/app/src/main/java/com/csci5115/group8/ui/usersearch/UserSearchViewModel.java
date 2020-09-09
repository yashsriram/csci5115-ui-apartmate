package com.csci5115.group8.ui.usersearch;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class UserSearchViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public UserSearchViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is user seach fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
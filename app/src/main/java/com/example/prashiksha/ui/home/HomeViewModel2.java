package com.example.prashiksha.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel2 extends ViewModel {

    private final MutableLiveData<String> mText;

    public HomeViewModel2() {
        mText = new MutableLiveData<>();
        mText.setValue("Welcome Learner!");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
package com.example.prashiksha.ui.bits;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BitsViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public BitsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is bits fragment.");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
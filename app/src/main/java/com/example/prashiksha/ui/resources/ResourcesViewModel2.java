package com.example.prashiksha.ui.resources;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ResourcesViewModel2 extends ViewModel {

    private final MutableLiveData<String> mText;

    public ResourcesViewModel2() {
        mText = new MutableLiveData<>();
        mText.setValue("");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
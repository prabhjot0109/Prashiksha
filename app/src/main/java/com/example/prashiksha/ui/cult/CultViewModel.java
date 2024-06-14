package com.example.prashiksha.ui.cult;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CultViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public CultViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is cult fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
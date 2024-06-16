package com.example.prashiksha.ui.cult;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CultViewModel2 extends ViewModel {

    private final MutableLiveData<String> mText;

    public CultViewModel2() {
        mText = new MutableLiveData<>();
        mText.setValue("");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
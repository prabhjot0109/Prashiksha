package com.example.prashiksha.ui.bits;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BitsViewModel2 extends ViewModel {

    private final MutableLiveData<String> mText;

    public BitsViewModel2() {
        mText = new MutableLiveData<>();
        mText.setValue("");
    }

    public LiveData<String> getText() {
        return mText;
    }
}

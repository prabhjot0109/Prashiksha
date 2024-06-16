package com.example.prashiksha.ui.fix;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FixViewModel2 extends ViewModel {

    private final MutableLiveData<String> mText;

    public FixViewModel2() {
        mText = new MutableLiveData<>();
        mText.setValue("");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
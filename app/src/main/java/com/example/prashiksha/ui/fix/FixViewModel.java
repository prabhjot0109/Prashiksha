package com.example.prashiksha.ui.fix;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FixViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public FixViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Fix fragment.");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
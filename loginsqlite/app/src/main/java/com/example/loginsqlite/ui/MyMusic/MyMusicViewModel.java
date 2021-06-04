package com.example.loginsqlite.ui.MyMusic;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyMusicViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MyMusicViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is MyMusic fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
package com.jetpackcomponets.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class b_MainViewModelFactory implements ViewModelProvider.Factory {
    int cnt;
    public b_MainViewModelFactory(int cnt){
        this.cnt = cnt;
    }
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new b_MainViewModelWithAgrs(5);
    }
}

package com.jetpackcomponets.viewmodel;

import androidx.lifecycle.ViewModel;

public class b_MainViewModelWithAgrs extends ViewModel {
    private int cnt;
    public b_MainViewModelWithAgrs(int cnt){
        this.cnt = cnt;
    }
    public int getCount(){
        return cnt;
    }
}

package com.jetpackcomponets.viewmodel;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.jetpackcomponets.R;

public class b_MainActivityFactory extends AppCompatActivity {
    //ViewModel Factory Method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_live_data);
        b_MainViewModelWithAgrs vm= new ViewModelProvider(this,new b_MainViewModelFactory(5)).get(b_MainViewModelWithAgrs.class);
        int cnt=vm.getCount();
        Log.i("VM","Count : "+cnt);
    }
}

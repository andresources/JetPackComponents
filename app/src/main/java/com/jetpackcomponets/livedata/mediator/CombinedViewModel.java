package com.jetpackcomponets.livedata.mediator;

import android.app.Application;
import android.os.Handler;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class CombinedViewModel extends AndroidViewModel {
    CombinedLiveData meditor;
    MutableLiveData<List<Expense>> livedata1=new MutableLiveData<>();
    MutableLiveData<List<Income>> livedata2=new MutableLiveData<>();
    public CombinedViewModel(@NonNull Application application) {
        super(application);
         meditor=new CombinedLiveData(livedata1,livedata2);
    }

    public CombinedLiveData getMeditor(){
        return meditor;
    }

    public void setData(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                List<Expense> list= new ArrayList<>();
                list.add(new Expense(500));
                livedata1.setValue(list);
            }
        },1000);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                List<Income> list1= new ArrayList<>();
                list1.add(new Income(1000));
                livedata2.setValue(list1);
            }
        },10000);

    }


}

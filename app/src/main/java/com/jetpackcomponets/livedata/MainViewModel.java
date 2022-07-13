package com.jetpackcomponets.livedata;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends AndroidViewModel {
    MediatorLiveData<String> meditor=new MediatorLiveData<>();
    MutableLiveData<String> livedata1=new MutableLiveData<>();
    MutableLiveData<String> livedata2=new MutableLiveData<>();
    public MainViewModel(@NonNull Application application) {
        super(application);
        addSourcesToMeditorLiveData();
    }

    public void setLiveData1(String str){
        livedata1.setValue(str);
    }
    public void setLiveData2(String str){
        livedata2.setValue(str);
    }

    public LiveData<String> getData(){
        return meditor;
    }

    private void addSourcesToMeditorLiveData(){
        meditor.addSource(livedata1, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                meditor.setValue(s);
            }
        });
        meditor.addSource(livedata2, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                meditor.setValue(s);
            }
        });
    }

}

package com.jetpackcomponets.livedata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pair;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.jetpackcomponets.R;
import com.jetpackcomponets.livedata.mediator.CombinedLiveData;
import com.jetpackcomponets.livedata.mediator.CombinedViewModel;
import com.jetpackcomponets.livedata.mediator.Expense;
import com.jetpackcomponets.livedata.mediator.Income;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView tv,tvExpInc1,tvExpInc2;
    MainViewModel vm;
    CombinedViewModel cvm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_live_data);
        tv=(TextView) findViewById(R.id.tv);
        tvExpInc1=(TextView) findViewById(R.id.tvExpInc1);
        tvExpInc2=(TextView) findViewById(R.id.tvExpInc2);
        vm=new ViewModelProvider(this).get(MainViewModel.class);
        cvm=new ViewModelProvider(this).get(CombinedViewModel.class);
        vm.getData().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                tv.setText(s);
            }
        });
    }

    public void clickLiveData1(View view) {
        vm.setLiveData1("Hello");
    }

    public void clickLiveData2(View view) {
        vm.setLiveData2("Welcome");
    }

    public void clickSetMeditorLiveData(View view) {
        cvm.setData();
    }
    int i1=0,i2=0;
    int cnt=0;
    public void clickGetMeditorLiveData(View view) {

        CombinedLiveData c=cvm.getMeditor();
        c.observe(this, new Observer<Pair<List<Expense>, List<Income>>>() {
            @Override
            public void onChanged(Pair<List<Expense>, List<Income>> listListPair) {
                cnt++;
                List<Expense>  expenses=listListPair.first;
                List<Income>  incomes=listListPair.second;
                if(expenses!=null&&expenses.size()>0){
                     i1=expenses.get(0).getNum();
                     tvExpInc1.setText(i1+" : "+cnt);
                }
                if(incomes!=null&&incomes.size()>0){
                    i2=incomes.get(0).amt;
                    tvExpInc2.setText(i2+" : "+cnt);
                }
            }
        });
    }
}
package com.jetpackcomponets.livedata.mediator;

import androidx.core.util.Pair;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;

import java.util.Collections;
import java.util.List;

public class CombinedLiveData  extends MediatorLiveData<Pair<List<Expense>, List<Income>>> {
    private List<Expense> expenses = Collections.emptyList();
    private List<Income> incomes = Collections.emptyList();

    public CombinedLiveData(LiveData<List<Expense>> ld1, LiveData<List<Income>> ld2) {
        setValue(Pair.create(expenses, incomes));

        addSource(ld1, expenses -> {
            if(expenses != null) {
                this.expenses = expenses;
            }
            setValue(Pair.create(expenses, incomes));
        });

        addSource(ld2, incomes -> {
            if(incomes != null) {
                this.incomes = incomes;
            }
            setValue(Pair.create(expenses, incomes));
        });
    }
}

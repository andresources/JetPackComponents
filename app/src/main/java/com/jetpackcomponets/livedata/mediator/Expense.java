package com.jetpackcomponets.livedata.mediator;

public class Expense {
    public Expense(int num) {
        this.num = num;
    }

    private int num=0;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}

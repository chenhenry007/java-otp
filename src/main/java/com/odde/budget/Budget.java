package com.odde.budget;

import java.time.YearMonth;

public class Budget {

    public Budget(YearMonth yearMonth, int amount) {
        this.yearMonth = yearMonth;
        this.amount = amount;
    }

    //Getter and Setter
    public YearMonth getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(YearMonth yearMonth) {
        this.yearMonth = yearMonth;
    }

    public int getAmount() {
        return amount;
    }

    public int getMonth() {
        return yearMonth.getMonthValue();
    }

    public int getYear() {
        return yearMonth.getYear();
    }

    private YearMonth yearMonth;
    private int amount;

}

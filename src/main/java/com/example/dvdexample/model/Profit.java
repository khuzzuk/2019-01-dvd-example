package com.example.dvdexample.model;

import java.math.BigDecimal;
import java.util.Date;

public class Profit {
    private String title;
    private Date date;
    private BigDecimal amount;

    public Profit(String title, Date date, BigDecimal amount) {
        this.title = title;
        this.date = date;
        this.amount = amount;
    }
}

package com.example.helloworld;

import java.util.Date;

public class Cycle {
    private final int balance;
    private static final Cycle c = new Cycle();
    private static final int deposit = (int) (Math.random() * 100);
    public int total;
    private Date date;

    public Cycle() {
        balance = deposit - 10;
    }

    void add() {
        if (total < Integer.MAX_VALUE) {
            total++;
        }
    }

    public void MutableClass() {
        date = new Date();
    }

    public Date getDate() {
        return date;
    }

    public static void main(String[] args) {
        System.out.println("The account balance is " + c.balance);
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        return false;
    }
}

package com.example.helloworld;

import java.util.Date;

public class Cycle {
    private final int balance;
    private static final Cycle c = new Cycle();
    private static final int deposit = (int) (Math.random() * 100);
    public int total;
    private Date d;

    public Cycle() {
        balance = deposit - 10;
    }

    void add(){
        if(total < Integer.MAX_VALUE) {
            total++;
        }
    }

    public void MutableClass(){
        d = new Date();
    }

    public Date getDate() {
        return d;
    }

    public static void main(String[] args) {
        System.out.println("The account balance is " + c.balance);
    }

    public boolean equals(Object o){
        try{
            for (float i = 0; i < 5.0f; i++) {
                System.out.println(i);
            }
        }catch(Throwable e){
            System.out.println("Exception caught" + e);
        }


        if(o == this){
            return true;
        }
        return false;
    }
}

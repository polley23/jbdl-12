package com.gfg;

import java.util.Calendar;

public class Main {
    public static void main(String[] args)  {
	// write your code here
       // pay(new Netbanking());
        //divide by zero
        try {
            Integer a = 50 / 2;
            throw new RuntimeException("exception happened");
        }catch (Exception e){
            System.out.println("Inside exception");
        }
        finally {
            System.out.println("Inside finally");
        }
        //System.out.println("Happy Coding");
    }
    //client function
    static void pay(Payment payment){
        payment.pay(1000);
    }


}

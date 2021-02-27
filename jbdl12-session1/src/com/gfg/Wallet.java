package com.gfg;

public class Wallet implements Payment{
    @Override
    public void pay(Integer money) {
        System.out.println("100 has been paid through wallet");
    }
}

package com.gfg;

public interface Payment3 {
     Integer money=100;

     default public void pay(Integer money){
          System.out.println("100 has been paid through pay3");

     }
}

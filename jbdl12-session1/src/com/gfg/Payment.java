package com.gfg;

public interface Payment {
     Integer money=200;
     default void pay(Integer money) {
          System.out.println("100 has been paid through pay1");
     }
}
//Animal - wieght , abstract movement()
//mamal - doesn't lay eggs
// Tiger (walks with help of 4 legs),
// Human (walks with help of 2 legs)

// Class A validate() {...};
// Class B extends A validate() {...overrides A};
// Class C extends A validate() {...overrides A};
// 3 implementations of validate()

//Java allows multiple inheritance
//class called D extends B, C
// D d = new D();
// d.validate();




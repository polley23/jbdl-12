package com.gfg;

public class Netbanking implements Payment2,Payment,Payment3{

    @Override
    public void pay(Integer money) {

    }
}

//Java classes - concrete classes
//Abstract class - contracts. Abstract functions and default functions, states(attributes)
//Interface - contracts . Abstract functions and default functions, constants

//Class can extend or inherit only one class or one abstract class.
// why ? in multiple inheritance we are not sure which implementation to pick
// because multiple parent class will have multiple impl

// interface can extends multiple interfaces because most of the time interfaces
//has only contract and fallbacks. Also interfaces doesn't have attributes.
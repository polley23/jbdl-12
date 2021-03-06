package com.gfg;

public class PrintOdd implements Runnable{
    private  OddEvenPrinter oddEvenPrinter;

    public PrintOdd(OddEvenPrinter oddEvenPrinter) {
        this.oddEvenPrinter = oddEvenPrinter;
    }

    @Override
    public void run() {
        oddEvenPrinter.printOdd();
    }
}

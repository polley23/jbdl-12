package com.gfg;

public class PrintEven implements Runnable{
    private  OddEvenPrinter oddEvenPrinter;

    public PrintEven(OddEvenPrinter oddEvenPrinter) {
        this.oddEvenPrinter = oddEvenPrinter;
    }

    @Override
    public void run() {
        oddEvenPrinter.printEven();
    }
}

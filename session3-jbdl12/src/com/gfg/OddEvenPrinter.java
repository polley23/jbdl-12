package com.gfg;

public class OddEvenPrinter{
    private int maxNumber ;
    private int i=0;

    public OddEvenPrinter(int maxNumber) {
        this.maxNumber = maxNumber;
    }

    void printOdd() {
        while(i<this.maxNumber){
            synchronized (this){
                if(i%2==1){
                    System.out.println(i);
                    i++;
                    this.notify();
                }else {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

     void  printEven(){
        while(i<this.maxNumber){
            synchronized (this){
                if(i%2==0){
                    System.out.println(i);
                    i++;
                    this.notify();
                }else
                {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }

    }
}

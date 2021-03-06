package com.gfg;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        Runnable runnable = new Runnable(){
//            @Override
//            public void run() {
//                for (int i = 0; i < 10 ; i++){
//                   System.out.println("Happy coding "+i + " Thread name : "+ Thread.currentThread().getName());
//
//                }
//            }
//        };
//
//        Runnable runnable1 = new Runnable(){
//            @Override
//            public void run() {
//                for (int i = 0; i < 10 ; i++){
//                    if(i==4){
//                        Thread.yield();
//                    }
//                    System.out.println("Happy coding "+i + " Thread name : "+ Thread.currentThread().getName());
//
//                }
//            }
//        };
//        Thread thread1 = new Thread(runnable1,"thread 1");
//        thread1.setPriority(2);
//        Thread thread2 = new Thread(runnable, "thread 2");
//        thread2.setPriority(6);
//
//        thread1.start();
//        thread2.start();
        OddEvenPrinter oddEvenPrinter = new OddEvenPrinter(2000);
        Thread evenThread = new Thread(new PrintEven(oddEvenPrinter));
        Thread oddThread = new Thread(new PrintOdd(oddEvenPrinter));
        evenThread.start();
        oddThread.start();


    }
}

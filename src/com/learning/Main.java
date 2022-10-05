package com.learning;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("We are now in thread: " + Thread.currentThread().getName());
                System.out.println("Thread priority: " + Thread.currentThread().getPriority());
            }
        });
        thread.setName("New worker thread");
        thread.setPriority(Thread.MAX_PRIORITY);
        System.out.println("We are in thread: " + Thread.currentThread().getName() + " before the start method");
        thread.start();

        System.out.println("We are in thread: " + Thread.currentThread().getName() + " after the start method");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                throw new RuntimeException("Intentinal Exception");
            }
        });
        thread2.setName("Misbehaving thread");
        thread2.setPriority(Thread.MAX_PRIORITY);
        thread2.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("A critical error happend in thread" + t.getName() + " and the error is " + e.getMessage());
            }
        });
        System.out.println("We are in thread: " + Thread.currentThread().getName() + " before the start method");
        thread2.start();

        System.out.println("We are in thread: " + Thread.currentThread().getName() + " after the start method");


        Thread thread3 = new Thread(new Task2());
        thread3.start();
    }

    public static class Task2 implements Runnable {
        @Override
        public void run(){
            System.out.println("Hello from new thread");
        }
    }

}

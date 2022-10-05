package com.learning;

import java.util.ArrayList;
import java.util.List;

public class ThreadDemo implements Runnable{
    @Override
    public void run() {
        System.out.println("This is a task by thread: "+ Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Runnable r1 = new ThreadDemo();
        Runnable r2 = new ThreadDemo();
        Runnable r3 = new ThreadDemo();

        List<Runnable> runnableList = new ArrayList<>();
        runnableList.add(r1);
        runnableList.add(r2);
        runnableList.add(r3);

        MultiExecutor multiExecutor = new MultiExecutor(runnableList);
        multiExecutor.executeAll();

    }
}

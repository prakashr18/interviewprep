package com.threads;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadDemo {

    public static void main(String[] args) {
        Thread thread = new Thread();
        thread.setPriority(10);
        thread.stop();
        int coreCount= Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(coreCount);

        for(int i=0; i< 100; ++i) {
            executorService.execute(new CpuIntensiveTask());
        }

        executorService.shutdownNow();
    }

    static class CpuIntensiveTask implements Runnable {

        @Override
        public void run() {
            System.out.println("Current Thread: " + Thread.currentThread().getName());
            for(int i=0; i<10; ++i) {
                System.out.println("The number is: "+ i + " in thread: "+Thread.currentThread().getName());
            }
        }
    }
    public void checkDEadLockThreads() {
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.getHoldCount();
        LongAdder longAdder = new LongAdder();
        BlockingQueue blockingQueue = new ArrayBlockingQueue(10);
        ThreadLocal threadLocal = new ThreadLocal();
        ThreadMXBean bean = ManagementFactory.getThreadMXBean();
        long[] threadIds = bean.findDeadlockedThreads(); // It will return null for no deadlock
        if (threadIds != null) {
            ThreadInfo[] infos = bean.getThreadInfo(threadIds);
            for (ThreadInfo info : infos) {
                StackTraceElement[] stack = info.getStackTrace();
                    // Log or store stack trace information.
            }
        }
    }
}

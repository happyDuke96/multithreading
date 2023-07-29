package org.multithreading.threads.declare;

public class RunnableThread implements Runnable{


    @Override
    public void run() {
        Thread runnableThread = Thread.currentThread();
        runnableThread.setName("Runnable");
        System.out.println("Runnable thread name: " + runnableThread);
    }
}

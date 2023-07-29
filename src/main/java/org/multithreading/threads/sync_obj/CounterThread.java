package org.multithreading.threads.sync_obj;

public class CounterThread extends Thread{

    private final Counter counter;

    public CounterThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 500; i++) {
            counter.increment();
        }
        for (int i = 0; i < 500; i++) {
            counter.decrement();
        }
    }
}

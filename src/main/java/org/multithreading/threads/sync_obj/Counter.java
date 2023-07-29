package org.multithreading.threads.sync_obj;

public class Counter {

    private volatile int count;
    private volatile int count2;

    public int getCount() {
        return count;
    }

    public int getCount2() {
        return count2;
    }

    public void increment() {
        synchronized(this){
            count++;
            count2++;
        }
    }

    public void decrement() {
        synchronized(this) {
            this.count--;
            this.count2--;
        }
    }
}

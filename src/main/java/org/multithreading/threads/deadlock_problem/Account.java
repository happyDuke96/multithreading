package org.multithreading.threads.deadlock_problem;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {

    private static int generator = 1;
    private int id;
    private volatile int money;

    // solving deadLock
    private final Lock lock = new ReentrantLock();

    public Account(int money) {
        this.money = money;
        this.id = generator++;
    }

    public Lock getLock() {
        return lock;
    }

    public void add(int money) {
        this.money += money;
    }

    public boolean takeOff(int money) {
        if (this.money >= money) {
            this.money -= money;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", money=" + money +
                '}';
    }
}

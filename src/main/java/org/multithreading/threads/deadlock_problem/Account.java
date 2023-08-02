package org.multithreading.threads.deadlock_problem;

public class Account {

    private static int generator = 1;
    private int id;

    private long money;

    public Account(long money){
        this.money = money;
        this.id = generator++;
    }


    public void add(long money){
        this.money += money;
    }

    public boolean takeOff(long money){
        if (this.money >= money){
            this.money -= money;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", money=" + money +
                '}';
    }
}

package org.multithreading.threads.deadlock_problem;

public class AccountDemo {
    public static void main(String[] args) throws InterruptedException {
        Account accountFrom = new Account(20000);
        Account accountTo = new Account(20000);

        Thread accountFromThread = new Thread(new AccountThread(accountFrom, accountTo));
        Thread accountToThread = new Thread(new AccountThread(accountTo, accountFrom));

        accountFromThread.start();
        accountToThread.start();

        accountFromThread.join();
        accountToThread.join();


        System.out.println(accountFrom);
        System.out.println(accountTo);
    }

}

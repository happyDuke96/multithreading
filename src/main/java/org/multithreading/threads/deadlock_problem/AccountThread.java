package org.multithreading.threads.deadlock_problem;

public class AccountThread implements Runnable {

    private final Account accountFrom;
    private final Account accountTo;

    public AccountThread(Account accountFrom, Account accountTo) {
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
    }

/**
 * Внизу происходит Deadlock ситуация
 * прихватил монитор теперь ему нужен прихватить
 * @param accountTo, в свой очередь accountTo нужен accountFrom
 *
 * accountFrom --- need ----> accountTo
 *
 * accountTo ---need ----> accountFrom
 */
    @Override
    public void run() {
        for (int i = 0; i < 2000; i++) {
            synchronized (accountFrom) {
                synchronized (accountTo) {
                    accountFrom.takeOff(10);
                    accountTo.add(10);
                }
            }
        }
    }
}

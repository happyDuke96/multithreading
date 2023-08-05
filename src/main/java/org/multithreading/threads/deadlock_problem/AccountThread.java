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
     *
     * @param accountTo, в свой очередь accountTo нужен accountFrom
     *                   <p>
     *                   accountFrom --- need ----> accountTo
     *                   <p>
     *                   accountTo ---need ----> accountFrom
     */
//    @Override
//    public void run() {
//        for (int i = 0; i < 2000; i++) {
//            synchronized (accountFrom) {
//                synchronized (accountTo) {
//                    if (accountFrom.takeOff(10)) {
//                        accountTo.add(10);
//                    }
//                }
//            }
//        }
//    }

    // Для решения проблему может использовать объекты более высокого уровня, --> Lock
    // по сути Lock использует Unsafe object Unsafe не синхронна работает
    // он работет самым низком уровне и использует нативный методы который достал из языка С
    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            lockAccounts();
            try {
                if (accountFrom.takeOff(10)) {
                    accountTo.add(10);
                }
            } finally {
                accountFrom.getLock().unlock();
                accountTo.getLock().unlock();
            }
        }
    }

    private void lockAccounts() {
        while (true) {
            boolean fromAccountResult = accountFrom.getLock().tryLock();
            boolean toAccountResult = accountTo.getLock().tryLock();
            if (fromAccountResult && toAccountResult) {
                break;
            }
            if (fromAccountResult) {
                accountFrom.getLock().unlock();
            }
            if (toAccountResult) {
                accountTo.getLock().unlock();
            }
        }
    }
}

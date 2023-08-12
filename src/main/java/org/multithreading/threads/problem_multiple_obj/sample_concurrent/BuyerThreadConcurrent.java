package org.multithreading.threads.problem_multiple_obj.sample_concurrent;

import java.util.concurrent.BlockingQueue;

public class BuyerThreadConcurrent implements Runnable {

    BlockingQueue<CashboxConcurrent> cashBoxes;

    public BuyerThreadConcurrent(BlockingQueue<CashboxConcurrent> cashBoxes) {
        this.cashBoxes = cashBoxes;
    }

    @Override
    public void run() {
        try {
            CashboxConcurrent cashBox = cashBoxes.take();
            System.out.println(Thread.currentThread().getName() + " обслуживается в кассе " + cashBox);
            Thread.sleep(5L);
            cashBoxes.add(cashBox);
            System.out.println(Thread.currentThread().getName() + " освобождаю кассу " + cashBox);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

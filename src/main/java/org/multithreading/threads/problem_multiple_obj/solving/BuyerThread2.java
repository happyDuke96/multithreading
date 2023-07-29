package org.multithreading.threads.problem_multiple_obj.solving;

import org.multithreading.threads.problem_multiple_obj.CashBox;

import java.util.Queue;

public class BuyerThread2 implements Runnable {

    Queue<CashBox> cashBoxes;

    public BuyerThread2(Queue<CashBox> cashBoxes) {
        this.cashBoxes = cashBoxes;
    }

    @Override
    public void run() {

        try {
            synchronized (cashBoxes) {
                while (true) {
                    if (!cashBoxes.isEmpty()) {
                        CashBox cashBox = cashBoxes.remove();
                        System.out.println(Thread.currentThread().getName() + " обслуживается в кассе " + cashBox);

                        cashBoxes.wait(5l);

                        System.out.println(Thread.currentThread().getName() + " освобождаю кассу " + cashBox);
                        cashBoxes.add(cashBox);
                        cashBoxes.notifyAll();
                        break;
                    } else {
                        System.out.println(Thread.currentThread().getName() + " ожидает кассу");
                        cashBoxes.wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

package org.multithreading.threads.problem_multiple_obj;

import java.util.Queue;

public class BuyerThread implements Runnable{

    Queue<CashBox> cashBoxes;

    public BuyerThread(Queue<CashBox> cashBoxes) {
        this.cashBoxes = cashBoxes;
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (!cashBoxes.isEmpty()) {
                    CashBox cashBox = cashBoxes.remove();
                    System.out.println(Thread.currentThread().getName() + " обслуживается в кассе " + cashBox);

                    Thread.sleep(5l);
                    System.out.println(Thread.currentThread().getName() + " освобождаю кассу " + cashBox);
                    cashBoxes.add(cashBox);
                    break;
                } else {
                    Thread.sleep(5l);
                    System.out.println(Thread.currentThread().getName() + " ожидает кассу");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

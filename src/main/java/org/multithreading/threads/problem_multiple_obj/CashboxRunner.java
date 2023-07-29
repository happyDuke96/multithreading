package org.multithreading.threads.problem_multiple_obj;

import org.multithreading.threads.problem_multiple_obj.solving.BuyerThread2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CashboxRunner {

    public static void main(String[] args)throws InterruptedException{
        List<CashBox> cashBoxList = new ArrayList<>();
        cashBoxList.add(new CashBox());
        cashBoxList.add(new CashBox());
        Queue<CashBox> cashBoxes = new ArrayDeque<>(cashBoxList);


        buyerFirst(cashBoxes);
        buyerSecond(cashBoxes);
    }

    private static void buyerFirst(Queue<CashBox> cashBoxes) throws InterruptedException {
        List<Thread> threads = Stream.of(
            new BuyerThread(cashBoxes),
            new BuyerThread(cashBoxes),
            new BuyerThread(cashBoxes),
            new BuyerThread(cashBoxes),
            new BuyerThread(cashBoxes),
            new BuyerThread(cashBoxes),
            new BuyerThread(cashBoxes),
            new BuyerThread(cashBoxes),
            new BuyerThread(cashBoxes),
            new BuyerThread(cashBoxes)
        ).map(Thread::new)
        .peek(Thread::start)
        .collect(Collectors.toList());

        for (Thread thread : threads) {
            thread.join();
        }
    }

    private static void buyerSecond(Queue<CashBox> cashBoxes) throws InterruptedException {
        List<Thread> threads = Stream.of(
                        new BuyerThread2(cashBoxes),
                        new BuyerThread2(cashBoxes),
                        new BuyerThread2(cashBoxes),
                        new BuyerThread2(cashBoxes),
                        new BuyerThread2(cashBoxes),
                        new BuyerThread2(cashBoxes),
                        new BuyerThread2(cashBoxes),
                        new BuyerThread2(cashBoxes),
                        new BuyerThread2(cashBoxes),
                        new BuyerThread2(cashBoxes)
                ).map(Thread::new)
                .peek(Thread::start)
                .collect(Collectors.toList());

        for (Thread thread : threads) {
            thread.join();
        }
    }

}

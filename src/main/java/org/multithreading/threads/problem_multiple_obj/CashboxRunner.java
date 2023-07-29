package org.multithreading.threads.problem_multiple_obj;

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
   
}

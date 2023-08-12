package org.multithreading.threads.problem_multiple_obj.sample_concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CashboxRunnerConcurrent {

    public static void main(String[] args)throws InterruptedException{
        List<CashboxConcurrent> cashBoxList = new ArrayList<>();
        cashBoxList.add(new CashboxConcurrent());
        cashBoxList.add(new CashboxConcurrent());
        BlockingQueue<CashboxConcurrent> cashBoxes = new ArrayBlockingQueue<>(2,true,cashBoxList);

        buyerFirst(cashBoxes);
    }

    private static void buyerFirst(BlockingQueue<CashboxConcurrent> cashBoxes) throws InterruptedException {
        List<Thread> threads = Stream.of(
                        new BuyerThreadConcurrent(cashBoxes),
                        new BuyerThreadConcurrent(cashBoxes),
                        new BuyerThreadConcurrent(cashBoxes),
                        new BuyerThreadConcurrent(cashBoxes),
                        new BuyerThreadConcurrent(cashBoxes),
                        new BuyerThreadConcurrent(cashBoxes),
                        new BuyerThreadConcurrent(cashBoxes),
                        new BuyerThreadConcurrent(cashBoxes),
                        new BuyerThreadConcurrent(cashBoxes),
                        new BuyerThreadConcurrent(cashBoxes)
                ).map(Thread::new)
                .peek(Thread::start)
                .collect(Collectors.toList());

        for (Thread thread : threads) {
            thread.join();
        }
    }
}

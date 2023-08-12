package org.multithreading.cuncurrent.count_down_latch;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountDownDemo {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(RocketDetail.values().length);
        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        threadPool.submit(new Rocket(countDownLatch));

        Arrays.stream(RocketDetail.values())
                .map(detail -> new RocketDetailRun(detail,countDownLatch))
                .forEach(threadPool::submit);

        threadPool.shutdown();
        threadPool.awaitTermination(1L, TimeUnit.MINUTES);

    }
}

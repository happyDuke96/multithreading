package org.multithreading.cuncurrent.count_down_latch;

import java.util.concurrent.CountDownLatch;

public class RocketDetailRun implements Runnable {

    private final RocketDetail rocketDetail;
    private final CountDownLatch countDownLatch;

    public RocketDetailRun(RocketDetail rocketDetail, CountDownLatch countDownLatch) {
        this.rocketDetail = rocketDetail;
        this.countDownLatch = countDownLatch;
    }


    @Override
    public void run() {
        System.out.println("Готовитсья деталь: " + rocketDetail);
        try {
            Thread.sleep(1000L);
            System.out.println("Деталь готов: " + rocketDetail);
            countDownLatch.countDown();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

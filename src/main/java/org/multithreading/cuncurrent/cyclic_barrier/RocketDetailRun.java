package org.multithreading.cuncurrent.cyclic_barrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class RocketDetailRun implements Runnable {

    /**
     * CyclicBarrier аналог CountDownLatch нo у него есть один метод await,этот метод отпустит только когда счетчик котирый мы передали
     * здесь мы не можем декриментит этот счетчик в ручную нам нужен столько поток тока колинчеств в cyclicBarrier
     * смотреть --> CyclicBarrierDemo
     * */
    private final RocketDetail rocketDetail;
    private final CyclicBarrier cyclicBarrier;

    public RocketDetailRun(RocketDetail rocketDetail, CyclicBarrier cyclicBarrier) {
        this.rocketDetail = rocketDetail;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        System.out.println("Готовитсья деталь: " + rocketDetail);
        try {
            Thread.sleep(1000L);
            System.out.println("Деталь готов: " + rocketDetail);
            cyclicBarrier.await();
            System.out.println("Деталь использован: " + rocketDetail);
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }
}

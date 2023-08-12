package org.multithreading.cuncurrent.count_down_latch;

import java.util.concurrent.CountDownLatch;

public class Rocket implements Runnable {

    /**
     * По сути countdownlatch работает как счетчик,у него есть 2 основные методы await() и countDown(). Тут используется @param --> CountDownLatch как общий ресурс
     * в конструктор передаем общий количество счетчика и...
     * */
    private final CountDownLatch countDownLatch;

    public Rocket(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }


    @Override
    public void run() {
        System.out.println("Ракета готовится к запуску....");
        try {
            /**
             * И тут визовым метод await oн не отпускает поток который выполняет метод этот run() пока CountdownLatch
             * не закончится, т.е другой поток вызывает метод countdown() и счетчик заканчивается потом await отпускает дальше
             * */
            countDownLatch.await();
            System.out.println("Пуск!!!");
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

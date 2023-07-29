package org.multithreading.threads.volatilee;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * http://www.edwardbosworth.com/My5155_Slides/Chapter13/CacheCoherency.htm
 * */
public class VolatileDemo {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        myThread.shutDown();
    }


    static class MyThread extends Thread {
        // Тут могут быть ошибка потому что процессор сохраняет в свой кеше этот значение для оптимизации
//        private boolean running = true;

        // ключевое слово volatile говорит что не надо кэшировать,тогда все потоки использует один и тот же память
        // и убегаем от проблемы Когерентность кэша не работает для ссылочных типов,чтобы работал значение этих типов должен помечен как
        // volatile,пример -----> AtomicInteger
        private volatile boolean running = true;

        @Override
        public void run() {
            while (running){
                System.out.println("Printing...");
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        private void shutDown(){
            this.running = false;
        }
    }
}

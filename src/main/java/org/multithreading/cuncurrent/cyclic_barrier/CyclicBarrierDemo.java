package org.multithreading.cuncurrent.cyclic_barrier;

import java.util.Arrays;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierDemo {
    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(RocketDetail.values().length, () -> System.out.println("Пуск!!!"));
        /**
         * Тут мы не можем меньше поток от количеств в CyclicBarrier, 2 поток выполняет RocketDetailRun но потом безконечно будет ожидать,
         * потому что у нас нет больше потоков который будет выполнять метод await()
         * решение тут может использовать Executors.newCachedThreadPool() он берет потоки из кэша если не будет то создает новый
         * */
//        ExecutorService threadPo ol = Executors.newFixedThreadPool(2);
        ExecutorService threadPool = Executors.newCachedThreadPool();

        Arrays.stream(RocketDetail.values())
                .map(detail -> new RocketDetailRun(detail,cyclicBarrier))
                .forEach(threadPool::submit);

    }
}

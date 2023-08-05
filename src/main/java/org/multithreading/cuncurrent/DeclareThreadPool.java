package org.multithreading.cuncurrent;

import java.util.concurrent.*;

public class DeclareThreadPool {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {

        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(4);
        threadPool.scheduleAtFixedRate(() -> System.out.println("OK!"),2L,4L,TimeUnit.SECONDS);
//
//        fixedThreadSample();
    }

    private static void fixedThreadSample() throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        // он не блокирует основной поток пока не вызывает метод get() --> возвращает объект (результат) будущего
        Future<Integer> future = threadPool.submit(() -> {
            System.out.println("Execute with Callable");
            return 8;
        });

        System.out.println("Result future: " + future.get());
        // ждет пока все задачи выполнялись
        threadPool.shutdown();
        threadPool.awaitTermination(1L, TimeUnit.HOURS);
        System.out.println("Main thread end");
    }
}

package org.multithreading.threads.declare;

public class ThreadDemo {

    public static void main(String[] args) {
        SimpleThread simpleThread = new SimpleThread();
        System.out.println(simpleThread.getName() +" :"+simpleThread.getState());
        Thread runnableThread = new Thread(new RunnableThread());
        Thread lambdaSecondThread = new Thread(() -> System.out.println("Lambda Thread: " + Thread.currentThread().getName()));

        // 1. запуск simpleThread
        simpleThread.start();
        System.out.println(simpleThread.getName() +" :"+simpleThread.getState());
        // 2. запуск lambdaSecondThread -> Thread.currentThread() создает новый поток
        lambdaSecondThread.start();
        // 3. запуск runnableThread
        runnableThread.start();


        try {
            runnableThread.join();
            simpleThread.join();
            System.out.println(simpleThread.getName() +" :"+simpleThread.getState());
            lambdaSecondThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 4. запуск main потока,mainThread ожидает,потому что метод Thread.join() объявленное сверху
        // задерживает,и не выполняется другие пока не завершит работу поток вызываеющий метод join
        Thread mainThread = Thread.currentThread();
        System.out.println(mainThread.getName());

    }
}

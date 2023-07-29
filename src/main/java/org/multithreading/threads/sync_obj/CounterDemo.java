package org.multithreading.threads.sync_obj;

public class CounterDemo {

    public static void main(String[] args) throws InterruptedException {


        Counter counter = new Counter();
        Counter counter2 = new Counter();
        CounterThread counterThread1 = new CounterThread(counter);
        CounterThread counterThread2 = new CounterThread(counter);
        CounterThread counterThread3 = new CounterThread(counter);
        CounterThread counterThread4 = new CounterThread(counter);
        CounterThread counterThread5 = new CounterThread(counter);
        CounterThread counterThread6 = new CounterThread(counter);
        CounterThread counterThread7 = new CounterThread(counter);
        CounterThread counterThread8 = new CounterThread(counter);


        CounterThread counterThread11 = new CounterThread(counter2);
        CounterThread counterThread22 = new CounterThread(counter2);
        CounterThread counterThread33 = new CounterThread(counter2);
        CounterThread counterThread44 = new CounterThread(counter2);
        CounterThread counterThread55 = new CounterThread(counter2);
        CounterThread counterThread66 = new CounterThread(counter2);
        CounterThread counterThread77 = new CounterThread(counter2);
        CounterThread counterThread88 = new CounterThread(counter2);


        {
            counterThread1.start();
            counterThread2.start();
            counterThread3.start();
            counterThread4.start();
            counterThread5.start();
            counterThread6.start();
            counterThread7.start();
            counterThread8.start();

            counterThread1.join();
            counterThread2.join();
            counterThread3.join();
            counterThread4.join();
            counterThread5.join();
            counterThread6.join();
            counterThread7.join();
            counterThread8.join();
        }

        {
            counterThread11.start();
            counterThread22.start();
            counterThread33.start();
            counterThread44.start();
            counterThread55.start();
            counterThread66.start();
            counterThread77.start();
            counterThread88.start();

            counterThread11.join();
            counterThread22.join();
            counterThread33.join();
            counterThread44.join();
            counterThread55.join();
            counterThread66.join();
            counterThread77.join();
            counterThread88.join();
        }

        System.out.println(counter.getCount());
        System.out.println(counter.getCount2());
        System.out.println("**********************");
        System.out.println(counter2.getCount());
        System.out.println(counter2.getCount2());
    }
}

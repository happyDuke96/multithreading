package org.multithreading.cuncurrent;

import sun.misc.Unsafe;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemo {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        System.out.println(atomicInteger.get());

        atomicInteger.addAndGet(10);
        System.out.println(atomicInteger);

        Unsafe unsafe = Unsafe.getUnsafe();
    }
}

package org.multithreading.threads.declare;


/**
 * This class you can use it a Class Or Thread can add Constructor,getters,setters
 */
public class SimpleThread extends Thread {

    @Override
    public void run() {
        setName("Simple");
        System.out.println("Simple Thread name: " + getName());
    }
}

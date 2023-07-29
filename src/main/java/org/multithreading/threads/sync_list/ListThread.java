package org.multithreading.threads.sync_list;

import java.util.List;
public class ListThread extends Thread{

    /**
     * чтобы синхронизация работал правильно,хороший практика будет таким образом ссылка на док
     * https://docs.oracle.com/javase/7/docs/api/java/util/Collections.html#synchronizedList(java.util.List)
     */
    private final List<Integer> list;

    public ListThread(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        synchronized (list) {
            for (int i = 0; i < 400; i++) {
                list.add(i);
            }
        }
    }

}

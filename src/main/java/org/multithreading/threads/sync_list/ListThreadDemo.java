package org.multithreading.threads.sync_list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListThreadDemo {

    public static void main(String[] args) throws InterruptedException {
        /**
         * Синхронизируемый список означает только то add, что remove и т.д операции синхронизированы и следовательно атомарны.
         * Итерации, однако, нет, и если поток выполняет итерацию adds в то время, когда другой выполняет итерацию,
         * вы можете получить исключение ConcurrentModificationException.
         * */

        /*
        * List list = Collections.synchronizedList(new ArrayList());
          synchronized(list) {
           Iterator i = list.iterator(); // Must be in synchronized block
            while (i.hasNext())
                foo(i.next());
            }
        * */


        List<Integer> integers = Collections.synchronizedList(new ArrayList<>());

        ListThread listThread1 = new ListThread(integers);
        ListThread listThread2 = new ListThread(integers);
        ListThread listThread3 = new ListThread(integers);
        ListThread listThread4 = new ListThread(integers);
        ListThread listThread5 = new ListThread(integers);
        ListThread listThread6 = new ListThread(integers);
        ListThread listThread7 = new ListThread(integers);

        {
            listThread1.start();
            listThread2.start();
            listThread3.start();
            listThread4.start();
            listThread5.start();
            listThread6.start();
            listThread7.start();
        }

        {
            listThread1.join();
            listThread2.join();
            listThread3.join();
            listThread4.join();
            listThread5.join();
            listThread6.join();
            listThread7.join();
        }

        System.out.println(integers);
    }
}

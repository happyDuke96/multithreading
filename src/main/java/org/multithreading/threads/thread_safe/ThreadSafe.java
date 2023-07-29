package org.multithreading.threads.thread_safe;

import java.util.ArrayList;
import java.util.List;

/**
 * Потокобезопасность в java — это процесс, позволяющий сделать нашу программу безопасной для использования в многопоточной среде.
 * Самый простой способ это не делать общие ресурсы,или же сделать объект IMMUTABLE например как String
 * когда кто то хочет изменить объект возвращается всегда новый 
 * */
public class ThreadSafe {


    public static void main(String[] args) {
        Example example = new Example(new ArrayList<>());
        List<Integer> list = example.getList();

        list.add(2);

        System.out.println(example.getList());
    }

}

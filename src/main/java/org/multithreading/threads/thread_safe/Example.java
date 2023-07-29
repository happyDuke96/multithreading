package org.multithreading.threads.thread_safe;

import java.util.ArrayList;
import java.util.List;

public class Example {
    
    private List<Integer> list;

    // 
    public Example(List<Integer> list) {
        this.list = list;
    }

    // с помощью гет метод мы можем получить ссылка на лист и дальше можем изменить это будет не безопасно 
    // public List<Integer> getList() {
    //     return list;
    // }

    // чтобы был безопасно мы можем возвращать всегда новый  лист
    public List<Integer> getList() {
        return new ArrayList<>(list);
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }

    
}

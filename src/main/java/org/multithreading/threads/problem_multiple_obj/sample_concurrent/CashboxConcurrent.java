package org.multithreading.threads.problem_multiple_obj.sample_concurrent;

public class CashboxConcurrent {
    private static int generator = 1;
    private int id;

    CashboxConcurrent(){
        this.id = generator++;
    }

    @Override
    public String toString() {
        return "CashBox{" +
                "id=" + id +
                '}';
    }
}

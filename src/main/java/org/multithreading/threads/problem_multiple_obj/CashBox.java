package org.multithreading.threads.problem_multiple_obj;

public class CashBox {
    
    private static int generator = 1;
    private int id;

    CashBox(){
        this.id = generator++;
    }

    @Override
    public String toString() {
        return "CashBox{" +
                "id=" + id +
                '}';
    }
}

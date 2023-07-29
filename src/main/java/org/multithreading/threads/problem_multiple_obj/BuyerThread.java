package org.multithreading.threads.problem_multiple_obj;

import java.util.Queue;

public class BuyerThread implements Runnable{

    Queue<CashBox> cashBoxes;

    public BuyerThread(Queue<CashBox> cashBoxes) {
        this.cashBoxes = cashBoxes;
    }

    @Override
    public void run() {

        try {
            while(true){
               if(!cashBoxes.isEmpty()){
                CashBox cashBox = cashBoxes.remove();
               } 
            }            
        } catch (Exception e) {
            // TODO: handle exception
        }
        
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Barrier;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mohamed adel
 */
public class BarrierDriver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        int max_waiting_threads = 4;

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Barrier_sem barrier = new Barrier_sem(max_waiting_threads);
                int threadId = Integer.parseInt(Thread.currentThread().getName());
                for (int i = 0; i < 2; i++) {
                    try {
                        Thread.sleep(1000);

                    } catch (InterruptedException ex) {
                        Logger.getLogger(BarrierDriver.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                System.out.println("T" + threadId + " before breackpoint");
                barrier.barrierPoint();
                System.out.println("T" + threadId + " after breackpoint");
            }
        };
        Thread t1 = new Thread(runnable, "1");
        Thread t2 = new Thread(runnable, "2");
        Thread t3 = new Thread(runnable, "3");
        Thread t4 = new Thread(runnable, "4");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t1.join();
        t2.join();
        t3.join();
        t4.join();

    }

}

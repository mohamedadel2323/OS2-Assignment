/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Barrier;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AbdallaEssam
 */
public class Barrier_sem extends Barrier {

    private final Semaphore mutex;
    private final Semaphore blockerSemaphore;

    public Barrier_sem(int waitingCount) {
        super(waitingCount);
        mutex = new Semaphore(1);
        blockerSemaphore = new Semaphore(0);
    }

    public void barrierPoint() {
        try {
            mutex.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Barrier_sem.class.getName()).log(Level.SEVERE, null, ex);
        }
        super.noOfWatingThreads++;
        mutex.release();

        while (super.noOfWatingThreads != super.maxWaiting) {

            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(Barrier_sem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}

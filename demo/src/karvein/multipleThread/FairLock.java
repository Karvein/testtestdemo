package karvein.multipleThread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FairLock {
    private static Lock lock = new ReentrantLock(true);
    public static void testFairLock() {
        for (int i = 0; i < 2; i++) {
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + " get the lock.");
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}

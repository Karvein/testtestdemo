package karvein.multipleThread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UnfairLock {
    private static Lock lock = new ReentrantLock();
    public static void testUnfairLock() {
        for (int j = 0; j < 2; j++) {
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

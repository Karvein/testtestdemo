package karvein.multipleThread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    @Test
    public void test () throws Exception {
        // 1.初始化选择公平锁、非公平锁
        ReentrantLock lock = new ReentrantLock(true);
        // 2.可用于代码块
        lock.lock();
        try {
            try {
                // 3.支持多种加锁方式，比较灵活; 具有可重入特性
                if(lock.tryLock(100, TimeUnit.MILLISECONDS)){
                    System.out.println("lock is locked.");
                }
            } finally {
                // 4.手动释放锁
                lock.unlock();
                System.out.println("lock inner is unlocked.");
            }
        } finally {
            lock.unlock();
            System.out.println("lock outer is unlocked.");
        }
    }

}

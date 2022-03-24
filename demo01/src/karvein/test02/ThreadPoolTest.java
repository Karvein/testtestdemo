package karvein.test02;

import java.sql.SQLOutput;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {
    // thread pool test
    public static void main(String[] args) {
        // fixed thread pool
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        Runnable taskEin = new Runnable() {
            @Override
            public void run() {
                System.out.println("The task in fixed thread pool is running.");
            }
        };
        fixedThreadPool.execute(taskEin);
        // don't forget to shundown the pool
        fixedThreadPool.shutdown();

        // scheduled thread pool
        // timed task or periodic task
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        Runnable taskZwei = new Runnable() {
            @Override
            public void run() {
                System.out.println("the task in scheduled thread pool is running .");
            }
        };
        scheduledThreadPool.schedule(taskZwei, 1, TimeUnit.SECONDS);
        scheduledThreadPool.scheduleAtFixedRate(taskZwei, 10, 1000, TimeUnit.MILLISECONDS);
        scheduledThreadPool.shutdown();

        // cached thread pool
        //
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        Runnable taskDrei = new Runnable() {
            @Override
            public void run() {
                System.out.println("the task in cached thread pool is running.");
            }
        };
        cachedThreadPool.execute(taskDrei);
        cachedThreadPool.shutdown();

        // single thread executor
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        Runnable taskVier = new Runnable() {
            @Override
            public void run() {
                System.out.println("the task in single thread executor is running");
            }
        };
        singleThreadExecutor.execute(taskVier);
        singleThreadExecutor.shutdown();
    }
}

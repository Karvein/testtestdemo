package karvein.multipleThread;

import java.sql.SQLOutput;
import java.util.concurrent.*;

public class ThreadPoolTest {
    // thread pool test
    public static void main(String[] args) {
//        Executor
//        Thread
        // submit ( callable or runnable) 有返回值，runnable 时为null；不调用Future.get()时,会吞掉异常
        // execute ( runnable ) 无返回值;通过try，catch处理捕获异常

        // ThreadPoolExecutor(int corePoolSize,
        //                              int maximumPoolSize,
        //                              long keepAliveTime,
        //                              TimeUnit unit,
        //                              BlockingQueue<Runnable> workQueue)
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

        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap<>();

//        private static final int MAXIMUM_CAPACITY = 1 << 30
//          位移运算首先把1转为二进制数字 0000 0000 0000 0000 0000 0000 0000 0001
//          然后将上面的二进制数字向左移动30位后面补0得到 0100 0000 0000 0000 0000 0000 0000 0000


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

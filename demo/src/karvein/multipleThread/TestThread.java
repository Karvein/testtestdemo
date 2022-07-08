package karvein.multipleThread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class TestThread {
//    @Override
//    public void run() {
//        for (int i = 0; i < 20; i++) {
//            System.out.println(i);
//            if (i == 5) {
//                try {
//                    this.wait(1000);
//                    System.out.println("this is waiting.");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }


    @Test
    public synchronized void test() throws Exception {
        Runnable test1 = new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
                    for (int i = 0; i < 2; i++) {
                        try {
                            wait(1000);
                            System.out.println("A is waiting.");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        Thread test2 = new Thread() {
            @Override
            public void run() {
                synchronized (this) {
                    for (int i = 0; i < 2; i++) {
                        try {
                            wait(1000);
                            System.out.println("B is waiting.");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };

        test2.start();
        test1.run();
    }

    @Test
    public void test1() throws Exception{
        Future<String> futureTask = Executors.newSingleThreadExecutor().submit(new Callable() {
            @Override
            public String call() throws Exception {
                return "Joke";
            }
        });
        System.out.println(futureTask.get());
    }

    @Test
    public void test2() throws Exception{
        FutureTask<String> future = new FutureTask<String>(new Callable() {
            @Override
            public String call() throws Exception {
                return "Joke";
            }
        });
        Thread thread = new Thread(future);
        thread.start();
        System.out.println(future.get());
    }
}

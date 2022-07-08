package karvein.multipleThread;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {


    // 线程不安全，结果会是10000到20000的一个随机数
//    private static int count =0;
//    public void add(){
//        for (int i = 0; i < 10000; i++) {
//            count++;
//        }
//    }
    // 使用AtomicInteger保证原子性，实现多线程，并不加锁，保证安全的同时并缩减性能开销
    private static AtomicInteger count = new AtomicInteger(0);
    public void add(){
        for (int i = 0; i < 10000; i++) {
            count.getAndIncrement();
        }
    }



    public static void main(String[] args) {
        AtomicTest v = new AtomicTest();
        Thread t1 = new Thread(()->{
            v.add();
        });
        Thread t2 = new Thread(()->{
            v.add();
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}

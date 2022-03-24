package karvein.test01;

import java.util.concurrent.FutureTask;

public class Test {
    // test file
    public static void main(String[] args) throws Exception{
        // this is the test demo.
        System.out.println("This is the test demo.");

/*
            thread.start(),thread.join()
            线程执行顺序不以 thread.start() 在文件中的顺序执行，
            而是在该代码执行后，进入CPU资源调度,随机开始执行，如需按照指定顺序，可以使用 thread.join()
*/


        /* this part is testing thread */
        // first thread runs. Thread
        FirstThred firstThred = new FirstThred();
        firstThred.start();

        // second thread runs. Callable
        SecondThread secondThread = new SecondThread();
        FutureTask futureTask = new FutureTask(secondThread);
        new Thread(futureTask).start();
        System.out.println(futureTask.get());

        // third thread runs. Runnable
        ThirdTread thirdTread = new ThirdTread();
        Thread thread  = new Thread(thirdTread);
        thread.start();
        //new Thread(thirdTread).start();

        // fair reentrantlock
        new Thread("Thread A") {
            @Override
            public void run() {
                FairLock.testFairLock();
            }
        }.start();
        new Thread("Thread B") {
            @Override
            public void run() {
                FairLock.testFairLock();
            }
        }.start();
        // unfair reentrantlock
        new Thread("Thread C") {
            @Override
            public void run() {
                UnfairLock.testUnfairLock();
            }
        }.start();
        new Thread("Thread D") {
            @Override
            public void run() {
                UnfairLock.testUnfairLock();
            }
        }.start();


    }
}

package karvein.test01;

public class FirstThred extends Thread{
    // this is a thread class which extends class Thread.
    FirstThred() {
        // constructor
        System.out.println("The first thread is constructed.");
    }

    public void run() {
        System.out.println("The first thread is running.");
    }
}

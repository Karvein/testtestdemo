package karvein.multipleThread;

public class FirstThread extends Thread{
    // this is a thread class which extends class Thread.
    FirstThread() {
        // constructor
        System.out.println("The first thread is constructed.");
    }

    public void run() {
        System.out.println("The first thread is running.");
    }
}

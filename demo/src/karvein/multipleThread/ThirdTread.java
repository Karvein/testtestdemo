package karvein.multipleThread;

public class ThirdTread implements Runnable{
    // this is a thread which implements interface Runable.
    ThirdTread() {
        // constructor
        System.out.println("The third thread is constructed.");
    }

    @Override
    public void run() {
        System.out.println("The third thread is running.");
    }
}

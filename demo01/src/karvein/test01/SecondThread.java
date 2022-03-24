package karvein.test01;

import java.util.concurrent.Callable;

public class SecondThread implements Callable {
    // this is a tread which implements interface callable.
    SecondThread() {
        // constructor
        System.out.println("The second thread is contructed.");
    }

    @Override
    public String call() throws Exception {
        return "The second thread is running.";
    }
}

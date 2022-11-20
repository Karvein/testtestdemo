package karvein.multipleThread;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: karvein
 * @Date: 2022/10/13
 * @Description:
 */
public class SyncTest {

    public static void main(String[] args) {

        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap;
        Number number = new Number();

        new Thread(new Runnable() {
            @Override
            public void run() {
                number.getOne();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                number.getTwo();
            }
        }).start();
    }
}



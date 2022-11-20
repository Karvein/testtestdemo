package karvein.multipleThread;

/**
 * @Author: karvein
 * @Date: 2022/10/13
 * @Description:
 */
public class Number {
        public synchronized void getOne(){
            try {
                Thread.sleep(2000);
                System.out.println("one");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        public synchronized void getTwo(){
            System.out.println("two");
        }
    }


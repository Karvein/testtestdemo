package karvein.basicClass;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorTest {
    public static void main(String[] args) {
        String string = new String("JDK");
        if (string instanceof String) {
            System.out.println("true");
        }

        //数组的所有功能通过ArrayList容器都可以实现，只是实现的方式不同
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(12);
        arrayList.add(10);
        arrayList.add(35);
        arrayList.add(100);
        Iterator<Integer> iterator = arrayList.iterator();//获取容器的迭代器
        while(iterator.hasNext())
        {
            Integer value = iterator.next();//获取当前游标右边的元素，同时游标右移-->
            System.out.println(value);
        }
        System.out.println("通过ArrayList容器获取一个数组arr：");
        Object[] arr = arrayList.toArray();
        for(int i=0;i<arr.length;i++)
        {
            System.out.println(arr[i]);
        }

        // 队列Queue :BlockingQueue(阻塞队列)和Deque(双端队列)和BlockingDeque

    }
}




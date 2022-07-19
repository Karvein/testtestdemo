package karvein.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(2);
        l1.add(3);
        l1.add(4);
        for (int i :
             l1.toArray(new Integer[0])) {
            System.out.printf("%d",i);
        }

        Iterator it = l1.listIterator();
        while(it.hasNext()){
            int c = (int) it.next();
            System.out.println(c++);
        }

        l1.remove(0);
        for (int i :
                l1.toArray(new Integer[0])) {
            System.out.printf("%d",i);
        }

    }
}

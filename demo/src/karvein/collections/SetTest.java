package karvein.collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SetTest {

    public static void main(String[] args) {
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s3 = new HashSet<>();
        Set<Boolean> s2 = new TreeSet<>();
        s1.add(1);
        s1.add(2);
        s1.add(3);
        s3.add(2);
        System.out.println(s1);
        s2.add(true);
        s2.add(false);
        // Set 不可重复,无序集合
//        s2.add(true);
        Iterator it = s1.iterator();
        System.out.println(it.hasNext());
        if (s2.contains(true)) {
            System.out.println("Yes");
        }
        s1.retainAll(s3);
        System.out.println(s1);

    }
}

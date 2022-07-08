package karvein.basicClass;

import java.util.*;

public class CollectionTest {

    public static void main(String[] args) {
        // HashSet is based on HashMap where HashMap's key is the value of HashSet and the value of HashMap is PRESENT.

        // the implementation class of Map interface
        HashMap hashMap = new HashMap<>();
        Hashtable hashtable = new Hashtable<>();
        LinkedHashMap linkedHashMap = new LinkedHashMap<>();
        TreeMap treeMap = new TreeMap();


        // the implementation class of List interface
        ArrayList<String> arrayList = new ArrayList<>();
        LinkedList<String> linkedList = new LinkedList<>();

        // Vector
        Vector vector = new Vector();

        // Queue
        // poll() if Queue has no elements , the return value is NULL.
        // remove() if Queue has no elements , NullPointException will be thrown.

        // Iterator hasNext(),next(),remove()
        String s[] = {"hello","world"};
        List str = new ArrayList();
        for(int i = 0; i < 2; i++){
            str.add(s[i]);
        }
        Iterator e = str.iterator();
        while(e.hasNext()){
            System.out.println((String)e.next());
        }

            // ThreadLocal
    }
}

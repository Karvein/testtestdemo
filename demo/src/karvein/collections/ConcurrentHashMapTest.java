package karvein.collections;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {
    public static void main(String[] args) {
        ConcurrentHashMap map = new ConcurrentHashMap<>();
        Set<Map.Entry<String,String>>  set = map.entrySet();
    }
}

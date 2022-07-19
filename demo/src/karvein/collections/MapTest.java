package karvein.collections;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Map KEY-VALUE Iterator --> entrySet(),keySet(),values()
 * Efficiency: entrySet() > keySet(); entrySet() is recommended
 */
public class MapTest {
    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();

        map.put("a", "not null");
        map.put("b", "not null");
        map.put("c", "not null");
        map.put("d", "not null");
        map.put("e", "not null");
        map.put("f", "not null");

        System.out.println(LocalDateTime.now());
        // 一次就取出key,value
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String val = entry.getValue();
            System.out.printf("%s,%s\n", key, val);
        }
        System.out.println(LocalDateTime.now());
        // 取出key,再取出key对应的value
        for (String key : map.keySet()) {
            String val = map.get(key);
            System.out.printf("%s,%s\n", key, val);
        }
        System.out.println(LocalDateTime.now());
        Iterator<String> it3 = map.values().iterator();

    }
}

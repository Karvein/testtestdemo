package karvein.basicClass;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedHashMap;

public class BasicClass {
    @Test
    public void test(){
        final Double PI = 3.14;
        System.out.println(PI.getClass());
        System.out.println(PI);

        HashSet hashSet = new HashSet<>();
        LinkedHashMap linkedHashMap = new LinkedHashMap();

    }

}

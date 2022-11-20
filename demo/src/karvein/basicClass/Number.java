package karvein.basicClass;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

/**
 * @Author: karvein
 * @Date: 2022/9/15
 * @Description:
 */
public class Number {
    @Test
    public void test01() {
        BigDecimal d1 = new BigDecimal("20");
        BigDecimal d2 = new BigDecimal("22");
        System.out.println(d1.compareTo(d2));
    }
}

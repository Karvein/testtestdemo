package karvein.algorithem;

public class Test {
    @org.junit.jupiter.api.Test
    // 注解和类名同名，所以没有引入Test包的形式使用注解
    public void test() {
        int[] arr = {25, 36, 266, 33, 65, 88};
        for (int i: arr
             ) {
            System.out.println(i);
        }
    }
}

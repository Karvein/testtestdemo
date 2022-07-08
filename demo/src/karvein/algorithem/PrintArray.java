package karvein.algorithem;

public class PrintArray {
    public static void print(int[] array) {
        // 打印数组
        int flag = array.length;
        for (int i : array
        ) {
            System.out.print(i);
            if (--flag != 0) {
                System.out.print(',');
            }
        }
    }
}

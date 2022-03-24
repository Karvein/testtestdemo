package karvein.test06;

public class ShellSort {
    // 希尔排序
    public static int[] shellSort(int[] array) {
        int length = array.length;
        int tmp ;
        for (int step = length / 2; step >= 1; step /= 2) {
            for (int i = step; i < length; i++) {
                tmp = array[i];
                int j = i - step;
                while (j >= 0 && array[j] > tmp) {
                    array[j + step] = array[j];
                    j -= step;
                }
                array[j + step] = tmp;
            }
        }
        return array;
    }
}

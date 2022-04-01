package karvein.test06;

import org.junit.jupiter.api.Test;

public class ShellSort {

    public final static int[] intArray = {25,68,69,4,858,269,5,652,656,15262,25874,51,11,15,26,8064,33,1,9,0};

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

    @Test
    // 快速排序测试
    public void test04() {
        System.out.print("\nInital Array: ");
        int[] array;
        PrintArray.print(intArray);
        System.out.print("\nShellSorted Array: ");
        array = intArray;
        int[] shellSortTest = ShellSort.shellSort(array);
        PrintArray.print(shellSortTest);
    }
}

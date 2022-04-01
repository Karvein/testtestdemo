package karvein.test06;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class QuickSort {

    public final static int[] intArray = {25,68,69,4,858,269,5,652,656,15262,25874,51,11,15,26,8064,33,1,9,0};

    // 快速排序
    public static int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
        return arr;
    }

    public static int partition(int[] arr, int left, int right) {
        // 设定基准值（pivot）
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index++);
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
//        PrintArray.print(arr);
//        System.out.println();
    }

    @Test
    // 快速排序测试
    public void test03() {
        System.out.print("\nInital Array: ");
        int[] array;
        PrintArray.print(intArray);
        System.out.print("\nQuickSorted Array: ");
        array = intArray;
        int[] quickSortTest = QuickSort.quickSort(array,0,array.length-1);
        PrintArray.print(quickSortTest);
    }
}

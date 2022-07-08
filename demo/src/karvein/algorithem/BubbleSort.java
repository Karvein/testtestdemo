package karvein.algorithem;

import org.junit.jupiter.api.Test;

public class BubbleSort {

    public final static int[] intArray = {25,68,69,4,858,269,5,652,656,15262,25874,51,11,15,26,8064,33,1,9,0};

    // Bubble sort
    public static int[] bubbleSort(int[] intArray) {
        // 冒泡排序
        for (int i = 0; i < intArray.length-1; i++) {
            for (int j = 1; j < intArray.length - i; j++) {
                if (intArray[j-1] > intArray[j]) {
                    int mid = intArray[j-1];
                    intArray[j-1] = intArray[j];
                    intArray[j] = mid;
                }
            }
        }
        return intArray;
    }

    @Test
    // 冒泡排序测试
    public void test01(){
        System.out.print("\nInital Array: ");
        int[] array;
        PrintArray.print(intArray);
        System.out.print("\nBubbleSorted Array: ");
        long s1 = System.currentTimeMillis();
        array = intArray;
        int[] bubbleSortTest = BubbleSort.bubbleSort(array);
        long s2 = System.currentTimeMillis();
        PrintArray.print(bubbleSortTest);
    }

}

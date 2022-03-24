package karvein.test06;

public class BubbleSort {
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


}

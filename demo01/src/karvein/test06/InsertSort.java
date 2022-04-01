package karvein.test06;

import org.junit.jupiter.api.Test;

public class InsertSort {

    public final static int[] intArray = {25,68,69,4,858,269,5,652,656,15262,25874,51,11,15,26,8064,33,1,9,0};

    public static int[] insertSort(int[] array) {
        // 插入排序
        for (int i = 1; i < array.length; i++) {
            int insertInt = array[i];
            int index = i;
            // 短路与，index<0时，不执行后半段
            while (index > 0 && insertInt < array[index - 1]) {
                array[index] = array[index - 1];
                index--;
                if (index != i) {
                    array[index] = insertInt;
                }
            }
        }
        return array;
    }

    @Test
    // 插入排序测试
    public void test02() {
        System.out.print("\nInital Array: ");
        int[] array;
        PrintArray.print(intArray);
        System.out.print("\nInsertSorted Array: ");
        array = intArray;
        int[] insertSortTest = InsertSort.insertSort(array);
        PrintArray.print(insertSortTest);
    }
}

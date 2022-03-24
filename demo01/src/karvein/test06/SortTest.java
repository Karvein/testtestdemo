package karvein.test06;

import org.junit.jupiter.api.Test;
public class SortTest {
    public final static int[] intArray = {25,68,69,4,858,269,5,652,656,15262,25874,51,11,15,26,8064,33,1,9,0};
    public final static int[] sortedArray = {0,1,4,5,9,11,15,25,26,33,51,68,69,269,652,656,858,8064,15262,25874};

    @Test
    // 二分查找测试
    void test() {
        System.out.print("\nBiSearch Array: ");
        System.out.println(BiSearch.biSearch(sortedArray,25));
    }

    @Test
    // 冒泡排序测试
    public void test01(){
        System.out.print("\nInital Array: ");
        int[] array;
        PrintArray.print(intArray);
        System.out.print("\nBubbleSorted Array: ");
        array = intArray;
        int[] bubbleSortTest = BubbleSort.bubbleSort(array);
        PrintArray.print(bubbleSortTest);
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

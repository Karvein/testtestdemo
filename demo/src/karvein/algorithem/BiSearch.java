package karvein.algorithem;

import org.junit.jupiter.api.Test;

public class BiSearch {

    public final static int[] sortedArray = {0,1,4,5,9,11,15,25,26,33,51,68,69,269,652,656,858,8064,15262,25874};

    public static int biSearch(int[] array, int a) {
        // 二分查找
        int low = 0;
        int high = array.length-1;
        int mid ;
        while (low <= high) {
            mid = (int)Math.ceil((low + high) / 2);
            if (a == array[mid]) {
                return mid+1;
            } else if (a < array[mid]) {
                high--;
            } else if (a > array[mid]) {
                low++;
            }
        }
        return -1;
    }

    @Test
        // 二分查找测试
    void test() {
        System.out.print("\nBiSearch Array: ");
        System.out.println(BiSearch.biSearch(sortedArray,25));
    }
}

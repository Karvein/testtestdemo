package karvein.test06;

public class BiSearch {
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
}

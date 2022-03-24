package karvein.test06;

public class InsertSort {
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
}

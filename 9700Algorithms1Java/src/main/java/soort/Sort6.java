package soort;

import java.util.Arrays;

public class Sort6 {
    // поглощать - merge
    // O(n log n)
    // 16-23 ms

    //рекрусивное разделение
    //дополнительные масив

    //не зависит от размера чисел
    public static void main(String[] args) {
        int[] arr = Sort1.newArr(100000);
        Long time = System.currentTimeMillis();
        mergeSort(arr);
        System.out.println(System.currentTimeMillis() - time + " ms");
//        System.out.println(Arrays.toString(arr));
    }


    public static void mergeSort(int[] arr) {
        int[] tmp = new int[arr.length];
        mergeSortInt(arr, tmp, 0, arr.length - 1);
    }

    private static void mergeSortInt(int[] arr, int[] tmp, int lo, int hi) {
        if (hi <= lo) {
            return;
        }

        int mid = lo + (hi - lo) / 2;
        mergeSortInt(arr, tmp, lo, mid);//одна половинка
        mergeSortInt(arr, tmp, mid + 1, hi);//вторая половинка
        merge(arr, tmp, lo, mid, hi); //слияние
    }

    private static void merge(int[] arr, int[] tmp, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++) {
            tmp[k] = arr[k];
        }

        //слияние масивов
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            //проерка конка одной половинки
            if (i > mid) arr[k] = tmp[j++];
            else if (j > hi) arr[k] = tmp[i++];

            //перенос частей
            else if (tmp[j] < tmp[i]) arr[k] = tmp[j++];
            else arr[k] = tmp[i++];
        }
    }

}

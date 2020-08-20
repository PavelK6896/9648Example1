package soort;

import java.util.Arrays;

public class Sort5 {
    // вставка - insertion
    // O(n)-O(n*n)
    // 1174-1258 ms

    //не зависит от размера чисел
    public static void main(String[] args) {
        int[] arr = Sort1.newArr(100000);
        Long time = System.currentTimeMillis();
        insertionSort(arr);
        System.out.println(System.currentTimeMillis() - time + " ms");
//        System.out.println(Arrays.toString(arr));

    }


    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i;
            //если масив отсортирован то цикол невызовить
            //поменяет местами только неотсартированные
            while (j > 0 && arr[j - 1] > tmp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = tmp;
        }
    }


}

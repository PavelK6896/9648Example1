package soort;

import java.util.Arrays;

public class Sort3 {
    // выбор - selection
    // 5402-5589 ms
    // количество перестановок равно O(N), а количество сравнений O(n*n)

    //не зависит от размера чисел
    public static void main(String[] args) {
        int[] arr = Sort1.newArr(100000);
        Long time = System.currentTimeMillis();
        selectionSort(arr);
        System.out.println(System.currentTimeMillis() - time + " ms");
//        System.out.println(Arrays.toString(arr));
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIx]) {
                    minIx = j;
                }
            }
            Sort1.swap(arr, i, minIx);
        }

    }
}

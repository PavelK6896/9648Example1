package soort;

import java.util.Arrays;
import java.util.Random;

public class Sort1 {
    // пузырь - bubble
    // 14688-14750  ms

    // сложность o(n*n)
    //не зависит от размера чисел
    public static void main(String[] args) {
        int[] arr = newArr(100000);
        Long time = System.currentTimeMillis();
//        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println(System.currentTimeMillis() - time + " ms");
//        System.out.println(Arrays.toString(arr));
    }


    public static int[] newArr(int i) {
        Random random = new Random();
        int[] arr = new int[i];

        for (int j = 0; j < i ; j++) {
            arr[j] = random.nextInt(1000);
        }
        return arr;
    }

     public static void bubbleSort(int[] arr) {
        for (int i=arr.length-1; i > 0; i--) {
            for (int j=0; j<i; j++) {
                if (arr[j] > arr[j+1]) {
                    swap(arr, j, j+1);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

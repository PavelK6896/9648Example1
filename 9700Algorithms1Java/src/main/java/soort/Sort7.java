package soort;

import java.util.Arrays;

public class Sort7 {
    // быстрый - quick
    // O(n log n)
    // 12-33 ms

    //не зависит от размера чисел

    public static void main(String[] args) {
        int[] arr = Sort1.newArr(100000);
        int[] arr2 = Arrays.copyOf(arr, arr.length);

        Long time = System.currentTimeMillis();
        int low = 0;
        int high = arr.length - 1;
        quickSort(arr, low, high);
        System.out.println(System.currentTimeMillis() - time + " ms");
//        System.out.println(Arrays.toString(arr));
    }


    public static void quickSort(int[] array, int low, int high) {
        if (array.length == 0)
            return;//завершить выполнение если длина массива равна 0

        if (low >= high)
            return;//завершить выполнение если уже нечего делить

        // выбрать опорный элемент
        int middle = low + (high - low) / 2;
        int opora = array[middle];

        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (array[i] < opora) {
                i++;
            }

            while (array[j] > opora) {
                j--;
            }

            if (i <= j) {//меняем местами
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        // вызов рекурсии для сортировки левой и правой части
        if (low < j)
            quickSort(array, low, j);

        if (high > i)
            quickSort(array, i, high);
    }


}

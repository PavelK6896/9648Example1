package soort;

import java.util.Arrays;

public class Sort9 {
    // Counting Подсчет
    // O(n+k), где n — количество элементов, а k — максимальное значение элемента.
    // 2-3 ms при 1000

    //зависит от размера чисел при 100 000 3-6 ms
    //надо знать максимальное число

    public static void main(String[] args) {
        int[] arr = Sort1.newArr(100000);
        arr[0] = 100000; // максимальное число
        Long time = System.currentTimeMillis();
        int[] arr2 = countingSort(arr, 100000);
        System.out.println(System.currentTimeMillis() - time + " ms");
//        System.out.println(Arrays.toString(arr2));

    }

    public static int[] countingSort(int[] theArray, int maxValue) {
        // Массив со "счётчиками" размером от 0 до максимального значения
        int numCounts[] = new int[maxValue + 1];
        // В соответствующей ячейке (индекс = значение) увеличиваем счётчик
        for (int num : theArray) {
            numCounts[num]++;
        }
        // Подготавливаем массив для отсортированного результата
        int[] sortedArray = new int[theArray.length];
        int currentSortedIndex = 0;
        // идём по массиву со "счётчиками"
        for (int n = 0; n < numCounts.length; n++) {
            int count = numCounts[n];
            // идём по количеству значений
            for (int k = 0; k < count; k++) {
                sortedArray[currentSortedIndex] = n;
                currentSortedIndex++;
            }
        }
        return sortedArray;
    }

}

package soort;

import java.util.Arrays;

public class Sort8 {
    //Radix - Корень
    //9-16 ms при 1000

    //зависит от размера чисел при 100 000 14-21 ms

    public static void main(String[] args) {
        int[] arr = Sort1.newArr(100000);
        Long time = System.currentTimeMillis();
        radixSort(arr);
        System.out.println(System.currentTimeMillis() - time + " ms");
       // System.out.println(Arrays.toString(arr));
    }


    static int getMax(int arr[], int n) {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }


    // Функция для выполнения подсчета рода arr[] в соответствии с
    // цифра, представленная exp.
    static void countSort(int arr[], int n, int exp) {
        int output[] = new int[n]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);

        // Store count of occurrences in count[]
        for (i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Build the output array
        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }


        // contains sorted numbers according to curent digit
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }


    // Основная функция для этого сортирует arr[] размера n с помощью
    // Сортировка По Радиусу
    static void radixSort(int arr[]) {

        int n = arr.length;
        // Найти максимальное число, чтобы узнать количество цифр
        int m = getMax(arr, n);

        // Выполните сортировку подсчета для каждой цифры. Обратите внимание, что вместо этого
        // прохождения значный номер, эксп передается. 10 ехр^я
        // где i-текущий цифровой номер
        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }

}

package soort;

public class Sort2 {
    // Шелла Shell
    // 7659-7907 ms
    //не зависит от размера чисел
    public static void main(String[] args) {
        int[] arr = Sort1.newArr(100000);
        Long time = System.currentTimeMillis();
        shellSort(arr);
        System.out.println(System.currentTimeMillis() - time + " ms");
//        System.out.println(Arrays.toString(arr));

    }

    public static void shellSort(int[] array) {

        // Высчитываем промежуток между проверяемыми элементами
        int gap = array.length / 2;
        // Пока разница между элементами есть
        while (gap >= 1) {
            for (int right = 0; right < array.length; right++) {
                // Смещаем правый указатель, пока не сможем найти такой, что
                // между ним и элементом до него не будет нужного промежутка
                for (int c = right - gap; c >= 0; c -= gap) {
                    if (array[c] > array[c + gap]) {
                        Sort1.swap(array, c, c + gap);
                    }
                }
            }
            // Пересчитываем разрыв
            gap = gap / 2;
        }
    }
}

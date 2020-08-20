package soort;

public class Sort4 {
    // Shuttle Челнок
    // 1670-1878 ms
    //не зависит от размера чисел

    public static void main(String[] args) {
        int[] arr = Sort1.newArr(100000);
        Long time = System.currentTimeMillis();
        shuttleSort(arr);
        System.out.println(System.currentTimeMillis() - time + " ms");
//        System.out.println(Arrays.toString(arr));
    }

    public static void shuttleSort(int[] array ){
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                Sort1.swap(array, i, i - 1);
                for (int z = i - 1; (z - 1) >= 0; z--) {
                    if (array[z] < array[z - 1]) {
                        Sort1.swap(array, z, z - 1);
                    } else {
                        break;
                    }
                }
            }
        }

    }
}

package a1;

public class TwoMaxValues {
//    Есть массив целых чисел. Найти два наибольших значения в массиве
    public static void twoMaxValues(int[] arr) {
        if (arr.length < 2) {
            System.out.println("Invalid array length");
            return;
        }

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int i=0; i < arr.length; i++) {

            if (arr[i] > first) { // последовательность изменений для первого
                second = first;
                first = arr[i];

            } else if (arr[i] > second && arr[i] != first) { // для второго
                second = arr[i];
            }

            System.out.println("first " + first);
            System.out.println("second " + second);

        }
        if (second == Integer.MIN_VALUE) {
            System.out.println("No second max value");
        } else {
            System.out.printf("First max %d second max %d%n", first, second);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 0, -7, 10, 12, 4, 3, 70, 70, 2, -50, 34};
        int[] arr1 = {1, 1, 1, 1, 1, 1};
        twoMaxValues(arr);
    }
}

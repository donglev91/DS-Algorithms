package problem;

import java.util.Arrays;
import java.util.Collections;

public class ArrayPractice {
    public static Integer[] reverseArray(Integer[] arr) {
        Collections.reverse(Arrays.asList(arr));
        return arr;
    }

    //O(n*d)
    public static Integer[] leftRotate(int d, Integer[] arr) {
        int size = arr.length;
        Integer[] b = new Integer[size];
        int count = d;
        while(count-- > 0) {
            System.arraycopy(arr, 1, b, 0, size-1);
            b[size-1] = arr[0];
            System.arraycopy(b, 0, arr, 0, size);
        }

        return b;
    }

    //O(n)
    public static Integer[] leftRotateWithOptimization(int d, Integer[] arr) {
        int size = arr.length;
        Integer[] b = new Integer[size];
        for (int i = 0; i < size; i++) {
            b[i] = arr[Math.abs(i + d) % size];
        }

        return b;
    }

    public static Integer[] rightRotate(int d, Integer[] arr) {
        int size = arr.length;
        Integer[] b = new Integer[size];
        for (int i = 0; i < size; i++) {
            b[i] = arr[Math.abs(i + size - (d % size)) % size];
        }

        return b;
    }
}

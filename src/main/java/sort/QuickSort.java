package sort;

import java.util.Arrays;

public class QuickSort {

    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int index = partition(arr, low, high);
            quickSort(arr, low, index - 1);
            quickSort(arr, index + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        System.out.println(Arrays.toString(arr));
        System.out.println("pivot: "+ pivot);
        System.out.println("low: " + low + " high: " + high);

        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        System.out.println("return: " + (i+1));
        return i+1;
    }

    public static void main(String[] args)
    {
        int[] arr = {10, 7, 8, 9, 1, 5};
        int n = arr.length;

        QuickSort ob = new QuickSort();
        ob.quickSort(arr, 0, n-1);

        System.out.println(Arrays.toString(arr));
    }
}

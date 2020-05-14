package sort;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class QuickSort {
    /*7
    5 8 1 3 7 9 2*/

    /*2 3
    1 2 3
    7 8 9
    1 2 3 5 7 8 9*/

    private static List<Integer> quickSort(List<Integer> list) {
        if (list.size()  <= 1)
            return list;
        List<Integer> equalList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();
        List<Integer> leftList = new ArrayList<>();
        List<Integer> completedList = new ArrayList<>();

        int p = list.get(0);
        for (int x : list) {
            if (x > p)
                rightList.add(x);
            else if (x < p)
                leftList.add(x);
            equalList.add(x);
        }

        /*leftList = quickSort(leftList);
        rightList = quickSort(rightList);

        leftList.addAll(equalList);
        leftList.addAll(rightList);*/

        equalList.add(p);
        completedList.addAll(quickSort(leftList));
        completedList.addAll(equalList);
        completedList.addAll(quickSort(rightList));

        //printArray(completedList);
        String answer = Arrays.toString(completedList.toArray()).replace("[","").replace("]","").replace(",","");
        System.out.println(answer);

        return completedList;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> ar = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ar.add(in.nextInt());
        }
        quickSort(ar);
    }

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
}

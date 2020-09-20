package algorithm;

public class Sort {
    public static void mergesort(int[] arr) {
        final int length = arr.length;
        int[] helper = new int[length];
        mergesort(arr, helper, 0, length - 1);
    }

    private static void mergesort(int[] arr, int[] helper, int low, int high) {
        if (low >= high)
            return;
        int mid = (low + high)/2;
        mergesort(arr, helper, low, mid);//sort left
        mergesort(arr, helper, mid, high);//sort right
        merge(arr, helper, low, mid, high);
    }

    private static void merge(int[] arr, int[] helper, int low, int mid, int high) {
        System.arraycopy(arr, low, helper, low, high - low + 1);
        
    }
}

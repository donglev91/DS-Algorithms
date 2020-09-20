package algorithm;

import org.junit.Test;

public class SortTest {
    @Test
    public void mergeSort_ShouldReturnCorrectOrderArray() {
        int[] simpleArr = new int[] {2, 4, 6, 5};
        Sort.mergesort(simpleArr);
        assert isArrSorted(simpleArr);
    }

    private boolean isArrSorted(int[] sortedArr) {
        int length = sortedArr.length;
        for (int i = 0; i < length -1; i++) {
            if (sortedArr[i] > sortedArr[i+1])
                return false;
        }
        return true;
    }
}

package problem;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ArrayPracticeTest {
    @Test
    public void reverseArray_ShouldReturnCorrectReversedOne() {
        Integer[] t = ArrayPractice.reverseArray(new Integer[] {1, 2, 3, 4});
        Assert.assertEquals("[4, 3, 2, 1]", Arrays.toString(t));
    }

    @Test
    public void leftRotate_ShouldReturnCorrectArray() {
        Integer[] t = ArrayPractice.leftRotate(4, new Integer[]{1, 2, 3, 4, 5});
        Assert.assertEquals("[5, 1, 2, 3, 4]", Arrays.toString(t));
    }

    @Test
    public void leftRotateWithOptimization_ShouldReturnCorrectArray() {
        Integer[] t = ArrayPractice.leftRotateWithOptimization(4, new Integer[]{1, 2, 3, 4, 5});
        Assert.assertEquals("[5, 1, 2, 3, 4]", Arrays.toString(t));
    }

    @Test
    public void rightRotate_ShouldReturnCorrectArray() {
        Integer[] t = ArrayPractice.rightRotate(1, new Integer[]{1, 2, 3, 4, 5});
        Assert.assertEquals("[5, 1, 2, 3, 4]", Arrays.toString(t));
    }

}

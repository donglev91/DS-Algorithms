package problem;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayPracticeTest {
    @Test
    public void giveAString_ThenValidatingIfUnique_ShouldCorrect() {
        Assert.assertFalse(ArrayPractice.isUnique("abcdeaf"));
        Assert.assertTrue(ArrayPractice.isUnique("abcdef"));
    }

    @Test
    public void generateAllUniqueStringsFromArray_ShouldReturnCorrectOne() {
        String[] arr = new String[] {"ab", "ac", "ef", "gh"};
        ArrayList<String> generatedStrs = ArrayPractice.generateAllUniqueStrings(arr);
        Assert.assertEquals("[, gh, ef, ghef, ac, ghac, efac, ghefac, ab, ghab, efab, ghefab]", Arrays.toString(generatedStrs.toArray()));
    }

    @Test
    @Ignore
    public void findLargestConcatenatingStringsWithOptimize_ShouldReturnCorrectCount() {
        String[] arr = new String[] {"aa", "ab", "ac", "ef", "gh"};
        int max = ArrayPractice.findLargestConcatenatingWithOptimize(arr);
        Assert.assertEquals(6, max);
    }

    @Test
    public void findLargestConcatenatingStrings_ShouldReturnCorrectCount() {
        String[] arr = new String[] {"ab", "ac", "ef", "gh"};
        int max = ArrayPractice.findLargestConcatenating(arr);
        Assert.assertEquals(6, max);
    }

    @Test
    public void findLargestConcatenatingStrings_WithDuplicated_ShouldReturnCorrectCount() {
        String[] arr = new String[] {"ab", "ac", "ef", "chf"};
        int max = ArrayPractice.findLargestConcatenating(arr);
        Assert.assertEquals(5, max);
    }

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

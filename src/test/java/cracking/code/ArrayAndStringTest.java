package cracking.code;

import org.junit.Assert;
import org.junit.Test;

public class ArrayAndStringTest {
    @Test
    public void testUrlify_ShouldReturnCorrectStringAfterReplacement() {
        String result = ArrayAndString.urlify("Mr John Smith   ", 13);
        Assert.assertEquals("Mr%20John%20Smith", result);
    }

    @Test
    public void testPalindromePermutation_ShouldReturnCorrectAnswer() {
        Assert.assertFalse(ArrayAndString.isPalindromePermutation("acbc"));
        Assert.assertTrue(ArrayAndString.isPalindromePermutation("acbcb"));
        Assert.assertTrue(ArrayAndString.isPalindromePermutation("acbcba"));
        Assert.assertFalse(ArrayAndString.isPalindromePermutationWithBitVector("acbc"));
        Assert.assertTrue(ArrayAndString.isPalindromePermutationWithBitVector("acbcb"));
        Assert.assertTrue(ArrayAndString.isPalindromePermutationWithBitVector("acbcba"));
    }
}

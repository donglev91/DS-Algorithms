package problem;

import org.junit.Assert;
import org.junit.Test;

public class StringPracticeTest {
    @Test
    public void give2Strings_ThenValidateIfPermutated_ShouldReturnCorrectOne() {
        Assert.assertTrue(StringPractice.isPermuted("abcdea", "abcdea"));
        Assert.assertFalse(StringPractice.isPermuted("abcdea", "abcdfg"));
        Assert.assertFalse(StringPractice.isPermuted("abcda", "abcd"));
    }

    @Test
    public void give2Strings_ThenValidateIfPermutatedWithArray_ShouldReturnCorrectOne() {
        Assert.assertTrue(StringPractice.isPermutedWithArray("abcdea", "abcdea"));
        Assert.assertFalse(StringPractice.isPermutedWithArray("abcdea", "abcdfg"));
        Assert.assertFalse(StringPractice.isPermutedWithArray("abcda", "abcd"));
    }
}

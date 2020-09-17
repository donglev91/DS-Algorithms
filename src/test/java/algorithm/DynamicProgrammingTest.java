package algorithm;

import org.junit.Test;

public class DynamicProgrammingTest {
    @Test
    public void getFibonacciByRecursive_ShouldReturnCorrectOne() {
        assert DynamicProgramming.getFibonacciByRecursive(0) == 0;
        assert DynamicProgramming.getFibonacciByRecursive(1) == 1;
        assert DynamicProgramming.getFibonacciByRecursive(6) == 8;
    }

    @Test
    public void getFibonacciByBottomUp_ShouldReturnCorrectOne() {
        assert DynamicProgramming.getFibonacciByBottomUp(0) == 0;
        assert DynamicProgramming.getFibonacciByBottomUp(1) == 1;
        assert DynamicProgramming.getFibonacciByBottomUp(6) == 8;
        assert DynamicProgramming.getFibonacciByBottomUp(7) == 13;
    }

    @Test
    public void getFibonacciByTopDown_ShouldReturnCorrectOne() {
        assert DynamicProgramming.getFibonacciByTopDown(0) == 0;
        assert DynamicProgramming.getFibonacciByTopDown(1) == 1;
        assert DynamicProgramming.getFibonacciByTopDown(6) == 8;
        assert DynamicProgramming.getFibonacciByTopDown(7) == 13;
    }

    @Test
    public void getFibonacciByBottomUpWithSpaceOptimize_ShouldReturnCorrectOne() {
        assert DynamicProgramming.getFibonacciByBottomUpWithSpaceOptimize(0) == 0;
        assert DynamicProgramming.getFibonacciByBottomUpWithSpaceOptimize(1) == 1;
        assert DynamicProgramming.getFibonacciByBottomUpWithSpaceOptimize(6) == 8;
        assert DynamicProgramming.getFibonacciByBottomUpWithSpaceOptimize(7) == 13;
    }
}

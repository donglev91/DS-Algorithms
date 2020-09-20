package problem;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LambdaPracticeTest {
    @Test
    public void getRandomSubset_ShouldReturnCorrectOne() {
        List<Integer> all = new ArrayList<>();
        StringBuilder allStr = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            //List<Integer> randomSubSet = LambdaPractice.getRandomSubset(Arrays.asList(1, 2, 3));
            List<Integer> randomSubSet = LambdaPractice.getRandomSubsetByLambda(Arrays.asList(1, 2, 3));
            all.addAll(randomSubSet);
            allStr.append(randomSubSet);
        }
        assert all.contains(1);
        assert all.contains(2);
        assert all.contains(3);
        assert allStr.toString().contains("[]");
        assert allStr.toString().contains("[1]");
        assert allStr.toString().contains("[2]");
        assert allStr.toString().contains("[3]");
        assert allStr.toString().contains("[1, 3]");
        assert allStr.toString().contains("[2, 3]");
        assert allStr.toString().contains("[1, 2]");
        //assert allStr.toString().contains("[3, 3]");
        assert allStr.toString().contains("[1, 2, 3]");
    }
}

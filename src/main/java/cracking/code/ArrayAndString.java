package cracking.code;

import java.util.HashMap;
import java.util.Map;

public class ArrayAndString {
    static String urlify(String str, int trueLength) {
        return str.trim().replaceAll(" ", "%20");
    }

    static boolean isPalindromePermutation(String phrase) {
        return hasNoMoreThanOneOdd(buildCharFrequencyTable(phrase));
    }

    private static boolean hasNoMoreThanOneOdd(Map<Character, Integer> charFrequencyTable) {
        boolean foundOdd = false;
        for (int num : charFrequencyTable.values()) {
            if (num % 2 != 0) {
                if(foundOdd)
                    return false;
                foundOdd = true;
            }
        }

        return true;
    }

    private static Map<Character, Integer> buildCharFrequencyTable(String s) {
        Map<Character, Integer> charFrequencyTable = new HashMap<>();
        for (char c : s.toCharArray()) {
            charFrequencyTable.put(c, charFrequencyTable.getOrDefault(c, 0) + 1);
        }

        return charFrequencyTable;
    }

    public static boolean isPalindromePermutationWithBitVector(String phrase) {
        int bitVector = createBitVector(phrase);
        return bitVector == 0 || hasOnlyOneBitSet(bitVector);
    }

    private static int createBitVector(String phrase) {
        return 0;
    }

    private static boolean hasOnlyOneBitSet(int bitVector) {
        return false;
    }
}

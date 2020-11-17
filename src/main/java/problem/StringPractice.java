package problem;

import java.util.HashMap;
import java.util.Map;

public class StringPractice {

    //Ask for whitespace & case-sensitive
    public static boolean isPermuted(String str1, String str2) {
        if (str1.length() != str2.length())
            return false;

        Map<Character, Integer> str1CountMap = new HashMap<>();
        for (char c : str1.toCharArray()) {
            str1CountMap.put(c, str1CountMap.getOrDefault(c, 0) + 1);
        }

        for (char c : str2.toCharArray()) {
            if (!str1CountMap.containsKey(c) || str1CountMap.get(c) <= 0)
                return false;
            str1CountMap.put(c, str1CountMap.get(c) - 1);
        }

        return true;
    }

    //Assume ASCII with 128 char
    public static boolean isPermutedWithArray(String str1, String str2) {
        if (str1.length() != str2.length())
            return false;
        int[] counts = new int[128];
        for (char c : str1.toCharArray()) {
            counts[c]++;
        }

        for (char c : str2.toCharArray()) {
            if (counts[c] <= 0)
                return false;
            counts[c]--;
        }

        return true;
    }
}

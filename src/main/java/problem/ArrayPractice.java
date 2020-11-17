package problem;

import java.util.*;

public class ArrayPractice {
    public static Integer[] reverseArray(Integer[] arr) {
        Collections.reverse(Arrays.asList(arr));
        return arr;
    }

    //O(n*d)
    public static Integer[] leftRotate(int d, Integer[] arr) {
        int size = arr.length;
        Integer[] b = new Integer[size];
        int count = d;
        while(count-- > 0) {
            System.arraycopy(arr, 1, b, 0, size-1);
            b[size-1] = arr[0];
            System.arraycopy(b, 0, arr, 0, size);
        }

        return b;
    }

    //O(n)
    public static Integer[] leftRotateWithOptimization(int d, Integer[] arr) {
        int size = arr.length;
        Integer[] b = new Integer[size];
        for (int i = 0; i < size; i++) {
            b[i] = arr[Math.abs(i + d) % size];
        }

        return b;
    }

    public static Integer[] rightRotate(int d, Integer[] arr) {
        int size = arr.length;
        Integer[] b = new Integer[size];
        for (int i = 0; i < size; i++) {
            b[i] = arr[Math.abs(i + size - (d % size)) % size];
        }

        return b;
    }

    public static int findLargestConcatenating(String[] arr) {
        int length = arr.length;
        if (length == 1) {
            if (hasDuplicated(arr[0]))
                return 0;
            return length;
        }

        ArrayList<String> uniqueStrings = generateAllUniqueStrings(arr, 0);

        return getLargestString(uniqueStrings);
    }

    private static int getLargestString(ArrayList<String> uniqueStrings) {
        int max = 0;

        for (String s : uniqueStrings) {
            if (max < s.length())
                max = s.length();
        }

        return max;
    }

    public static ArrayList<String> generateAllUniqueStrings(String[] arr) {
        return generateAllUniqueStrings(arr, 0);
    }

    private static ArrayList<String> generateAllUniqueStrings(String[] arr, int i) {
        if (i == arr.length)
            return new ArrayList<>(Collections.singletonList("")) ;
        ArrayList<String> temp = generateAllUniqueStrings(arr, i + 1);
        ArrayList<String> ret = new ArrayList<>(temp);

        for (String s : temp) {
            String test = s + arr[i];
            if (!hasDuplicated(test))
                ret.add(test);
        }

        return ret;
    }

    public static int findLargestConcatenatingWithOptimize(String[] arr) {
        List<BitSet> bitSets = new ArrayList<>();
        bitSets.add(new BitSet(0));
        int result = 0;

        for (String s : arr) {
            BitSet bitSet = new BitSet(26);
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                bitSet.set(c - 'a');
            }

            if (bitSet.size() < s.length())
                continue;

            for (int i = bitSets.size()-1; i >= 0 ; i--) {
                BitSet bs = bitSets.get(i);
                if (bs.intersects(bitSet))
                    continue;
                bs.or(bitSet);
                bitSets.add(bs);

                result = Math.max(result, bs.size() + bitSet.size());
            }
        }

        return result;

    }

    /*public static int maxLength(String[] arr) {
        List<Integer> dp = new ArrayList<>();
        dp.add(0);
        int res = 0;
        for (String s : arr) {
            int a = 0, dup = 0;
            for (char c : s.toCharArray()) {
                dup |= a & (1 << (c - 'a'));
                a |= 1 << (c - 'a');
            }
            if (dup > 0)    continue;
            for (int i = dp.size() - 1; i >= 0; i--) {
                if ((dp.get(i) & a) > 0) continue;
                dp.add(dp.get(i) | a);
                res = Math.max(res, Integer.bitCount(dp.get(i) | a));
            }
        }
        return res;
    }*/

    private static boolean hasDuplicated(String s) {
        Set<Character> uniqueChars = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (uniqueChars.contains(c))
                return true;
            uniqueChars.add(c);
        }

        return false;
    }

    public static boolean isUnique(String s) {
        return isUniqueWithNoDS(s.toCharArray());
    }

    //Ask for ASCII or Unicode
    //O(n^2)
    //May sort then linear check -> O(nlog(n))
    private static boolean isUniqueWithNoDS(char[] chars) {
        final int length = chars.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i+1; j < length; j++) {
                if (chars[i] == chars[j])
                    return false;
            }
        }

        return true;
    }

}

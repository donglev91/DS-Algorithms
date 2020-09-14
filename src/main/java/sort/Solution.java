package sort;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the icecreamParlor function below.
    static int[] icecreamParlor(int m, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] r = new int[2];

        for (int i = 0; i < arr.length; i++) {
            Integer j = map.get(m-arr[i]);
            if (j != null) {
                System.out.println(i + " " + arr[i]);
                r[0] = j+1;
                r[1] = i+1;
            }
            map.put(arr[i], i);
        }

        return r;

    }

    private static final Scanner scanner = new Scanner(System.in);
/*2
4
5
1 4 5 3 2
4
4
2 2 4 3*/
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(scanner.nextLine());
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int m = Integer.parseInt(scanner.nextLine());
            //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int n = Integer.parseInt(scanner.nextLine());
            //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];
            String s = scanner.nextLine();
            String[] arrItems = s.split(" ");
            //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            int[] result = icecreamParlor(m, arr);

            for (int i = 0; i < result.length; i++) {
                bufferedWriter.write(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 4, 5, 7, 8, 10};
        System.out.println("\\");
        //System.out.println(Arrays.asList(a).contains(new Integer(1)));
        /*Stack<Integer> stack = new Stack<>();
        stack.pop();
        System.out.println(Integer.toBinaryString(7));
        System.out.println(Integer.toBinaryString(8));
        int mat[][] = {{1, 0, 0, 1}, 
                {0, 0, 1, 0}, 
                {0, 0, 0, 0}}; 
        //modifyMatrix(mat);
        //System.out.println(angleOfHourMinuteHands(3, 30));
        System.out.println(areBitSet(14));*/
        //findMaxProfit(new int[] { 100, 180, 260, 310, 40, 535, 695 });
        /*int A=50, B=100;
        //A = A^B;
        //System.out.println(A);
        B = (A^B)^B;
        System.out.println(B);
        A = A^B;
        System.out.println(A + " " + B);*/

        /*int[] a = new int[]{29261, 80254, 86934, 3704, 76338, 96698, 47885, 88475, 65211, 65976, 75238, 58566, 28684, 20348, 45383, 58620, 48360, 99801, 51885, 82661, 83066, 14311, 24803, 99267, 21541, 93195, 21194, 20775, 64817, 42323, 7640, 10429, 38928, 94573, 30484, 15265, 7622, 78368, 3739, 72833, 60696, 95328, 31398, 5731, 15676, 93132, 64351, 64035, 9284, 32587, 46695, 92349, 46897, 87850, 7968, 84789, 81044, 45513, 5563, 62212, 87836, 13202, 88993, 26763, 24127, 19476, 42028, 31748, 14196, 62118, 4580, 91243, 73798, 52329, 96973, 89473, 61812, 77675, 69859, 71095, 10261, 32905, 79796, 57157, 20754, 87763, 41945, 1798, 33275, 63859, 80361, 37462, 93413, 69353, 64225, 17539, 5181, 22604, 49286, 19376, 1073, 70218, 26970, 74870, 38898, 23942, 80694, 710, 1617, 50552, 88156, 11877, 83457, 67951, 85386, 4210, 55713, 43682, 22359, 5340, 23893, 2720, 59153, 17305, 88424, 23377, 51195, 93604, 62332, 480, 29331, 79757, 87049, 56300, 54626, 25947, 96594, 35320, 26656, 98210, 2223, 31163, 26438, 85679, 99114, 28175, 89889, 71178, 88209, 12247, 76517, 12101, 31318, 35670, 45757, 19742, 75398, 96951, 29697, 54082, 13782, 75380, 33838, 831, 31679, 4815, 26777, 28272, 56486, 69784, 42833, 58709, 946, 85623, 44387, 59, 13797, 50627, 87589, 2005, 62874, 80457, 14105, 94191, 32478, 59861, 30284, 7876, 73163, 59981, 78309, 86945, 35360, 28498, 87775, 83390, 49664, 30903, 28014, 6150, 686, 70846, 81210, 17983, 56468, 41948, 34394, 86617, 92575, 21982, 88621, 71800, 2438, 19078, 82342, 34916, 95290, 12626, 59143, 68453, 88958, 37451, 71749, 24317, 82300, 59523, 24058, 31963, 90425, 52071, 54464, 7462, 39269, 35673, 25444, 12088, 93973, 76189, 98704, 86547, 98170, 3677, 74698, 16960, 22754, 57039, 51875, 34395, 86016, 11017, 19199, 74973, 64819, 90947, 15641, 63470, 66821, 39699, 95432, 73597, 91769, 49896, 81058, 31037, 1920, 22854, 43125, 12244, 99042, 58180, 15142, 13564, 61856, 89839, 30523, 961, 63230, 98749, 51708, 49245, 26117, 70906, 24218, 90935, 78205, 39858, 54404, 45025, 95908, 66187, 34974, 87677, 32434, 32383, 35065, 50706, 55236, 78189, 62949, 70630, 36369, 78091, 545, 14576, 67929, 47419, 15537, 31158, 46167, 67244, 96755, 72283, 54501, 37324, 79569, 32705, 77181, 50324, 94082, 73089, 16510, 45407, 77117, 65296, 77789, 12181, 16001, 49377, 6722, 78949, 36358, 59442, 73391, 36902, 74017, 41320, 84320, 5905, 88829, 46838, 89500, 1935, 19120, 44001, 39258, 98688, 93057, 32791, 49011, 3490, 22231, 81872, 48896, 99347, 47167, 26685, 27879, 79519, 92413, 34600, 74820, 28770, 94041, 48210, 65671, 84410, 5881, 66342, 90314, 11062, 13179, 96166, 12996, 32298, 40166, 52254, 47337, 49574, 85044, 12699, 53064, 7274, 94570, 18311, 22972, 58089, 61347, 50850, 37607, 53759, 1802, 12426, 82528, 12194, 60636, 64550, 96603, 66516, 30891, 3269, 93929, 60421, 99434, 6925, 9070, 55951, 59178, 56406, 5524, 60573, 69104, 74939, 84198, 80026, 93250, 7169, 38114, 54596, 74370, 92072, 24707, 76171, 4498, 7234, 88365, 81485, 71784, 84967, 64352, 19026, 4587, 58281, 79447, 20372, 65205, 88516, 92674, 40734, 44922, 98198, 17658, 30377, 89488, 1855, 10402, 99089, 25375, 64867, 70037, 99744, 56939, 94743, 75915, 77788, 1976, 64279, 75624, 90111, 65597, 39975, 9137, 70184, 98255, 88583, 6907, 79811, 93450, 99581, 36896, 38371, 14130, 54553, 85100, 3617, 72759, 11853, 19058, 98133, 76720, 89094, 97877, 50010, 188, 73791, 44149, 18515, 54421, 19772, 8626, 20017, 59746, 17762, 6552, 74353, 22696, 13459, 70515, 16145, 29391, 7411, 70868, 43520, 78315, 55967, 63488, 51074, 84171, 82545, 49206, 60890, 87990, 63434, 27251, 4529, 53576};
        int k = 1;
        int[] queries = new int[]{8};
        System.out.println(Arrays.toString(circularArrayRotation(a, k, queries)));*/

        //kaprekarNumbers(1, 99999);
        //17 100 88 19 41 10 16 92
        //NO YES NO NO NO NO YES NO
        //YES YES YES YES YES YES YES NO
        //System.out.println(isSmartNumber(19));

    }

    static String gridChallenge(String[] grid) {
        for (String s : grid) {
            char[] ss = s.toCharArray();
            Arrays.sort(ss);
        }


    }

    static String[] bigSorting(String[] arr) {
        Arrays.sort(arr, (o1, o2) -> {
            if (o1.length() > o2.length())
                return 1;
            if (o1.length() < o2.length())
                return -1;
            return o1.compareTo(o2);
        });

        return arr;
    }

    //1.23 s
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    private static boolean areBitSet(int n) {
        if (n == 0)
            return false;

        while (n > 0) {
            if ((n & 1) == 0) {
                return false;
            }
            n = n >> 1;
        }

        return true;
    }

    private static void modifyMatrix(int[][] matrix) {
        int length = matrix.length;
        int[] rows = new int[length];
        int[] columns = new int[matrix[0].length];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    rows[i] = 1;
                    columns[j] = 1;
                }
            }
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (rows[i] == 1 || columns[j] == 1) {
                    matrix[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println("");
        }
    }

    private static double angleOfHourMinuteHands(int h, int m) {
        if (h < 0 || h > 12 || m < 0 || m > 60)
            System.out.println("wrong input");
        if (h == 12) {
            h = 0;
        }

        if (m == 60) {
            m = 0;
        }

        double diff = Math.abs((6 - 0.5) * (h * 60 + m)) % 360;
        return Math.min(360 - diff, diff);
    }

    static class Node {
        int data;
        Node next;

        public Node(int value) {
            data = value;
            next = null;
        }
    }

    private static boolean isLoop(Node node) {
        Set<Node> set = new HashSet<>();
        while (node != null) {
            if (set.contains(node))
                return true;
            set.add(node);
            node = node.next;
        }
        return false;
    }

    private static boolean isLoop2(Node node) {
        Node slowP = node, fastP = node;
        while (slowP != null && fastP != null && fastP.next != null) {
            slowP = slowP.next;
            fastP = fastP.next.next;
            if (slowP == fastP)
                return true;
        }

        return false;
    }

    //100, 180, 260, 310, 40, 535, 695
    int buy, sell;

    private static void findMaxProfit(int[] arr) {
        int length = arr.length;
        if (length < 2) {
            System.out.println("No");
        }

        int i = 0;
        List<Solution> ss = new ArrayList<>();
        while (i < length - 1) {
            Solution s = new Solution();
            //find local min
            while ((i < length - 1) && arr[i] > arr[i + 1]) {
                i++;
            }
            s.buy = i;
            i++;

            //find local max
            while ((i < length) && arr[i] > arr[i - 1]) {
                i++;
            }
            s.sell = i - 1;
            ss.add(s);
            //show result
        }
        if (ss.size() == 0) {
            System.out.println("No");
        } else
            for (Solution sss : ss) {
                System.out.println(sss.buy + " " + sss.sell);
            }
    }

    static Node head;

    private static void sortedInsert(Node newNode) {
        //case1: null
        Node current = head;
        if (current == null) {
            newNode.next = newNode;
            head = newNode;
            return;
        }
        //case2: new node before head
        if (current.data >= newNode.data) {
            //find last node
            while (current.next != head) {
                current = current.next;
            }
            current.next = newNode;
            newNode.next = head;
            head = newNode;
        }
        //case3: after head
        else {
            while (current.next != head && current.next.data < newNode.data) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    void sieveOfEratosthenes(int n) {
        // Create a boolean array "prime[0..n]" and initialize
        // all entries it as true. A value in prime[i] will
        // finally be false if i is Not a prime, else true.
        boolean[] prime = new boolean[n + 1];
        for (int i = 0; i < n; i++)
            prime[i] = true;
        for (int p = 2; p * p <= n; p++) {
            // If prime[p] is not changed, then it is a prime
            if (prime[p]) {
                // Update all multiples of p
                for (int i = p * 2; i <= n; i += p)
                    prime[i] = false;
            }
        }

        // Print all prime numbers
        for (int i = 2; i <= n; i++) {
            if (prime[i])
                System.out.print(i + " ");
        }
    }

    static int[] circularArrayRotation(int[] a, int k, int[] queries) {
        int n = a.length;
        final int q = queries.length;
        int[] arr = new int[q];
        int rot = k % n;
        for (int i = 0; i < q; i++) {
            int idx = queries[i];
            if (idx - rot >= 0)
                arr[i] = a[idx - rot];
            else
                arr[i] = a[idx - rot + n];
            //int newIndex = (queries[i]+ n -k% n)% n;
            //arr[i] = a[newIndex];
        }
        return arr;
    }

    static void kaprekarNumbers(int p, int q) {
        int count = 0;
        if (p == 1) {
            System.out.print("1 ");
            count++;
        }
        for (int x = p; x <= q; x++) {
            if (x <= 3)
                continue;
            int lengthX = String.valueOf(x).length();
            long temp = (long) x * x;
            int lengthT = String.valueOf(temp).length();
            int l = Integer.parseInt(String.valueOf(temp).substring(0, lengthT - lengthX));
            int r = Integer.parseInt(String.valueOf(temp).substring(lengthT - lengthX));
            if (x == l + r) {
                System.out.print(x + " ");
                count++;
            }
        }

        if (count == 0)
            System.out.println("INVALID RANGE");
    }

    //17 100 88 19 41 10 16 92
    //NO YES NO NO NO NO YES NO
    private static boolean isSmartNumber(int num) {
        int val = (int) Math.sqrt(num);
        System.out.println(val);
        if ((double) num / val == val)
            return true;
        return false;
    }

    public static String stringsXOR(String s, String t) {
        String res = new String("");
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t.charAt(i))
                res = "0";
            else
                res = "1";
        }

        return res;
    }
}
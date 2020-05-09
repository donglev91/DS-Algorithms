package com.donglev91;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Solutions {
    /*private Node root1;
    private Node root2;*/
    private static Node root;
    public static void main(String[] args) {
        //System.out.println(romanConvert(1904));
        //System.out.println(countBits(10,20));
        //int[] arr = new int[]{5, 1, 3, 4, 7};
        //System.out.println(sumTrip(arr, 12));
        //System.out.print(kangaroo(21, 6, 47, 3));
        /*Solutions tree = new Solutions();

        tree.root1 = new Node(1);
        tree.root1.left = new Node(2);
        tree.root1.right = new Node(3);
        tree.root1.left.left = new Node(4);
        tree.root1.left.right = new Node(5);

        tree.root2 = new Node(1);
        tree.root2.left = new Node(2);
        tree.root2.right = new Node(3);
        tree.root2.left.left = new Node(4);
        tree.root2.left.right = new Node(5);

        if (tree.isSame(tree.root1, tree.root2))
            System.out.println("Both trees are identical");
        else
            System.out.println("Trees are not identical");*/

        /*int A[] = { 1, 4, 45, 6, 10, -8 };
        int n = 16;
        if (existPair2(A, n))
            System.out.println("Array has two "
                    + "elements with given sum");
        else
            System.out.println("Array doesn't have "
                    + "two elements with given sum");*/
        //int arr[] = {1, 60, -10, 70, -80, 85};
        //minAbsSumPair(arr);
        /*int[][] arr1 = new int[2][3];
        for(int[] arr11 : arr1) {
            System.out.println(arr11[2]);
        }*/
        /*PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        queue.add(1);
        queue.add(200);
        queue.add(2);
        queue.offer(3);
        System.out.println(queue.poll());
        System.out.println(queue.peek());*/

        /*Solutions tree = new Solutions();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Preorder traversal of binary tree is ");
        tree.printPreOrderDFS(root);*/

        /*System.out.println("\nInorder traversal of binary tree is ");
        tree.printInorder();

        System.out.println("\nPostorder traversal of binary tree is ");
        tree.printPostorder();*/

        int[][] arr = new int[][]{
                {0, 1},
                {0, 2},
                {1, 3},
                {2, 3},
                {2, 5},
                {5, 6},
                {3, 4},
        };

        //findCriticalNodes2(7, arr);

    }

    /**
     * Converting Decimal Number lying between 1 to 3999 to Roman Numerals
     **/
    private static String romanConvert(int n) {
        if (n < 1 || n > 3999)
            return "Not Support";
        String[] thousands = new String[] {"", "M", "MM", "MMM"};
        String[] hundreds = new String[] {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = new String[] {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] ones = new String[] {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        return thousands[n/1000] + hundreds[n%1000/100] + tens[n%100/10] + ones[n%10];
    }

    /**
     * Count number of bits to be flipped to convert A to B
     * **/
    private static int countBits(int a, int b) {
        int n = a^b;
        int count = 0;
        while (n>0) {
            count += n&1;
            n = n >> 1;
        }

        return count;
    }

    /**
     * Count number of occurrences (or frequency) in a sorted array
     * **/
    private static int binarySearch(int[] arr, int l, int r, int x) {
        if (r < l) {
            return -1;
        }

        int mid = (l + r) / 2;
        if(arr[mid] == x) {
            return mid;
        }

        //find in left
        if (arr[mid] > x) {
            return binarySearch(arr, l, mid - 1, x);
        }

        //find in right
        return binarySearch(arr, mid + 1, r, x);

    }

    private static int countOccur(int[] arr, int n, int x) {
        int index = binarySearch(arr, 0, n - 1, x);
        if (index == -1) {
            return 0;
        }

        int count = 1;
        int left = index - 1;
        while (left >= 0 & arr[left] == x) {
            count++;
            left--;
        }

        int right = index + 1;
        while (right < n && arr[right] == x) {
            count++;
            right++;
        }

        return count;

    }

    /**
     * Count all possible groups of size 2 or 3 that have sum as multiple of 3
     * **/
    private static int findGroupOf23(int[] arr) {
        int result = 0;
        int c[] = new int[3];

        //hash all elements to 0, 1, 2: remainder when deviding 3
        for (int item : arr) {
            c[item%3]++;
        }

        //group of 2:
        //case 2 c[0]
        result += c[0]*(c[0]-1)/2;
        //case c[1] + c[2]
        result += c[1]*c[2];

        //group of 3:
        //case c[0]
        result += c[0]*(c[0]-1)*(c[0]-2)/6;
        //case c[1]
        result += c[1]*(c[1]-1)*(c[1]-2)/6;
        //case c[2]
        result += c[2]*(c[2]-1)*(c[2]-2)/6;
        //case c[0] + c[1] + c[2]
        result += c[0]*c[1]*c[2];
        return result;
    }

    /**
     * Count triplets with sum smaller than a given value
     * **/
    static int sumTrip (int[] arr, int sum) {
        Arrays.sort(arr);
        int count = 0;
        int n = arr.length;
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < n - 2; i++) {
            System.out.println(i);
            int j = i + 1;
            int k = n - 1;

            // Use Meet in the Middle concept
            while (j < k) {
                // move right corner to look for smaller values
                if (arr[i] + arr[j] + arr[k] >= sum) {
                    System.out.println("k: " + k);
                    k--;
                    // move left
                } else {
                    // This is important. For current i and j, there can be total k-j third elements.
                    count += k - j;
                    System.out.println("j: " + j);
                    j++;
                }
            }
        }

        return count;
    }

    /**
     * Count words that appear exactly two times in an array of words
     * **/
    static int countWords (String[] arr) {
        int count = 0;
        Map<String, Integer> map = new HashMap<>();

        for (String item : arr) {
            if (map.containsKey(item)) {
                int value = map.get(item);
                map.put(item, ++value);
            }
            else
                map.put(item, 1);
        }

        for(int value : map.values()) {
            if (value == 2)
                count++;
        }
        return count;
    }

    static String kangaroo(int x1, int v1, int x2, int v2) {
        if ((x1 > x2 && v1 > v2) || (x1 < x2 && v1 < v2)) {
            return "NO";
        }
        int t = 0;
        while ((x1 + t * v1) != (x2 + t * v2) && t <= 10000) {
            t++;
            System.out.println(t);
            if (t == 10000)
                return "NO";
        }
        return "YES";
    }

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        // Write your code here
        int f = lcm(a);
        int l = gcd(b);
        int count = 0;
        for (int i = f, j = 2; i <= l; i = f*j, j++) {
            if (l % i == 0)
                count++;
        }

        return count;

    }

    private static int lcm(List<Integer> arr) {
        int result = arr.get(0);
        for (int item : arr) {
            result = lcm(result, item);
        }
        return result;
    }

    private static int lcm(int a, int b) {
        return a * (b/gcd(a, b));
    }

    private static int gcd(List<Integer> arr) {
        int result = arr.get(0);
        for (int item : arr) {
            result = gcd(result, item);
        }
        return result;
    }

    private static int gcd(int a, int b) {
        while (b > 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    /**
     * XOR of all subarray XORs | Set 1
     * Given an array of integers, we need to get total XOR of all subarray XORs where subarray XOR can be obtained by XORing all elements of it.
     * **/
    private static int totalXOR(int[] arr) {
        int res = 0;
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            if ((i + 1) * (size - i) % 2 != 0) {
                res ^= arr[i];
            }
        }
        return res;
    }

    static class Node {
        int data;
        Node left, right, next;

        public Node(int value) {
            data = value;
            left = right = next = null;
        }
    }

    /**
     * 2 trees identical
     * **/
    boolean isSame(Node tree1, Node tree2) {
        if (tree1 == null && tree2 == null) {
            return true;
        }
        if (tree1 != null && tree2 != null)
            return (tree1.data == tree2.data) && isSame(tree1.left, tree2.left) && isSame(tree1.right, tree2.right);
        return false;
    }

    /**
     * Given an array A[] and a number x, check for pair in A[] with sum as x
     * **/
    private static boolean existPair(int[] arr, int x) {
        Arrays.sort(arr);
        int size = arr.length;
        int left = 0;
        int right = size - 1;

        //for (int i = 0; i < size; i++) {
        while(left < right) {
            int sum = arr[left] + arr[right];
            if (sum == x) {
                return true;
            }
            if (sum > x) {
                right--;
            } else {
                left++;
            }
        }
        //}
        return false;
    }

    private static boolean existPair2(int[] arr, int x) {
        Set<Integer> set = new HashSet<>();
        for (int item : arr) {
            if (set.contains(x - item)) {
                System.out.println(item + " " + (x - item));
                return true;
            }
            set.add(item);
        }
        return false;

    }

    private static void minAbsSumPair(int[] arr) {
        if (arr == null || arr.length < 2) {
            System.out.println("Not Found");
            return;
        }
        Arrays.sort(arr);
        int l = 0, r = arr.length - 1;
        int minSum = Integer.MAX_VALUE;
        int minL = 0, minR = 0;
        while (l < r) {
            int tempSum = arr[l] + arr[r];
            if (Math.abs(minSum) > Math.abs(tempSum)) {
                minSum = tempSum;
                minL = l;
                minR = r;
            }
            if(tempSum < 0) {
                l++;
            } else {
                r--;
            }
        }
        System.out.println("Min Sum: " + minSum + "; items: " + arr[minL] + " " + arr[minR]);
    }

    private static Node sortList(Node head) {
        Node prev = head;
        Node curr = head.next;
        while(curr != null) {
            if (curr.data < prev.data) {
                //detach curr from linked list
                prev.next = curr.next;
                //set to beginning
                curr.next = head;
                head = curr;
                //go on
                curr = prev;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        return head;
    }

    /**
     * Sort an array of 0s, 1s and 2s
     * **/
    private static void sortArr(int[] arr) {
        int length = arr.length;
        int lo = 0, mid = 0, hi = length -1, temp = 0;
        while(mid <= hi) {
            System.out.println(arr[mid]);
            switch(arr[mid]) {
                case 0:
                    temp = arr[lo];
                    arr[lo] = arr[mid];
                    arr[mid] = temp;
                    lo++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    temp = arr[mid];
                    arr[mid] = arr[hi];
                    arr[hi] = temp;
                    hi--;
                    break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Sort a stack using recursion
     * **/
    private static void sortStack(Stack<Integer> stack) {
        if(stack.isEmpty())
            return;
        //pop the top
        int temp = stack.pop();
        //sort remaining
        sortStack(stack);
        //insert top again
        sortedInsert(stack, temp);

    }

    private static void sortedInsert(Stack<Integer> stack, int element) {
        if (stack.isEmpty() || element > stack.peek()) {
            stack.push(element);
            return;
        }
        //if top greater, pop top, then sort and push again
        int temp = stack.pop();
        sortedInsert(stack, element);
        stack.push(temp);
    }

    /**
     * Sort a linked list of 0s, 1s and 2s
     * **/
    static Node head;
    private static Node sortList() {
        Node temp = head;
        int[] arr = new int[] {0,0,0};
        while (temp != null) {
            arr[temp.data%3]++;
            temp = temp.next;
        }
        int count = 0;
        temp = head;
        while (temp != null) {
            if (count < arr[0])
                temp.data = 0;
            else if (count < arr[0] + arr[1])
                temp.data = 1;
            else
                temp.data = 2;
            count++;
            temp = temp.next;
        }
        return head;
    }

    private static void sumMax(int[] arr, int d) {
        int length = arr.length;
        int max = d - 30;
        int min = Integer.MAX_VALUE;
        int s1 = 0, s2 = 0;
        //find 2 items that sum is maximum < (d - 30)

        Arrays.sort(arr); // O(nlogn)
        int l = 0, r = length-1;
        while (l < r) {
            int sum = arr[l] + arr[r];
            if (sum > max) {
                r--;
            } else {
                int temp = max - sum;
                if (temp < min) {
                    min = temp;
                    s1 = arr[l];
                    s2 = arr[r];
                }
                l++;
            }
        }
        System.out.println(s1 + " " + s2 + " " + (s1+s2));
    }

    /**
     * int maxTravelDist = 10000;
     *         List<List<Integer>> forwards = Arrays.asList(
     *             Arrays.asList(1,3000),
     *             Arrays.asList(2,5000),
     *             Arrays.asList(3,7000),
     *             Arrays.asList(4,10000));
     *         List<List<Integer>> backs = Arrays.asList(
     *             Arrays.asList(1,2000),
     *             Arrays.asList(2,3000),
     *             Arrays.asList(3,4000),
     *             Arrays.asList(4,5000));
     *         optimize(maxTravelDist, forwards, backs);
     * **/

    private static void optimize(int maxDistance, List<List<Integer>> forwards, List<List<Integer>> backs) {
        int f = -1, b = -1;
        List<List<Integer>> arr = new ArrayList<>();
        arr.add(Arrays.asList(1, 2));
        int[][] arr1 = new int[2][3];
        /*for(int[] arr11 : arr1) {
            System.out.println(arr11[0]);
        }*/

        int tempMax = forwards.get(0).get(1) + backs.get(0).get(1);
        for (List<Integer> forward : forwards) {
            for (List<Integer> back : backs) {
                int sum = forward.get(1) + back.get(1);
                if (sum > maxDistance) {
                    continue;
                }

                if(sum > tempMax) {
                    tempMax = sum;
                    f = forward.get(0);
                    b = back.get(0);
                }
            }
        }
        if (f == -1) {
            System.out.println("No");
            return;
        }
        System.out.print("[");
        int count = 0;
        for (List<Integer> forward : forwards) {
            for (List<Integer> back : backs) {
                int sum = forward.get(1) + back.get(1);
                if (sum == tempMax) {
                    if (count >= 1) {
                        System.out.print(", ");
                    }
                    System.out.print("[" + forward.get(0) + ", " + back.get(0) + "]");
                    count++;
                }
            }
        }
        System.out.print("]");
    }

    /**
     * Find Critical Nodes
     * Given an undirected graph, find out all the vertices when removed will make the graph disconnected. Initially the graph is connected.
     * **/
    private static List<Integer> findCriticalNodes(int nodeNum, int[][] graph) {
        List<Integer> cycles = new ArrayList<>();
        int[] forward = new int[nodeNum];
        int[] backward = new int[nodeNum];
        for(int[] edges : graph) { //O(n)
            forward[edges[0]]++;
            backward[edges[1]]++;
        }

        int startCycle = -1, endCycle = -1;
        for(int i = nodeNum - 1; i >= 0; i--) { //O(n)
            if (forward[i] == 2) {
                startCycle = i;
            }

            if (backward[i] == 2) {
                endCycle = i;
            }
        }

        if(startCycle < endCycle && startCycle != -1 && endCycle != -1) {
            cycles.add(startCycle);
            cycles.add(endCycle);
        }

        List<Integer> results = new ArrayList<>();
        for(int i = 0; i < nodeNum; i++) { // O(n)
            //ignore leaf
            if (forward[i] == 0) {
                continue;
            }
            //if have no cycle
            if (cycles.size() == 0) {
                results.add(i);
            } else { //have cycle
                //Not in cycle
                if (i < cycles.get(0) || i > cycles.get(1)) {
                    results.add(i);
                } else if (forward[i] + backward[i] > 2) { //there are more than 2 connections
                    results.add(i);
                }
            }
        }

        return results;
    }

    /**
     *
     * **/
    private static int fileMerge(int size, int[] arr) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int item : arr) {
            queue.add(item);
        }

        int sum = 0;
        while (queue.size() >= 2) {
            int first = queue.poll();
            int second = queue.poll();
            int temp = first + second;
            queue.add(temp);
            sum += temp;
        }

        return sum;
    }

    //root - left - right
    void printPreOrderDFS(Node node) {
        if (node == null)
            return;
        System.out.println(node.data);
        printPreOrderDFS(node.left);
        printPreOrderDFS(node.right);
    }
    //edges = [[0,1], [0, 2], [1, 3], [2, 3], [2, 5], [5, 6], [3,4]]
    static LinkedList<Integer>[] adj; //adj[0]: 1-2; adj[1]: 3
    private static int count = 0;
    static int DFS(int size, int v) {
        count=0;
        return dfsGraph(v, new boolean[size]);
    }

    static int dfsGraph(int v, boolean[] visited) {
        visited[v] = true;
        //System.out.println(v + " ");
        count++;
        for (int n : adj[v]) {
            if (!visited[n]) {
                dfsGraph(n, visited);
            }
        }
        return count;
    }

    /**
     * Find Critical Nodes
     * Given an undirected graph, find out all the vertices when removed will make the graph disconnected. Initially the graph is connected.
     * **/
    /*private static void findCriticalNodes2(int nodeNum, int[][] graph) {
        adj = new LinkedList[nodeNum];
        for (int i = 0; i< nodeNum; i++) {
            adj[i] = new LinkedList<>();
        }

        *//*for(int[] edges : graph) { //O(n)
            //System.out.println(edges[0]);
            adj[edges[0]].add(edges[1]);
        }*//*

        for(int i=0; i< nodeNum; i++) { //O(n)
            //System.out.println(edges[0]);
            for()
            adj[i].add(edges[1]);
        }

        for(int i = 0; i < nodeNum; i++) {
            System.out.println(adj[i]);
        }
        int count = DFS(nodeNum, graph[0][0]);
        System.out.println("count: " + count);

    }*/

    private static int ZOMBIE = 1;
    private static int[][] DIRECT = {{1,0},{0,1},{-1,0},{0,-1}};

    private static int minDays(List<List<Integer>> matrix) {
        int people = 0;
        Queue<Point> zombies = new ArrayDeque<>();
        //count people & add zombies
        for(int r = 0; r < matrix.size(); r++) {
            for (int c = 0; c < matrix.get(0).size(); c++) {
                if (matrix.get(r).get(c) == ZOMBIE)
                    zombies.add(new Point(r, c));
                else
                    people++;
            }
        }
        if (people == 0)
            return 0;
        //zombies move
        for (int day = 1; !zombies.isEmpty(); day++) {
            for (int size = zombies.size(); size > 0; size--) {
                Point zombie = zombies.poll();
                for (int[] direct : DIRECT) {
                    int r = zombie.r + direct[0];
                    int c = zombie.c + direct[1];
                    System.out.println("r: " + r + " --- c:" + c + " --- human: " + isHuman(r,c,matrix) + " +++ " + zombie.r + " " + zombie.c);

                    if(isHuman(r,c,matrix)) {
                        people--;
                        if(people == 0) {
                            return day;
                        }
                        matrix.get(r).set(c, ZOMBIE);
                        zombies.add(new Point(r,c));
                    }
                }
            }
        }
        return -1;
    }

    static boolean isHuman(int r, int c, List<List<Integer>> matrix) {
        return r>=0 && r<matrix.size() && c>=0 && c<matrix.get(0).size() && matrix.get(r).get(c) != ZOMBIE;
    }

    static class Point {
        int r,c;
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private static int maxScore(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];

        for (int r=0; r<matrix.length; r++) {
            for (int c=0; c<matrix[0].length; c++){
                if (r == 0 && c == 0) {
                    dp[r][c] = matrix[r][c];
                    continue;
                }
                int top = r > 0 ? dp[r-1][c] : Integer.MIN_VALUE;
                int left = c > 0 ? dp[r][c-1] : Integer.MIN_VALUE;
                dp[r][c] = Math.max(Math.min(top, matrix[r][c]), Math.min(left, matrix[r][c]));
            }
        }
        return dp[matrix.length-1][matrix[0].length-1];
    }
}

package algorithm;

public class DynamicProgramming {
    public static int getFibonacciByRecursive(int n) {
        if (n == 0 || n == 1) return n;
        return getFibonacciByRecursive(n-1) + getFibonacciByRecursive(n-2);
    }

    public static int getFibonacciByTopDown(int n) {
        return getFibonacci(n, new int[n+1]);
    }

    private static int getFibonacci(int n, int[] cacheArr) {
        if (n == 0 || n == 1) return n;
        if(cacheArr[n] == 0)
            cacheArr[n] = getFibonacci(n-1, cacheArr) + getFibonacci(n-2, cacheArr);
        return cacheArr[n];
    }

    public static int getFibonacciByBottomUp(int n) {
        if (n == 0 || n == 1) return n;
        int[] cacheArr = new int[n];
        cacheArr[0] = 0;
        cacheArr[1] = 1;
        for (int i = 2; i < cacheArr.length; i++) {
            cacheArr[i] = cacheArr[i-1] + cacheArr[i-2];
        }
        return cacheArr[n-1] + cacheArr[n-2];
    }

    public static int getFibonacciByBottomUpWithSpaceOptimize(int n) {
        if (n == 0 || n == 1) return n;
        int a = 0;
        int b = 1;
        for (int i = 2; i < n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return a + b;
    }
}

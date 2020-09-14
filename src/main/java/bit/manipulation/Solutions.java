package bit.manipulation;

public class Solutions {
    static int repeatedArithmeticShift(int x, int count) {
        for (int i = 0; i < count; i++) {
            x >>= 1; //Arithmetic shift by 1
            System.out.println(x + ": " + Integer.toBinaryString(x));
        }
        return x;
    }

    static int repeatedLogicalShift(int x, int count) {
        for (int i = 0; i < count; i++) {
            x >>>= 1; //Logical shift by 1
            System.out.println(x + ": " + Integer.toBinaryString(x));
        }
        return x;
    }

    public static void main(String[] args) {
        System.out.println(repeatedLogicalShift(-93242, 40));
    }
}

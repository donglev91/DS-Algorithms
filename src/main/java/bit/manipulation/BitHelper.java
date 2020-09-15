package bit.manipulation;

public class BitHelper {
    public static int getBit(int num, int i) {
        /**
         *  Shift all bits of num over i spots, then the bit to get will at the end
         *  1 -> ...00001 => masks out everything else
         * */
        return (num >> i) & 1; // Or (1<<i)&num
    }

    /**
     *  Shift all bits of 1 over i spots, then the bit to get will at the position we want to set
     *  1 -> ...00001 -> ....0001...
     * */
    public static int setBit(int num, int i) {
        return (1<<i)|num;
    }

    public static int clearBit(int num, int i) {
        return num&~(1<<i);
    }

    /**
     *  Create mask with 1 at ith bit, then subtract 1
     *  => result: sequence of 0s followed by i 1s
     * */
    public static int clearBitFromMostSignificantBitThroughI(int num, int i) {
        return num&((1<<i)-1);//(1<<i) --> ..00100.. --> -1: ..00011
    }

    /**
     *  Take sequence of all 1s(-1), then shift left by i+1
     *  => result: sequence of 1s followed by i 0 bits
     *  -1 -> 1111....; -1<<(i+1) -> 11..000..
     * */
    public static int clearBitFromIThrough0(int num, int i) {
        return num&(-1<<(i+1));
    }

    public static int updateBit(int num, int i, boolean bitIs1) {
        return clearBit(num, i) | (bitIs1?1:0)<<i;
    }
}

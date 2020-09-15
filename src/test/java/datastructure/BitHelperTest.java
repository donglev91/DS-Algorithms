package datastructure;

import bit.manipulation.BitHelper;
import org.junit.Test;

public class BitHelperTest {
    @Test
    public void getBit_ShouldReturnCorrespondingResult() {
        int num = 9; //1001
        assert BitHelper.getBit(num, 3) == 1;
    }

    @Test
    public void setBit_ShouldReturnCorrespondingResult() {
        int num = 9; //1001
        assert BitHelper.setBit(num, 2) == 13; //1101 ~ 13
    }

    @Test
    public void clearBit_ShouldReturnCorrespondingResult() {
        int num = 9; //1001
        assert BitHelper.clearBit(num, 0) == 8; ////1000 ~ 8
    }

    @Test
    public void clearBitFromMostSignificantBitThroughI_ShouldReturnCorrespondingResult() {
        int num = 13; //1101
        assert BitHelper.clearBitFromMostSignificantBitThroughI(num, 2) == 1; //0001 ~ 1
    }

    @Test
    public void clearBitFromIThrough0_ShouldReturnCorrespondingResult() {
        int num = 13; //1101
        assert BitHelper.clearBitFromIThrough0(num, 2) == 8; ////1000 ~ 8
    }

    @Test
    public void updateBit_ShouldReturnCorrespondingResult() {
        int num = 13; //1101
        assert BitHelper.updateBit(num, 2, false) == 9; ////1001 ~ 9
    }
}

package datastruture;

import java.util.Arrays;
//TODO: null in arraylist
public class ArrayList {
    private int size = 1;
    private final String[] EMPTY_LIST = new String[0];
    private int actualSize = 0;
    private String[] dataArr;

    public ArrayList() {
        dataArr = new String[size];
    }

    void add(String data) {
        doubleSize();
        dataArr[actualSize] = data;
        actualSize++;
    }

    private void doubleSize() {
        if (actualSize >= size) {
            size *= 2;
            copyData();
        }
    }

    private void copyData() {
        String[] bufferArr = dataArr;
        dataArr = new String[size];
        if (bufferArr.length >= 0)
            System.arraycopy(bufferArr, 0, dataArr, 0, bufferArr.length);
    }

    void append(String data, int index) {
        if (index > actualSize) {
            throw new ArrayIndexOutOfBoundsException(index);
        }

        String[] bufferArr = dataArr;
        doubleSize();

        dataArr[index] = data;
        actualSize++;

        if (index == actualSize) {
            return;
        }

        for (int i = index + 1; i < bufferArr.length; i++) {
            if(bufferArr[i-1] != null)
                dataArr[i] = bufferArr[i-1];
        }
    }

    String get(int index) {
        validateIfOutOfBound(index);
        return dataArr[index];
    }

    private void validateIfOutOfBound(int index) {
        if (index >= actualSize) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
    }

    void remove(int index) {
        validateIfOutOfBound(index);
        dataArr[index] = null;
        actualSize--;
    }

    boolean isEmpty() {
        return actualSize == 0;
    }

    void clear() {
        dataArr = EMPTY_LIST;
        actualSize = 0;
    }

    int size() {
        return actualSize;
    }

    public void print() {
        System.out.println("Array Data: " + Arrays.toString(dataArr));
    }
}

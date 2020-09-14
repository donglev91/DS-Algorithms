package datastruture;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

public class ArrayList {
    private int size = 1;
    private final String[] EMPTY_LIST = new String[0];
    private int actualSize = 0;
    private String[] dataArr = new String[size];

    void add(String data) {
        doubleSizeIfNeed();
        dataArr[actualSize] = data;
        actualSize++;
    }

    private void doubleSizeIfNeed() {
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

    void add(int index, String data) {
        if (index > actualSize) {
            throw new ArrayIndexOutOfBoundsException(index);
        }

        String[] bufferArr = new String[actualSize];
        System.arraycopy(dataArr, 0, bufferArr, 0, actualSize);
        doubleSizeIfNeed();

        dataArr[index] = data;
        actualSize++;

        if (index == actualSize) {
            return;
        }

        System.arraycopy(bufferArr, index, dataArr, index+1, actualSize - index - 1);
    }

    String get(int index) {
        validateIfOutOfBound(index);
        return dataArr[index];
    }

    void addAll(Collection<String> collection) {
        if (collection == null)
            throw new NullPointerException("input collection should not be null!");
        int time = calculateTimeToIncrease(collection.size());
        if (collection.size() + actualSize > size) {
            size *= Math.pow(2, time);
            copyData();
        }

        for (String col : collection) {
            dataArr[actualSize++] = col;
        }
    }

    void addAll(int index, Collection<String> collection) {
        if (collection == null)
            throw new NullPointerException("input collection should not be null!");
        if (index > actualSize) {
            throw new ArrayIndexOutOfBoundsException(index);
        }

        int time = calculateTimeToIncrease(collection.size());
        if (collection.size() + actualSize > size) {
            size *= Math.pow(2, time);
            copyData();
        }

    }

    void sort(Comparator<String> c) {
        Arrays.sort(dataArr, 0, actualSize, c);
    }

    int firstIndexOf(String data) {
        for (int i = 0; i < actualSize; i++)
            if (dataArr[i].equals(data))
                return i;
        return -1;
    }

    int lastIndexOf(String data) {
        for (int i = actualSize-1; i > 0; i--)
            if (dataArr[i].equals(data))
                return i;
        return -1;
    }

    private int calculateTimeToIncrease(int collectionSize) {
        return (int)Math.ceil(Math.log((collectionSize+actualSize)/actualSize)/Math.log(2));
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

    boolean contains(String data) {
        if (firstIndexOf(data) == -1)
            return false;
        return true;
    }

    void clear() {
        dataArr = EMPTY_LIST;
        actualSize = 0;
    }

    int size() {
        return actualSize;
    }

    public void print() {
        System.out.print("Array Data: ");
        for (int i = 0; i < actualSize; i++)
            System.out.print(dataArr[i] + " ,");
    }
}

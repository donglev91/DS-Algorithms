package datastructure;

import datastruture.ArrayList;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class ArrayListTest {
    @Test
    public void addThenGet_ShouldSuccess() {
        ArrayList list = new ArrayList();
        list.add("one");
        list.add("two");
        list.add(1,"one");
        list.addAll(new java.util.ArrayList<>(Arrays.asList("three", "four","three", "four","three", "four")));
        assert list.size() == 9;
        assert list.get(2).equals("two");
        assert list.firstIndexOf("one") == 0;
        assert list.lastIndexOf("one") == 1;
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        assert list.get(0).equals("four");
        list.sort((o1, o2) -> o2.compareTo(o1));
        list.print();
        assert list.get(0).equals("two");
        assert list.contains("four");
    }

    @Test
    public void addAllWithIndexThenGet_ShouldSuccess(){
        ArrayList list = new ArrayList();
        list.add("one");
        list.add("two");
        list.add("one");

        list.addAll(2, new java.util.ArrayList<>(Arrays.asList("a", "b")));
        assert list.get(2).equals("a");
    }

    @Test
    public void addThenClear_ShouldSuccess() {
        ArrayList list = new ArrayList();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("three");
        assert list.size() == 4;
        list.clear();
        assert list.size() == 0;
        assert list.isEmpty();
    }

    @Test
    public void addThenRemove_ShouldSuccess() {
        ArrayList list = new ArrayList();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("three");
        assert list.size() == 4;
        list.remove(1);//one; three,three
        assert list.size() == 3;
        assert list.get(1).equals("three");
    }

}
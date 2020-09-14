package datastruture;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) {
        testCustomArrayList();
    }

    private static void testCustomArrayList() {
        ArrayList list = new ArrayList();
        list.add("one");
        list.add("two");
        list.add("three");
        //list.add(null);
        list.add("one");
        list.add("seven");

        //list.print();
        //System.out.println(list.get(6));
        //list.clear();
        //System.out.println(list.length);
        //list.print();
        //System.out.println(list.isEmpty());
        //list.remove(1);
        //list.print();
        //list.add(0, "eight");
        String[] arr = new String[] {"1", "2","1", "2","1", "2","1", "2","1", "2",};
        list.addAll(Arrays.asList(arr));
        System.out.println(list.size());
        System.out.println(list.firstIndexOf("one"));
        list.sort((o1, o2) -> {
            return o2.compareTo(o1);
        });
        list.print();
        System.out.println(list.contains("one"));
        System.out.println(list.lastIndexOf("one"));
    }
}

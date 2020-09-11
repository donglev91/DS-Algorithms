package datastruture;

public class Solution {
    public static void main(String[] args) {
        testCustomArrayList();
    }

    private static void testCustomArrayList() {
        ArrayList list = new ArrayList();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("one");
        list.add("one");
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
        System.out.println(list.size());
        list.append("eight", 5);
        list.print();
    }
}

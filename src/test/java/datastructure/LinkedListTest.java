package datastructure;

import org.junit.Assert;
import org.junit.Test;

public class LinkedListTest {
    @Test
    public void clearLinkedList_TheListNodesShouldBeEmpty() {
        LinkedList<Integer> head = initLinkedList();
        head.clear();
        Assert.assertEquals("[]", head.getAll().toString());
    }

    @Test
    public void deleteFirstNode_TheListNodesShouldNotContainDeletedOne() {
        LinkedList<Integer> head = initLinkedList();
        head.delete(0);
        Assert.assertEquals("[2]", head.getAll().toString());
    }

    @Test
    public void deleteNode_TheListNodesShouldNotContainDeletedOne() {
        LinkedList<Integer> head = initLinkedList();
        head.delete(1);
        Assert.assertEquals("[1]", head.getAll().toString());
    }

    @Test
    public void insertToTheSpecificIndex_TheInsertionShouldInTheFirst() {
        LinkedList<Integer> head = initLinkedList();
        head.insert(3, 1);
        Assert.assertEquals("[1, 3, 2]", head.getAll().toString());
        head.insert(4, 1);
        Assert.assertEquals("[1, 4, 3, 2]", head.getAll().toString());
    }

    @Test
    public void insertToTheHead_TheInsertionShouldInTheFirst() {
        LinkedList<Integer> head = initLinkedList();
        head.appendFirst(3);
        Assert.assertEquals("[3, 1, 2]", head.getAll().toString());
    }

    @Test
    public void insertToTheTail_TheInsertionShouldInTheLast() {
        LinkedList<Integer> head = initLinkedList();
        head.append(3);
        Assert.assertEquals("[1, 2, 3]", head.getAll().toString());
    }

    @Test
    public void getAllElements_ShouldReturnAll() {
        LinkedList<Integer> head = initLinkedList();
        Assert.assertEquals("[1, 2]", head.getAll().toString());
    }

    @Test
    public void getTail_ShouldReturnLastNode() {
        LinkedList<Integer> linkedList = initLinkedList();
        Node<Integer> tail = linkedList.getTail();
        int tailData = tail.data;

        Assert.assertEquals(2, tailData);
    }

    private LinkedList<Integer> initLinkedList() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        Node<Integer> node = new Node<>(1);
        node.next = new Node<>(2);

        linkedList.head = node;

        return linkedList;
    }
}

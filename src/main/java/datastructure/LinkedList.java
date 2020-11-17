package datastructure;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class LinkedList<E extends Comparable<E>> {
    Node<E> head;

    void append(E data) {
        Map<Long, Long> map = new HashMap<>();
        map.put(1L, map.getOrDefault(1, 0L));

        Node<E> tail = getTail();
        tail.next = new Node<>(data);
    }

    void appendFirst(E data) {
        Node<E> temp = head;
        head = new Node<>(data);
        head.next = temp;
    }

    void clear() {
        head = null;
    }

    void delete(int index) {
        if (index == 0) {
            head = head.next;
            return;
        }
        Node<E> prevNode = getSpecificNode(index-1);
        prevNode.next = prevNode.next.next;
    }

    void insert(E data, int index) {
        Node<E> prevNode = getSpecificNode(index-1);
        Node<E> nextNode = prevNode.next;

        prevNode.next = new Node<>(data);
        prevNode.next.next = nextNode;
    }

    public Set<E> getAll() {
        Node<E> temp = head;
        Set<E> elements = new LinkedHashSet<>();
        while (temp != null) {
            elements.add(temp.data);
            temp = temp.next;
        }

        return elements;
    }

    public Node<E> getTail() {
        Node<E> tail = head;
        while (tail != null) {
            if (tail.next == null)
                break;
            tail = tail.next;
        }

        return tail;
    }

    private Node<E> getSpecificNode(int index) {
        Node<E> node = head;
        int count = 0;
        while (node != null) {
            if (count++ == index || node.next == null)
                break;
            node = node.next;
        }

        return node;
    }
}

class Node<E> {
    Node<E> next;
    E data;

    public Node(E data) {
        this.data = data;
    }
}

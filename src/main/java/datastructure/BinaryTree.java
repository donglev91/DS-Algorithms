package datastructure;

import java.util.*;

/**
 * Sorted Binary Tree
 * */
public class BinaryTree {
    BTNode root;

    public void add(int element) {
        root = addRecursive(root, element);
    }

    private BTNode addRecursive(BTNode currentNode, int element) {
        if (currentNode == null)
            return new BTNode(element);

        if (element < currentNode.value) {
            currentNode.left = addRecursive(currentNode.left, element);
        } else if (element > currentNode.value) {
            currentNode.right = addRecursive(currentNode.right, element);
        } else {
            return currentNode;
        }
        
        return currentNode;
    }

    public boolean containsNode(int element) {
        return containsNodeRecursive(root, element);
    }

    private boolean containsNodeRecursive(BTNode currentNode, int element) {
        if (currentNode == null)
            return false;
        if (currentNode.value == element)
            return true;
        return element < currentNode.value
                ? containsNodeRecursive(currentNode.left, element)
                : containsNodeRecursive(currentNode.right, element);
    }

    public void delete(int element) {
        root = deleteRecursive(root, element);
    }

    private BTNode deleteRecursive(BTNode currentNode, int element) {
        if (currentNode == null) {
            return null;
        }
        if(element == currentNode.value) {
            return deleteFoundNode(currentNode);
        }
        if (element < currentNode.value) {
            currentNode.left = deleteRecursive(currentNode.left, element);
            return currentNode;
        }
        currentNode.right = deleteRecursive(currentNode.right, element);

        return currentNode;
    }

    private BTNode deleteFoundNode(BTNode currentNode) {
        if (hasNoChild(currentNode)) {
            return null;
        } else if (hasOneChild(currentNode)) {
            if (currentNode.right == null)
                return currentNode.left;
            else
                return currentNode.right;
        } else {//has 2 child
            int smallestElement = findSmallestElement(currentNode.right);
            currentNode.value = smallestElement;
            currentNode.right = deleteRecursive(currentNode.right, smallestElement);
            return currentNode;
        }
    }

    private int findSmallestElement(BTNode currentNode) {
        return currentNode.left == null ? currentNode.value : findSmallestElement(currentNode.left);
    }

    private boolean hasOneChild(BTNode currentNode) {
        return currentNode.right == null || currentNode.left == null;
    }

    private boolean hasNoChild(BTNode currentNode) {
        return currentNode.right == null && currentNode.left == null;
    }

    private final Set<Integer> sortedElements = new LinkedHashSet<>();

    //DFS: left-root-right
    public Set<Integer> travelInOrder() {
        travelInOrder(root);
        return sortedElements;
    }

    private void travelInOrder(BTNode currentNode) {
        if (currentNode == null)
            return;
        travelInOrder(currentNode.left);
        sortedElements.add(currentNode.value);
        travelInOrder(currentNode.right);
    }

    //DFS: left-root-right
    public Set<Integer> travelInOrderWithoutRecursive() {
        travelInOrderWithoutRecursive(root);
        return sortedElements;
    }

    private void travelInOrderWithoutRecursive(BTNode currentNode) {
        if (currentNode == null)
            return;
        Stack<BTNode> nodeStack = new Stack<>();
        nodeStack.push(currentNode);
        while (!nodeStack.isEmpty()) {
            while (currentNode.left != null) {
                currentNode = currentNode.left;
                nodeStack.push(currentNode);
            }
            currentNode = nodeStack.pop();
            sortedElements.add(currentNode.value);
            if (currentNode.right != null) {
                currentNode = currentNode.right;
                nodeStack.push(currentNode);
            }
        }

    }

    //DFS: root-left-right
    public Set<Integer> travelPreOrder() {
        travelPreOrder(root);
        return sortedElements;
    }

    private void travelPreOrder(BTNode currentNode) {
        if (currentNode == null)
            return;
        sortedElements.add(currentNode.value);
        travelPreOrder(currentNode.left);
        travelPreOrder(currentNode.right);
    }

    //DFS: root-left-right
    public Set<Integer> travelPreOrderWithoutRecursive() {
        travelPreOrderWithoutRecursive(root);
        return sortedElements;
    }

    private void travelPreOrderWithoutRecursive(BTNode root) {
        if (root == null)
            return;
        Stack<BTNode> nodeStack = new Stack<>();
        nodeStack.add(root);
        while (!nodeStack.isEmpty()) {
            BTNode currentNode = nodeStack.pop();
            if (currentNode.right != null) {
                nodeStack.push(currentNode.right);
            }
            if (currentNode.left != null) {
                nodeStack.push(currentNode.left);
            }
            sortedElements.add(currentNode.value);
        }
    }

    //DFS: left-right-root
    public Set<Integer> travelPostOrder() {
        travelPostOrder(root);
        return sortedElements;
    }

    private void travelPostOrder(BTNode currentNode) {
        if (currentNode == null)
           return;
        travelPostOrder(currentNode.left);
        travelPostOrder(currentNode.right);
        sortedElements.add(currentNode.value);
    }

    //DFS: left-right-root
    public Set<Integer> travelPostOrderWithoutRecursive() {
        travelPostOrderWithoutRecursive(root);
        return sortedElements;
    }

    private void travelPostOrderWithoutRecursive(BTNode root) {
        if (root == null)
            return;
        BTNode current;
        BTNode prev = root;
        Stack<BTNode> nodeStack = new Stack<>();
        nodeStack.push(root);
        while (!nodeStack.isEmpty()) {
            current = nodeStack.peek();
            boolean hasChild = current.left != null || current.right != null;
            boolean isPrevLastChild = (prev == current.right) || (prev == current.left && current.right == null);

            if (!hasChild || isPrevLastChild) {
                current = nodeStack.pop();
                sortedElements.add(current.value);
                prev = current;
            } else {
                if (current.right != null)
                    nodeStack.push(current.right);
                if (current.left != null)
                    nodeStack.push(current.left);
            }
        }
    }

    public Set<Integer> travelLevelOrder() {
        travelLevelOrder(root);
        return sortedElements;
    }

    private void travelLevelOrder(BTNode root) {
        if (root == null)
            return;
        Queue<BTNode> nodeQueue = new ArrayDeque<>();
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            BTNode currentNode = nodeQueue.poll();
            if (!sortedElements.contains(currentNode.value)) {
                sortedElements.add(currentNode.value);
                if (currentNode.left != null)
                    nodeQueue.add(currentNode.left);
                if (currentNode.right != null)
                    nodeQueue.add(currentNode.right);
            }
        }
    }
}

class BTNode {
    int value;
    BTNode left;
    BTNode right;

    public BTNode(int value) {
        this.value = value;
        left = null;
        right = null;
    }
}

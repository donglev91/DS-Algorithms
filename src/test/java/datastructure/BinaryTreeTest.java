package datastructure;

import org.junit.Assert;
import org.junit.Test;

import java.util.Set;

public class BinaryTreeTest {
    public static final int SAMPLE_ELEMENT = 6;

    @Test
    public void add1Node_theTreeShouldFoundAddedOne() {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(SAMPLE_ELEMENT);
        Assert.assertTrue(binaryTree.containsNode(SAMPLE_ELEMENT));
    }

    @Test
    public void deleteNode_theTreeShouldNotFoundDeletedOne() {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(SAMPLE_ELEMENT);
        Assert.assertTrue(binaryTree.containsNode(SAMPLE_ELEMENT));
        binaryTree.delete(SAMPLE_ELEMENT);
        Assert.assertFalse(binaryTree.containsNode(SAMPLE_ELEMENT));
    }

    @Test
    public void dfs_travelInOrder_shouldReturnCorrectResult() {
        BinaryTree binaryTree = getSampleOrderedBinaryTree();
        Set<Integer> sortedElements = binaryTree.travelInOrder();
        Assert.assertEquals("[3, 4, 5, 6, 7, 8, 9]", sortedElements.toString());
    }

    @Test
    public void dfs_travelInOrderWithoutRecursive_shouldReturnCorrectResult() {
        BinaryTree binaryTree = getSampleOrderedBinaryTree();
        Set<Integer> sortedElements = binaryTree.travelInOrderWithoutRecursive();
        Assert.assertEquals("[3, 4, 5, 6, 7, 8, 9]", sortedElements.toString());
    }

    @Test
    public void dfs_travelPreOrder_shouldReturnCorrectResult() {
        BinaryTree binaryTree = getSampleOrderedBinaryTree();
        Set<Integer> sortedElements = binaryTree.travelPreOrder();
        Assert.assertEquals("[6, 4, 3, 5, 8, 7, 9]", sortedElements.toString());
    }

    @Test
    public void dfs_travelPreOrderWithoutRecursive_shouldReturnCorrectResult() {
        BinaryTree binaryTree = getSampleOrderedBinaryTree();
        Set<Integer> sortedElements = binaryTree.travelPreOrderWithoutRecursive();
        Assert.assertEquals("[6, 4, 3, 5, 8, 7, 9]", sortedElements.toString());
    }

    @Test
    public void dfs_travelPostOrder_shouldReturnCorrectResult() {
        BinaryTree binaryTree = getSampleOrderedBinaryTree();
        Set<Integer> sortedElements = binaryTree.travelPostOrder();
        Assert.assertEquals("[3, 5, 4, 7, 9, 8, 6]", sortedElements.toString());
    }

    @Test
    public void dfs_travelPostOrderWithoutRecursive_shouldReturnCorrectResult() {
        BinaryTree binaryTree = getSampleOrderedBinaryTree();
        Set<Integer> sortedElements = binaryTree.travelPostOrderWithoutRecursive();
        Assert.assertEquals("[3, 5, 4, 7, 9, 8, 6]", sortedElements.toString());
    }

    @Test
    public void bfs_travelLevelOrder_shouldReturnCorrectResult() {
        BinaryTree binaryTree = getSampleOrderedBinaryTree();
        Set<Integer> sortedElements = binaryTree.travelLevelOrder();
        Assert.assertEquals("[6, 4, 8, 3, 5, 7, 9]", sortedElements.toString());
    }

    @Test
    public void getBinaryTreeHeight_ShouldReturnNumberOfEdgesOfLongestPath() {
        BinaryTree binaryTree = getSampleOrderedBinaryTree();
        binaryTree.add(SAMPLE_ELEMENT+4);
        int height = binaryTree.getHeight();
        Assert.assertEquals(3, height);
    }

    /**
     *          6
     *       4      8
     *     3   5  7   9
     */
    private BinaryTree getSampleOrderedBinaryTree() {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(SAMPLE_ELEMENT);
        binaryTree.add(SAMPLE_ELEMENT-2);
        binaryTree.add(SAMPLE_ELEMENT+2);
        binaryTree.add(SAMPLE_ELEMENT-3);
        binaryTree.add(SAMPLE_ELEMENT-1);
        binaryTree.add(SAMPLE_ELEMENT+1);
        binaryTree.add(SAMPLE_ELEMENT+3);
        return binaryTree;
    }
}

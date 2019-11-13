package w3resource.basicPartOne;

// ##############################################################################
// #                                                                            #
// #    Program Purpose: Convert an sorted array to binary search tree.         #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                  #
// #    Creation Date  : November 13, 2019                                      #
// #                                                                            #
// ##############################################################################

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Exercise_146 {

    private static SecureRandom random = new SecureRandom();

    private static class TestBinaryTree<T extends Comparable<T>> {
        private class Node<T> {
            private T element;
            private Node<T> leftSubTree;
            private Node<T> rightSubTree;

            public Node(T element, Node<T> leftSubTree, Node<T> rightSubTree) {
                this.setElement(element);
                this.setLeftSubTree(leftSubTree);
                this.setRightSubTree(rightSubTree);
            }
            public T getElement() {
                return this.element;
            }
            public void setElement(T newElement) {
                this.element = newElement;
            }
            public void setLeftSubTree(Node<T> newLeftSubTree) {
                this.leftSubTree = newLeftSubTree;
            }
            public void setRightSubTree(Node<T> newRightSubTree) {
                this.rightSubTree = newRightSubTree;
            }
            public Node<T> getLeftSubTree() {
                return this.leftSubTree;
            }
            public Node<T> getRightSubTree() {
                return this.rightSubTree;
            }
        }
        private Node<T> rootNode;
        private int treeSize;

        public TestBinaryTree(T rootElement) {
            this.rootNode = new Node<>(rootElement, null, null);
            this.treeSize = 1;
        }

        public boolean insertInTree(T newElement) {
            int val = this.rootNode.getElement().compareTo(newElement);
            if (val == 0) {
                // same root element, we ignore it....
                return false;
            } else if (val < 0) {
                return this.insertIntoLeftSubTree(this.rootNode, newElement);
            } else {
                return this.insertIntoRightSubTree(this.rootNode, newElement);
            }
        }
        public boolean insertIntoLeftSubTree(Node<T> rootNode, T element) {
            int tempVal = rootNode.getElement().compareTo(element);
            if (tempVal == 0) {
                // same as root element, we cancel insertion...
                return false;
            } else if (tempVal < 0) {
                if (Objects.isNull(rootNode.getLeftSubTree())) {
                    Node<T> newNode = new Node<>(element, null, null);
                    rootNode.setLeftSubTree(newNode);
                    this.treeSize++;
                    return true;  // successful insertion.
                } else {
                    return this.insertIntoLeftSubTree(rootNode.getLeftSubTree(), element);
                }
            } else {
                // we check right subtree
                if (Objects.isNull(rootNode.getRightSubTree())) {
                    Node<T> newNode = new Node<>(element, null, null);
                    rootNode.setRightSubTree(newNode);
                    this.treeSize++;
                    return true; // successful insertion.
                } else {
                    return this.insertIntoLeftSubTree(rootNode.getRightSubTree(), element);
                }
            }
        }

        public boolean insertIntoRightSubTree(Node<T> rootNode, T element) {
            int tempVal = rootNode.getElement().compareTo(element);
            if (tempVal == 0) {
                // same as root element, we cancel insertion operation.
                return false;
            } else if (tempVal < 0) {
                if (Objects.isNull(rootNode.getLeftSubTree())) {
                    Node<T> newNode = new Node<>(element, null, null);
                    rootNode.setLeftSubTree(newNode);
                    this.treeSize++;
                    return true; // successful insertion.
                } else {
                    return this.insertIntoRightSubTree(rootNode.getLeftSubTree(), element);
                }
            } else {
                // we check right subtree
                if (Objects.isNull(rootNode.getRightSubTree())) {
                    Node<T> newNode = new Node<>(element, null, null);
                    rootNode.setRightSubTree(newNode);
                    this.treeSize++;
                    return true; // insertion successful
                } else {
                    return this.insertIntoRightSubTree(rootNode.getRightSubTree(), element);
                }
            }
        }

        public String traverseTree() {
            if (!this.isTreeEmpty()) {
                List<T> newDataStore = new LinkedList<>();
                innerTreeTraversal(this.rootNode, newDataStore);
                return newDataStore.toString();
            }
            return "[]";
        }

        private void innerTreeTraversal(Node<T> rootNode, List<T> dataStore) {
            if (!Objects.isNull(rootNode)) {
                this.innerTreeTraversal(rootNode.getLeftSubTree(), dataStore);
                this.innerTreeTraversal(rootNode.getRightSubTree(), dataStore);
                dataStore.add(rootNode.getElement());
            }
        }

        public boolean isTreeEmpty() {
            return Objects.isNull(this.rootNode.getLeftSubTree())
                    && Objects.isNull(this.rootNode.getRightSubTree());
        }

        public int getTreeSize() {
            return this.treeSize;
        }
    }

    public static int[] randomArrayGenerator(int low, int high, int size) {
        if (size < 0)
            throw new IllegalArgumentException("Invalid size of array. Must be > 0");
        int[] newData = new int[size];
        newData = IntStream.of(newData).map(val -> low + random.nextInt(high)).toArray();
        return newData;
    }

    public static void main(String[] args) {
        int[] randomArrayData = randomArrayGenerator(0, 10, 15);
        Arrays.sort(randomArrayData); // sort the data.
        System.out.printf("Sorted generated data: %s\n", Arrays.toString(randomArrayData));

        // Insert dat into our test binary tree.
        // First array item is always our root item.

        System.out.print("Loading data into tree .... ");
        TestBinaryTree<Integer> testBinaryTree = new TestBinaryTree<>(randomArrayData[0]);
        for (int i = 1; i < randomArrayData.length; i++)
            testBinaryTree.insertInTree(randomArrayData[i]);

        System.out.printf("[DONE] | [tree-size: %d]\n", testBinaryTree.getTreeSize());

        // Now let's do some traversal
        System.out.print("Traversing the data ... ");
        String traversedData = testBinaryTree.traverseTree();
        System.out.println("[DONE]");

        // Display traversed data
        System.out.printf("Traversed data is: %s\n", traversedData);

    }
}

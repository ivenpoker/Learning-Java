package w3resource.basicPartTwo;

// ############################################################################################
// #                                                                                          #
// #    Program Purpose: Determines if two binary trees are identical.                        #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                #
// #    Creation Date  : January 29, 2020                                                     #
// #                                                                                          #
// ############################################################################################

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Objects;

public class Exercise_182 {

    private static SecureRandom random = new SecureRandom();

    private static class TestBinaryTree<T extends Comparable<T>> {
        private class Node<T> {
            private T nodeData;
            private Node<T> leftSubTree;
            private Node<T> rightSubTree;

            public Node(T newNodeData, Node<T> newLeftSubTree, Node<T> newRightSubTree) {
                this.setNodeData(newNodeData);
                this.setLeftSubTree(newLeftSubTree);
                this.setRightSubTree(newRightSubTree);
            }
            public void setNodeData(T newNodeData) {
                this.nodeData = newNodeData;
            }
            public void setLeftSubTree(Node<T> newLeftSubTree) {
                this.leftSubTree = newLeftSubTree;
            }
            public void setRightSubTree(Node<T> newRightSubTree) {
                this.rightSubTree = newRightSubTree;
            }
            public T getNodeData() {
                return this.nodeData;
            }
            public Node<T> getLeftSubTree() {
                return this.leftSubTree;
            }
            public Node<T> getRightSubTree() {
                return this.rightSubTree;
            }
        }
        private Node<T> rootNode;

        public TestBinaryTree(T rootData) {
            this.rootNode = new Node<>(rootData, null, null);
        }
        public boolean add(T newData) {
            return this.addNewNode(this.rootNode, newData);
        }
        private boolean addNewNode(Node<T> rootNode, T newData) {
            Node<T> newTreeNode = new Node<>(newData, null, null);
            int compResults = newData.compareTo(rootNode.getNodeData());
            if (compResults ==  0) {

                // we don't add repeated nodes in the tree again.

            } else if (compResults < 0) {
                // we add to left subtree
                if (!Objects.isNull(rootNode.getLeftSubTree())) {
                    this.addNewNode(rootNode.getLeftSubTree(), newData);
                } else {
                    rootNode.setLeftSubTree(newTreeNode);
                    return true;
                }
            } else {
                // we add to right subtree
                if (!Objects.isNull(rootNode.getRightSubTree())) {
                    this.addNewNode(rootNode.getRightSubTree(), newData);
                } else {
                    rootNode.setRightSubTree(newTreeNode);
                    return true;
                }
            }
            return false;
        }

        public boolean isIdentical(TestBinaryTree<T> otherTree) {
            return this.coreIdenticalCheck(this.rootNode, otherTree.rootNode);
        }
        private boolean coreIdenticalCheck(Node<T> nodeA, Node<T> nodeB) {
            if (Objects.isNull(nodeA) && Objects.isNull(nodeB)) {
                return true;
            }
            if (Objects.isNull(nodeA) || Objects.isNull(nodeB)) {
                return false;
            }
            if (!nodeA.getNodeData().equals(nodeB.getNodeData())) {
                return false;
            }
            return coreIdenticalCheck(nodeA.getLeftSubTree(), nodeB.getLeftSubTree()) &&
                    coreIdenticalCheck(nodeA.getRightSubTree(), nodeB.getRightSubTree());
        }

        private StringBuilder preOrderTraversal(Node<T> rootNode, StringBuilder store) {
            if (Objects.isNull(rootNode)) {
                return store;
            }
            store.append(rootNode.getNodeData()).append(", ");
            preOrderTraversal(rootNode.getLeftSubTree(), store);
            preOrderTraversal(rootNode.getRightSubTree(), store);

            return store;
        }

        @Override
        public String toString() {
            StringBuilder results = this.preOrderTraversal(this.rootNode, new StringBuilder());
            return "[" + results.toString().trim().substring(0, results.length()-2) + "]";
        }
    }

    private static TestBinaryTree<Integer> createBinaryTree(int low, int high, int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Invalid specified size for new tree");
        }
        int[] newInts = new int[size];
        newInts = Arrays.stream(newInts).map(val -> low + random.nextInt(high)).toArray();
        TestBinaryTree<Integer> newTree = new TestBinaryTree<>(newInts[0]);

        for (int i = 1; i < newInts.length; i++) {
            newTree.add(newInts[i]);
        }
        return newTree;
    }

    private static TestBinaryTree<Integer> createBinaryTree(int[] someData) {
        if (someData.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }
        TestBinaryTree<Integer> newTree = new TestBinaryTree<>(someData[0]);
        for (int i = 1; i < someData.length; i++) {
            newTree.add(someData[i]);
        }
        return newTree;
    }

    public static void main(String[] args) {

        TestBinaryTree<Integer> tree_A = createBinaryTree(0, 100, 10);
        TestBinaryTree<Integer> tree_B = createBinaryTree(0, 100, 10);

        System.out.printf("Tree data A: %s\n", tree_A);
        System.out.printf("Tree data A: %s\n", tree_B);

        Arrays.stream(new int[50]).forEach(val -> System.out.printf("%c", '-'));
        System.out.println();

        System.out.printf("Does Tree A == Tree B: %s\n", tree_A.isIdentical(tree_B));

        Arrays.stream(new int[50]).forEach(val -> System.out.printf("%c", '-'));
        System.out.println();


        int[] tree_C_data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] tree_D_data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        TestBinaryTree<Integer> tree_C = createBinaryTree(tree_C_data);
        TestBinaryTree<Integer> tree_D = createBinaryTree(tree_D_data);

        System.out.printf("Tree data C: %s\n", tree_C);
        System.out.printf("Tree data D: %s\n", tree_D);

        Arrays.stream(new int[50]).forEach(val -> System.out.printf("%c", '-'));
        System.out.println();

        System.out.printf("Does Tree C == Tree D: %s\n", tree_C.isIdentical(tree_D));


    }
}

package w3resource.basicPartTwo;

// ############################################################################################
// #                                                                                          #
// #    Program Purpose: Finds the length of the longest consecutive sequence path of a given #
// #                     binary tree.                                                         #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                #
// #    Creation Date  : January 29, 2020                                                     #
// #                                                                                          #
// ############################################################################################

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Objects;

public class Exercise_184 {

    private static SecureRandom random = new SecureRandom() ;

    private static class TestBinaryTree<T extends Comparable<T>> {

        private class Node<T> {
            private T nodeData;
            private Node<T> leftSubTree;
            private Node<T> rightSubTree;
            private Node<T> linkToParent;

            public Node(T newNodeData, Node<T> leftSubTree, Node<T> rightSubTree, Node<T> linkToParent) {
                this.setNodeData(newNodeData);
                this.setLeftSubTree(leftSubTree);
                this.setRightSubTree(rightSubTree);
                this.setLinkToParent(linkToParent);
            }
            public void setNodeData(T newNodeData) {
                this.nodeData = newNodeData;
            }
            public void setLeftSubTree(Node<T> newLeftSubTree) {
                this.leftSubTree = newLeftSubTree;
            }
            public void setLinkToParent(Node<T> newLinkToParent) {
                this.linkToParent = newLinkToParent;
            }
            public void setRightSubTree(Node<T> newRightSubTree) {
                this.rightSubTree = newRightSubTree;
            }
            public T getNodeData() {
                return this.nodeData;
            }
            public Node<T> getRightSubTree() {
                return this.rightSubTree;
            }
            public Node<T> getLeftSubTree() {
                return this.leftSubTree;
            }
            public Node<T> getLinkToParent() {
                return this.linkToParent;
            }

        }
        private Node<T> rootNode;

        public TestBinaryTree(T rootData) {
            this.rootNode = new Node<>(rootData, null, null, null);
        }

        public boolean add(T newData) {
            return this.addNode(this.rootNode, newData);
        }
        private boolean addNode(Node<T> rootNode, T newData) {
            Node<T> newNode = new Node<>(newData, null, null, null);
            int compResults = newData.compareTo(rootNode.getNodeData());
            if (compResults == 0) {
                // Trying to insert same data into data structure
                // not allowed, we return 'false'
                return false;

            } else if (compResults < 0) {
                if (!Objects.isNull(rootNode.getLeftSubTree())) {
                    return this.addNode(rootNode.getLeftSubTree(), newData);
                } else {
                    rootNode.setLeftSubTree(newNode);
                    newNode.setLinkToParent(rootNode);
                    return true;
                }
            } else {
                if (!Objects.isNull(rootNode.getRightSubTree())) {
                    return this.addNode(rootNode.getRightSubTree(), newData);
                } else {
                    rootNode.setRightSubTree(newNode);
                    newNode.setLinkToParent(rootNode);
                    return true;
                }
            }
        }

        public int findLongestConsecutivePathFromRoot() {
           return this.longestConsecutive(this.rootNode);
        }

        private int longestConsecutive(Node<T> someNode) {
            if (Objects.isNull(someNode)) {
                return 0;
            }
            int result = diffN(someNode, 1) + diffN(someNode, -1);
            return Math.max(result, Math.max(this.longestConsecutive(someNode.getLeftSubTree()),
                    this.longestConsecutive(someNode.getRightSubTree())));
        }

        private int diffN(Node<T> someNode, int diff) {
            if (Objects.isNull(someNode)) {
                return 0;
            }
            int leftDepth = 0;
            int rightDepth = 0;

            // CHECK NODE

            if (!Objects.isNull(someNode.getLeftSubTree()) &&
                    ((Integer) someNode.getNodeData() - (Integer) someNode.getLeftSubTree().getNodeData()) == diff) {
                leftDepth = this.diffN(someNode.getLeftSubTree(), diff) + 1;
            }
            if (!Objects.isNull(someNode.getRightSubTree()) &&
                    ((Integer) someNode.getNodeData() - (Integer) someNode.getRightSubTree().getNodeData()) == diff) {
                rightDepth = this.diffN(someNode.getRightSubTree(), diff) + 1;
            }
            return Math.max(leftDepth, rightDepth);
        }

        private StringBuilder preOrderTraversal(Node<T> rootNode, StringBuilder store) {
            if (Objects.isNull(rootNode)) {
                return store;
            }
            store.append(String.format("%s, ", rootNode.getNodeData()));
            preOrderTraversal(rootNode.getLeftSubTree(), store);
            preOrderTraversal(rootNode.getRightSubTree(), store);

            return store;
        }

        @Override
        public String toString() {
            String storeData = this.preOrderTraversal(this.rootNode, new StringBuilder()).toString().trim();
            return "["  + storeData.substring(0, storeData.length()-1) + "]";
        }
    }

    private static TestBinaryTree<Integer> createTreeWithData(int low, int high, int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Invalid specified size for tree");
        }
        TestBinaryTree<Integer> newTreeData = new TestBinaryTree<>(low + random.nextInt(high));
        Arrays.stream(new int[size-1]).forEach((val) -> newTreeData.add(low + random.nextInt(high)));
        return newTreeData;
    }

    public static void main(String[] args) {

        TestBinaryTree<Integer> tree_A = createTreeWithData(0, 100, 15);
        TestBinaryTree<Integer> tree_B = createTreeWithData(0, 100, 15);

        System.out.printf("Tree A data: %s\n", tree_A);
        System.out.printf("Tree B data: %s\n", tree_B);

        Arrays.stream(new int[20]).forEach((val) -> System.out.print("-"));
        System.out.println();

        System.out.printf("Tree A longest path from root: %d\n", tree_A.findLongestConsecutivePathFromRoot());
        System.out.printf("Tree B longest path from root: %d\n", tree_B.findLongestConsecutivePathFromRoot());


    }
}

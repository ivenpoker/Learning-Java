package w3resource.basicPartOne;

// ####################################################################################
// #                                                                                  #
// #    Program Purpose: Tests if a binary tree is a subtree of another binary tree.  #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                        #
// #    Creation Date  : December 11, 2019                                            #
// #                                                                                  #
// ####################################################################################

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;
import java.util.stream.IntStream;

public class Exercise_150 {

    private static SecureRandom random = new SecureRandom();

    public static class TestBinaryTree<T extends Comparable<T>> {

        private static class Node<T> {
            private T element;
            private Node<T> leftSubTree;
            private Node<T> rightSubTree;

            public Node(T element, Node<T> leftSubTree, Node<T> rightSubTree) {
                this.setElement(element);
                this.setLeftSubTree(leftSubTree);
                this.setRightSubTree(rightSubTree);
            }
            public void setElement(T newElement) {
                this.element = newElement;
            }
            public void setLeftSubTree(Node<T> newSubTree) {
                this.leftSubTree = newSubTree;
            }
            public void setRightSubTree(Node<T> newSubTree) {
                this.rightSubTree = newSubTree;
            }
            public T getElement() {
                return this.element;
            }
            public Node<T> getLeftSubTree() {
                return this.leftSubTree;
            }
            public Node<T> getRightSubTree() {
                return this.rightSubTree;
            }
        }
        private Node<T> rootNode;

        public TestBinaryTree(T rootNodeElement) {
            this.rootNode = new Node<>(rootNodeElement, null, null);
        }

        private boolean add(T newElement) {
            return this.insertElement(this.rootNode, newElement);
        }

        private boolean insertElement(Node<T> rootNode, T newElement) {
            int tempA = rootNode.getElement().compareTo(newElement);
            if (tempA <= 0) {       // insert element in tree who is 'less than or equal to' root data
                if (Objects.isNull(rootNode.getLeftSubTree())) {
                    Node<T> newNode = new Node<>(newElement, null, null);
                    rootNode.setLeftSubTree(newNode);
                } else {
                    this.insertElement(rootNode.getLeftSubTree(), newElement);
                }
            } else {
                if (Objects.isNull(rootNode.getRightSubTree())) {
                    Node<T> newNode = new Node<>(newElement, null, null);
                    rootNode.setRightSubTree(newNode);
                } else {
                    this.insertElement(rootNode.getRightSubTree(), newElement);
                }
            }
            return true;
        }

        private LinkedList<T> listData(Node<T> rootNode, LinkedList<T> mainList) {
            if (!Objects.isNull(rootNode)) {
                mainList.add(rootNode.getElement());
                listData(rootNode.getLeftSubTree(), mainList);
                listData(rootNode.getRightSubTree(), mainList);
            }
            return mainList;
        }



        public static <T extends Comparable<T>> boolean isSubTree(TestBinaryTree<T> treeA, TestBinaryTree<T> treeB) {
            return realSubTreeCheck(treeA.rootNode, treeB.rootNode);
        }

        private static <T extends Comparable<T>> boolean isSame(Node<T> nodeA, Node<T> nodeB) {
            if (Objects.isNull(nodeA) || Objects.isNull(nodeB)) {
                return nodeA == nodeB;
            } else if (nodeA.getElement().compareTo(nodeB.getElement()) != 0) {
                return false;
            } else {
                return isSame(nodeA.getLeftSubTree(), nodeB.getLeftSubTree()) &&
                        isSame(nodeA.getRightSubTree(), nodeB.getRightSubTree());
            }
        }

        private static <T extends Comparable<T>> boolean realSubTreeCheck(Node<T> nodeA, Node<T> nodeB) {
            if (Objects.isNull(nodeB)) return true;
            if (Objects.isNull(nodeA)) return false;
            if (isSame(nodeA ,nodeB)) return true;
            if (realSubTreeCheck(nodeA.getLeftSubTree(), nodeB) || realSubTreeCheck(nodeA.getRightSubTree(), nodeB))
                return true;
            return false;
        }

        @Override
        public String toString() {
            LinkedList<T> allData = this.listData(this.rootNode, new LinkedList<>());
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (int i = 0, temp = allData.size(); i < temp; i++) {
                if (i == temp-1) {
                    sb.append(allData.get(i));
                } else {
                    sb.append(String.format("%s, ", allData.get(i)));
                }
            }
            sb.append("]");
            return sb.toString();
        }
    }

    private static int[] randomIntegerArray(int low, int high, int size) {
        if (size < 0)
            throw new IllegalArgumentException("Invalid array size");
        int[] newData = new int[size];
        newData = IntStream.of(newData).map(val -> low + random.nextInt(high)).toArray();
        return newData;
    }


    public static void main(String[] args) {

        int[] dataA = randomIntegerArray(-10, 50, 20);
        int[] dataB = randomIntegerArray(-10, 50, 8);

        System.out.printf("Generated array A: %s\n", Arrays.toString(dataA));
        System.out.printf("Generated array B: %s\n", Arrays.toString(dataB));

        // Now lets test our tree...

        System.out.print("Inserting data A ... ");

        TestBinaryTree<Integer> testTreeA = new TestBinaryTree<>(dataA[0]);
        for (int i = 1; i < dataA.length; i++)
            testTreeA.add(dataA[i]);

        System.out.println("[DONE]");

        // Inserting data B

        System.out.print("Inserting data B ... ");

        TestBinaryTree<Integer> testTreeB = new TestBinaryTree<>(dataB[0]);
        for (int i = 1; i < dataB.length; i++)
            testTreeB.add(dataB[i]);

        System.out.println("[DONE]");

        System.out.printf("Tree data A is: %s\n", testTreeA);
        System.out.printf("Tree data B is: %s\n", testTreeB);
        System.out.printf("\nIs Tree B subtree of Tree A: %s\n",
                TestBinaryTree.isSubTree(testTreeA, testTreeB) ? "YES" : "NO");
    }
}

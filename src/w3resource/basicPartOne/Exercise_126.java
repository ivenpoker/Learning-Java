package w3resource.basicPartOne;

// #######################################################################################################
// #                                                                                                     #
// #    Program Purpose: Get the post-order traversal of its nodes' values of a given binary tree.       #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                           #
// #    Creation Date  : October 30, 2019                                                                #
// #                                                                                                     #
// #######################################################################################################

import java.util.Objects;
import java.util.stream.IntStream;

public class Exercise_126 {

    private static class TestTree<T extends Comparable<T>> {

        private static class Node<T> {
            T element;
            Node<T> leftTree;
            Node<T> rightTree;

            public Node(T element, Node<T> leftTree, Node<T> rightTree) {
                this.setElement(element);
                this.setLeftTree(leftTree);
                this.setRightTree(rightTree);
            }

            public void setElement(T newElement) {
                this.element = newElement;
            }

            public void setLeftTree(Node<T> newLeftTree) {
                this.leftTree = newLeftTree;
            }

            public void setRightTree(Node<T> newRightTree) {
                this.rightTree = newRightTree;
            }

            public Node<T> getLeftTree() {
                return this.leftTree;
            }

            public Node<T> getRightTree() {
                return this.rightTree;
            }

            public T getElement() {
                return this.element;
            }
        }

        private Node<T> root = null;

        public TestTree(T rootVal) {
            this.root = new Node<>(rootVal, null, null);
        }

        public void addItem(T newItem) {
            this.addNodeItem(this.root, newItem);
        }

        private void addNodeItem(Node<T> rootNode, T newItem) {
            if (Objects.isNull(rootNode.getLeftTree()) && Objects.isNull(rootNode.getRightTree())) {
                Node<T> newItemNode = new Node<>(newItem, null, null);
                int comp = rootNode.getElement().compareTo(newItem);
                if (comp > 0) {
                    rootNode.setLeftTree(newItemNode);
                } else if (comp < 0) {
                    rootNode.setRightTree(newItemNode);
                } else {
                    // At this point, the new item to be inserted is the same
                    // as the item at the root node. Can't re-insert same item
                    // we we ignore it.
                }
            } else {
                int comp = rootNode.getElement().compareTo(newItem);
                if (comp > 0) {
                    if (Objects.isNull(rootNode.getLeftTree())) {
                        Node<T> newItemNode = new Node<>(newItem, null, null);
                        rootNode.setLeftTree(newItemNode);
                    } else {
                        this.addNodeItem(rootNode.getLeftTree(), newItem);
                    }
                } else if (comp < 0) {
                    if (Objects.isNull(rootNode.getRightTree())) {
                        Node<T> newItemNode = new Node<>(newItem, null, null);
                        rootNode.setRightTree(newItemNode);
                    } else {
                        this.addNodeItem(rootNode.getRightTree(), newItem);
                    }
                } else {
                    // At this point, the new item to be inserted is the same
                    // as the item at the root node. Can't re-insert same item
                    // we we ignore it.
                }
            }
        }

        public String inOrderTraversal() {
            String[] traversalData = this.treeInOrderTraversal(this.root, new StringBuilder()).trim().split(" ");
            return this.processTraversalData(traversalData);
        }

        private String processTraversalData(String[] traversalData) {
            StringBuilder newSb = new StringBuilder();
            newSb.append("[");

            for (int i = 0; i < traversalData.length; i++) {
                if (i == traversalData.length - 1) {
                    if (traversalData[i].length() > 0)
                        newSb.append(String.format("%s]", traversalData[i]));
                } else {
                    if (traversalData[i].length() > 0)
                        newSb.append(String.format("%s, ", traversalData[i]));
                }
            }
            return newSb.toString();
        }

        public String preOrderTraversal() {
            String[] traversalData = this.treePreOrderTraversal(this.root, new StringBuilder()).trim().split(" ");
            return this.processTraversalData(traversalData);
        }

        public String postOrderTraversal() {
            String[] traversalData = this.treePostOrderTraversal(this.root, new StringBuilder()).trim().split(" ");
            return this.processTraversalData(traversalData);
        }

        private String treePreOrderTraversal(Node<T> rootNode, StringBuilder sb) {
            if (this.isTreeEmpty(rootNode)) {
                return sb.append(String.format(" %s ", rootNode.getElement())).toString();
            }
            sb.append(String.format(" %s ", rootNode.getElement()));

            if (!Objects.isNull(rootNode.getLeftTree()))
                treePreOrderTraversal(rootNode.getLeftTree(), sb);

            if (!Objects.isNull(rootNode.getRightTree()))
                treePreOrderTraversal(rootNode.getRightTree(), sb);

            return sb.toString();
        }

        private String treePostOrderTraversal(Node<T> rootNode, StringBuilder sb) {
            if (this.isTreeEmpty(rootNode)) {
                return sb.append(String.format(" %s ", rootNode.getElement())).toString();
            }
            if (!Objects.isNull(rootNode.getLeftTree()))
                treePostOrderTraversal(rootNode.getLeftTree(), sb);

            if (!Objects.isNull(rootNode.getRightTree()))
                treePostOrderTraversal(rootNode.getRightTree(), sb);

            sb.append(String.format(" %s ", rootNode.getElement()));
            return sb.toString();
        }

        private String treeInOrderTraversal(Node<T> rootNode, StringBuilder sb) {

            if (this.isTreeEmpty(rootNode)) {
                return sb.append(String.format(" %s ", rootNode.getElement())).toString();
            }

            if (!Objects.isNull(rootNode.getLeftTree()))
                treeInOrderTraversal(rootNode.getLeftTree(), sb);

            sb.append(String.format(" %s ", rootNode.getElement()));

            if (!Objects.isNull(rootNode.getRightTree()))
                treeInOrderTraversal(rootNode.getRightTree(), sb);

            return sb.toString();
        }

        private boolean isTreeEmpty(Node<T> rootNode) {
            return Objects.isNull(rootNode.getLeftTree()) && Objects.isNull(rootNode.getRightTree());
        }
    }

    public static void main(String[] args) {
        int[] someData = {55, 21, 80, 9, 29, 76, 91};
        final int[] i = {0};

        TestTree<Integer> demoTree = new TestTree<>(someData[0]);
        IntStream.of(someData).forEach(val -> demoTree.addItem(someData[i[0]++]));

//        System.out.printf("  After doing in-order traversal: %s\n", demoTree.inOrderTraversal());
//        System.out.printf(" After doing pre-order traversal: %s\n", demoTree.preOrderTraversal());

        System.out.printf("After doing post-order traversal: %s\n", demoTree.postOrderTraversal());
    }
}

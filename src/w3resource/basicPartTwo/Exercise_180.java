package w3resource.basicPartTwo;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Swap every two adjacent nodes of a given linked list.               #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : January 08, 2019                                                    #
// #                                                                                         #
// ###########################################################################################

import java.security.SecureRandom;
import java.util.Objects;
import java.util.stream.IntStream;

public class Exercise_180 {

    private static SecureRandom random = new SecureRandom();

    private static class DemoLinkedList<T> {
        private class Node<T> {
            private T element;
            private Node<T> nextNode;
            private Node<T> prevNode;

            public Node(T element, Node<T> prevNode, Node<T> nextNode) {
                // some code here...
                this.setElement(element);
                this.setPrevNode(prevNode);
                this.setNextNode(nextNode);
            }
            public void setElement(T newElement) {
                this.element = newElement;
            }
            public void setNextNode(Node<T> newNextNode) {
                this.nextNode = newNextNode;
            }
            public void setPrevNode(Node<T> newPrevNode) {
                this.prevNode = newPrevNode;
            }
            public T getElement() {
                return this.element;
            }
            public Node<T> getNextNode() {
                return this.nextNode;
            }
            public Node<T> getPrevNode() {
                return this.prevNode;
            }
        }
        private Node<T> head;
        private Node<T> tail;
        private int size = 0;

        public DemoLinkedList() {
            this.head = new Node<>(null, null, null);
            this.tail = new Node<>(null, this.head, null);
            this.head.setNextNode(this.tail);
        }

        public boolean addElement(T newItem) {
            if (Objects.isNull(newItem)) {
                throw new IllegalArgumentException("Invalid object to insert. Cannot be 'null'");
            }
            if (this.isEmpty()) {
                return this.insertBetween(newItem, this.head, this.tail);
            } else {
                return this.insertBetween(newItem, this.head, this.head.getNextNode());
            }
        }

        private boolean insertBetween(T someItem, Node<T> prevNode, Node<T> nextNode) {
            Node<T> newNode = new Node<>(someItem, prevNode, nextNode);
            prevNode.setNextNode(newNode);
            nextNode.setPrevNode(newNode);
            this.size++;
            return true;
        }

        public boolean isEmpty() {
            return this.head.getNextNode() == this.tail;
        }

        @Override
        public String toString() {
            if (this.isEmpty()) {
                return "[]";
            }
            Node<T> temp = this.head.getNextNode();
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            while (temp != this.tail) {
                if (temp.getNextNode() == this.tail) {
                    sb.append(String.format("%s]", temp.getElement()));
                } else {
                    sb.append(String.format("%s, ", temp.getElement()));
                }
                temp = temp.getNextNode();
            }
            return sb.toString();
        }

        public void swapAdjacentNodes() {
            if (this.isEmpty()) {
                return;
            }
            Node<T> trackA = this.head.getNextNode();
            if (Objects.isNull(trackA.getNextNode())) {
                return;
            }
            for (int i = 0; i < this.size / 2; i++) {
                if (Objects.isNull(trackA.getNextNode().getNextNode())) {
                    break;
                }
                swapNode(trackA, trackA.getNextNode());
                trackA = trackA.getNextNode().getNextNode();
                if (Objects.isNull(trackA))
                    break;
            }
        }
        private void swapNode(Node<T> nodeA, Node<T> nodeB) {
            T tempELem = nodeA.getElement();
            nodeA.setElement(nodeB.getElement());
            nodeB.setElement(tempELem);
        }

    }

    private static DemoLinkedList<Integer> createList(int low, int high, int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Invalid specified size for new list");
        }
        DemoLinkedList<Integer> newList = new DemoLinkedList<>();
        for (int i = 0; i < size; i++) {
            newList.addElement(low + random.nextInt(high));
        }
        return newList;
    }

    private static void printLine(char mainChar, int times) {
        for (int i = 0; i < times; i++) {
            System.out.printf("%c", mainChar);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DemoLinkedList<Integer> newListDataA = createList(0, 20, 14);
        System.out.printf(" New list data: %s\n", newListDataA.toString());

        // swap node data
        newListDataA.swapAdjacentNodes();
        System.out.printf("After swapping: %s\n", newListDataA.toString());

        printLine('-', 60);

        int[] newData = {10, 20, 30, 40, 50};
        DemoLinkedList<Integer> newListDataB = new DemoLinkedList<>();

        IntStream.of(newData).forEach(newListDataB::addElement);
        System.out.printf("New list data: %s\n", newListDataB);

        newListDataB.swapAdjacentNodes();

        System.out.printf("After swapping: %s\n", newListDataB.toString());
    }
}

package w3resource.basicPartOne;

// #######################################################################################################
// #                                                                                                     #
// #    Program Purpose: Removes duplicates from a sorted linked list. In this case the linked list is   #
// #                     programmed to keep data in descending order as the sorted order.                #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                           #
// #    Creation Date  : October 31, 2019                                                                #
// #                                                                                                     #
// #######################################################################################################

import java.security.SecureRandom;
import java.util.stream.IntStream;
import java.util.Arrays;

public class Exercise_135 {

    public static class RedefinedLinkedList<T extends Comparable<T>> {

        private class Node<T extends Comparable<T>> {
            private T element;
            private Node<T> nextNode;
            private Node<T> prevNode;

            public Node(T element, Node<T> prevNode, Node<T> nextNode) {
                this.setElement(element);
                this.setNextNode(nextNode);
                this.setPrevNode(prevNode);
            }
            public void setElement(T newElement) {
                this.element = newElement;
            }
            public void setNextNode(Node<T> nextNode) {
                this.nextNode = nextNode;
            }
            public void setPrevNode(Node<T> prevNode) {
                this.prevNode = prevNode;
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

        private Node<T> head = null;
        private Node<T> tail = null;

        public RedefinedLinkedList() {
            this.head = new Node<>(null, null, null);
            this.tail = new Node<>(null, this.head, null);
            this.head.setNextNode(this.tail);
        }

        public void add(T element) {

            if (this.isListEmpty()) {
                Node<T> newNode = new Node<>(element, null, null);
                newNode.setNextNode(this.head.getNextNode());
                newNode.setPrevNode(this.head);
                this.head.getNextNode().setPrevNode(newNode);
                this.head.setNextNode(newNode);
            } else {
                Node<T> temp = this.head.getNextNode();
                while (temp != this.tail && (temp.getElement().compareTo(element) > 0)) {
                    temp = temp.getNextNode();
                }
                this.addBetween(temp.getPrevNode(), element, temp);
            }
        }

        private void addBetween(Node<T> prevNode, T element, Node<T> nextNode) {
            Node<T> newNode = new Node<>(element, prevNode, nextNode);
            prevNode.setNextNode(newNode);
            nextNode.setPrevNode(newNode);
        }

        public RedefinedLinkedList<T> removeDuplicates() {
            if (this.isListEmpty()) {
                return new RedefinedLinkedList<>();
            } else {
                RedefinedLinkedList<T> newList = new RedefinedLinkedList<>();
                Node<T> temp = this.head.getNextNode();

                while (temp != this.tail) {
                    if (!newList.contains(temp.getElement()))
                        newList.add(temp.getElement());
                    temp = temp.getNextNode();
                }
                return newList;
            }
        }

        private boolean contains(T element) {
            if (this.isListEmpty()) {
                return false;
            } else {
                Node<T> temp = this.head.getNextNode();
                while (temp != this.tail) {
                    if (temp.getElement().compareTo(element) == 0)
                        return true;
                    temp = temp.getNextNode();
                }
                return false;
            }
        }

        public boolean isListEmpty() {
            return this.head.getNextNode() == this.tail;
        }

        @Override
        public String toString() {
            if (this.isListEmpty()) {
                return "[LIST EMPTY]";
            } else {
                Node<T> temp = this.head.getNextNode();
                StringBuilder bd = new StringBuilder();
                bd.append("[");
                while (temp != this.tail) {
                    if (temp.getNextNode() == this.tail) {
                        bd.append(String.format("%s", temp.getElement()));
                    } else {
                        bd.append(String.format("%s, ", temp.getElement()));
                    }
                    temp = temp.getNextNode();
                }
                bd.append("]");
                return bd.toString();
            }
        }
    }
    private static SecureRandom random = new SecureRandom();

    private static int[] generateRandomData(int low, int high, int size) {
        if (size < 0)
            throw new IllegalArgumentException("Invalid size for array. Must be > 0");
        int[] newData = new int[size];
        newData = IntStream.of(newData).map(val -> low + random.nextInt(high)).toArray();
        return newData;
    }

    public static void main(String[] args) {

        // Generate the data and display them.
        int[] data = generateRandomData(1, 5, 20);
        System.out.printf("Generated array: %s\n", Arrays.toString(data));


        System.out.print("Loading data...");

        // Generate a list out of the data
        RedefinedLinkedList<Integer> newIntegerList = new RedefinedLinkedList<>();
        for (int datum : data)
            newIntegerList.add(datum);

        System.out.println("[DONE]");
        System.out.printf("Data in list: %s\n", newIntegerList);

        // Now let's remove the duplicates in list.
        System.out.print("Removing duplicates....");
        RedefinedLinkedList<Integer> uniqueData = newIntegerList.removeDuplicates();
        System.out.println("[DONE]");

        // Display the unique list data
        System.out.printf("After removing duplicates: %s\n", uniqueData);
    }

}

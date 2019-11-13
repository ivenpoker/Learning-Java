package w3resource.basicPartOne;

// ##############################################################################
// #                                                                            #
// #    Program Purpose: Removes the nth element from the end of a given list.  #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                  #
// #    Creation Date  : November 13, 2019                                      #
// #                                                                            #
// ##############################################################################

import java.security.SecureRandom;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Exercise_145 {

    private static SecureRandom random = new SecureRandom();
    private static Scanner scanner = new Scanner(System.in);

    private static class TestList<T extends Comparable<T>> {

        private class Node<T> {
            private T element;
            private Node<T> prevNode;
            private Node<T> nextNode;

            public Node(T element, Node<T> prevNode, Node<T> nextNode) {
                this.setElement(element);
                this.setPrevNode(prevNode);
                this.setNextNode(nextNode);
            }
            public void setElement(T element) {
                this.element = element;
            }
            public void setNextNode(Node<T> newNextNode) {
                this.nextNode = newNextNode;
            }
            public void setPrevNode(Node<T> newPrevNode) {
                this.prevNode = newPrevNode;
            }
            public Node<T> getPrevNode() {
                return this.prevNode;
            }
            public Node<T> getNextNode() {
                return this.nextNode;
            }
            public T getElement() {
                return this.element;
            }
        }

        private Node<T> head;
        private Node<T> tail;
        private int size;

        public TestList() {
            this.head = new Node<>(null, null, null);
            this.tail = new Node<>(null, this.head, null);
            this.head.setNextNode(this.tail);
            this.size = 0;
        }

        public boolean add(T element) {
            if (this.isListEmpty()) {
                this.addBetween(this.head, element, this.tail);
            } else {
                Node<T> temp = this.head.getNextNode();
                while (temp != this.tail && (temp.getElement().compareTo(element) < 0)) {
                    temp = temp.getNextNode();
                }
                if (temp == this.tail) {
                    this.addBetween(this.tail.getPrevNode(), element, this.tail);
                } else if (temp.getElement().compareTo(element) == 0) {
                    // This is duplicate data. We just insert it and continue...
                    this.addBetween(temp.getPrevNode(), element, temp);

                } else {
                    this.addBetween(temp.getPrevNode(), element, temp);
                }
            }
            this.size++;
            return true;
        }

        public int getSize() {
            return this.size;
        }

        public T removeFromBack(int positionFromBack) {
            if (this.isListEmpty())
                return null;

            if (positionFromBack < 0 || positionFromBack > this.getSize())
                throw new IllegalArgumentException("Invalid index to remove from");

            Node<T> temp = this.tail.getPrevNode();
            int cnt = 1;

            while (cnt != positionFromBack && temp != this.head) {
                temp = temp.getPrevNode();
                cnt++;
            }

            if (cnt == positionFromBack) {
                temp.getNextNode().setPrevNode(temp.getPrevNode());
                temp.getPrevNode().setNextNode(temp.getNextNode());
                this.size--;
                return temp.getElement();
            }
            return null;
        }

        private void addBetween(Node<T> prevNode, T element, Node<T> nextNode) {
            Node<T> newNode = new Node<>(element, prevNode, nextNode);
            prevNode.setNextNode(newNode);
            nextNode.setPrevNode(newNode);
        }

        public boolean isListEmpty() {
            return this.head.getNextNode() == this.tail;
        }

        @Override
        public String toString() {
            if (this.isListEmpty()) {
                return "[]";
            } else {
                StringBuilder bd = new StringBuilder();
                bd.append("[");

                Node<T> temp = this.head.getNextNode();
                while (temp != this.tail) {
                    bd.append(String.format("%s", temp.getElement()));
                    if (temp.getNextNode() != this.tail) {
                        bd.append(", ");
                    }
                    temp = temp.getNextNode();
                }
                bd.append("]");
                return bd.toString();
            }
        }
    }

    private static int[] intArrayGenerator(int low, int high, int size) {
        if (size <= 0)
            throw new IllegalArgumentException("Invalid size of array. Must be > 0");
        int[] newData = new int[size];
        newData = IntStream.of(newData).map(val -> low + random.nextInt(high)).toArray();
        return newData;
    }

    public static int getUserInd(String inputMessage, int low, int high) {
        int userData = 0;
        boolean isValid = false;

        while (!isValid) {
            try {
                System.out.print(inputMessage);
                userData = scanner.nextInt();
                if (userData < low || userData >= high)
                    throw new IllegalArgumentException(String.format("Invalid input. " +
                            "Most be in range [%d, %d)", low, high));
                isValid = true;

            } catch (Exception ex) {
                System.err.println( "[ERROR]: " + ex.getMessage());
            }
        }
        return userData;
    }

    public static void main(String[] args) {

        int[] newArrayData = intArrayGenerator(0, 15, 10);
        // System.out.printf("Array data: %s\n", Arrays.toString(newArrayData));

        TestList<Integer> newList = new TestList<>();
        for (int data : newArrayData)
            newList.add(data);

        System.out.printf("List data: %s\n", newList);
        int userVal = -1;
        do {
            userVal = getUserInd("Enter element position to remove (from back): ",
                    0, newList.getSize());
            newList.removeFromBack(userVal);
            System.out.printf("List data: %s\n", newList);
        } while (newList.getSize() != 0);

    }
}

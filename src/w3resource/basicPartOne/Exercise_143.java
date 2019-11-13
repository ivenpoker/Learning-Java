package w3resource.basicPartOne;

// #######################################################################################################
// #                                                                                                     #
// #    Program Purpose: Merge two sorted list.                                                          #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                           #
// #    Creation Date  : November 13, 2019                                                               #
// #                                                                                                     #
// #######################################################################################################

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.stream.IntStream;

public class Exercise_143 {

    private static SecureRandom random = new SecureRandom();

    public static class TestList<T extends Comparable<T>> {

        private class Node<T> {
            private T element;
            private Node<T> prevNode;
            private Node<T> nextNode;

            public Node(T element, Node<T> prevNode, Node<T> nextNode) {
                this.setElement(element);
                this.setPrevNode(prevNode);
                this.setNextNode(nextNode);
            }
            public void setElement(T newElement) {
                this.element = newElement;
            }
            public void setPrevNode(Node<T> newPrevNode) {
                this.prevNode = newPrevNode;
            }
            public void setNextNode(Node<T> newNextNode) {
                this.nextNode = newNextNode;
            }
            public T getElement() {
                return this.element;
            }
            public Node<T> getPrevNode() {
                return this.prevNode;
            }
            public Node<T> getNextNode() {
                return this.nextNode;
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

        private void addBetween(Node<T> prevNode, T element, Node<T> nextNode) {
            Node<T> newNode = new Node<>(element, prevNode, nextNode);
            prevNode.setNextNode(newNode);
            nextNode.setPrevNode(newNode);
        }

        public boolean isListEmpty() {
            return this.head.getNextNode() == this.tail;
        }

        public static <T extends Comparable<T>> TestList<T> merge(TestList<T> listA, TestList<T> listB) {
            TestList<T> listC = new TestList<T>();
            ArrayList<T> listAData = listA.getElements();

            // Insert all of listA data into listC
            for (int i = 0; i < listAData.size(); i++)
                listC.add(listAData.get(i));

            ArrayList<T> listBData = listB.getElements();

            // Insert all of listB data into listC
            for (int i = 0; i < listBData.size(); i++)
                listC.add(listBData.get(i));

            return listC;
        }

        public ArrayList<T> getElements() {

            ArrayList<T> listData = new ArrayList<>();

            if (this.isListEmpty()) {
                return listData;
            } else {
                int i = 0;
                Node<T> temp = this.head.getNextNode();
                while (temp != this.tail) {
                    listData.add(temp.getElement());
                    temp = temp.getNextNode();
                }
                return listData;
            }
        }

        public int getSize() {
            return this.size;
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

    private static int[] randomIntegerArrayData(int low, int high, int size) {
        if (size < 0)
            throw new IllegalArgumentException("Invalid array size. Must be > 0");
        int[] newData = new int[size];
        newData = IntStream.of(newData).map(val -> low + random.nextInt(high)).toArray();
        return newData;
    }

    public static void main(String[] args) {
        int[] arrayDataA = randomIntegerArrayData(0, 20, 10);
        int[] arrayDataB = randomIntegerArrayData(0, 20, 10);

        System.out.printf("Generated array A: %s\n", Arrays.toString(arrayDataA));
        System.out.printf("Generated array B: %s\n", Arrays.toString(arrayDataB));

        TestList<Integer> testListA = new TestList<>();
        for (int data : arrayDataA)
            testListA.add(data);

        TestList<Integer> testListB = new TestList<>();
        for (int data : arrayDataB)
            testListB.add(data);

        System.out.printf("\nList data A: %s\n", testListA);
        System.out.printf("\nList data B: %s\n", testListB);

        TestList<Integer> mergedList = TestList.merge(testListA, testListB);
        System.out.printf("Merged List: %s\n", mergedList);

    }
}

package w3resource.basicPartTwo;

// #############################################################################################
// #                                                                                           #
// #    Program Purpose: Merges two sorted (ascending) linked lists in ascending order.        #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                 #
// #    Creation Date  : June 24, 2020                                                         #
// #                                                                                           #
// #############################################################################################

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Exercise_207 {

    private static final SecureRandom random = new SecureRandom();
    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 100;
    private static final int MAX_SIZE = 5;

    private static LinkedList_207<Integer> randomListItems(int lowerBound, int upperBound, int maxSize) {
        LinkedList_207<Integer> newRandomList = new LinkedList_207<>();
        Arrays.stream(new int[maxSize]).forEach((v) -> {
            newRandomList.add(lowerBound + random.nextInt(upperBound));
        });
        return newRandomList;
    }

    public static void main(String[] args) {

        LinkedList_207<Integer> listA = randomListItems(LOWER_BOUND, UPPER_BOUND, MAX_SIZE);
        LinkedList_207<Integer> listB = randomListItems(LOWER_BOUND, UPPER_BOUND, MAX_SIZE);

        System.out.printf("List A: %s%n", listA);
        System.out.printf("List B: %s%n", listB);

        LinkedList_207<Integer> mergedAB = LinkedList_207.mergeList(listA, listB);

        System.out.printf("Merged list: %s%n", mergedAB);

    }
}

class LinkedList_207<T extends Comparable<T>> {

    private static class Node<T> {

        private T element;
        private Node<T> nextNode;
        private Node<T> prevNode;

        public Node(Node<T> prevNode, T element, Node<T> nextNode) {
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

        public Node<T> getNextNode() {
            return this.nextNode;
        }

        public Node<T> getPrevNode() {
            return this.prevNode;
        }

    }

    private final Node<T> head;
    private final Node<T> tail;
    private int numNodes = 0;

    public LinkedList_207() {
        this.head = new Node<>(null, null, null);
        this.tail = new Node<>(null, null, null);

        this.head.setNextNode(this.tail);
        this.tail.setPrevNode(this.head);
    }

    public boolean isEmpty() {
        return this.head.getNextNode() == this.tail;
    }

    public void add(T newElement) {
        if (Objects.isNull(newElement)) {
            throw new IllegalArgumentException("Invalid element. Must not be null");
        }
        if (this.isEmpty()) {
            Node<T> newNode = new Node<>(this.head, newElement, this.tail);
            this.head.setNextNode(newNode);
            this.tail.setPrevNode(newNode);

            this.numNodes += 1;
        } else {

            Node<T> temp = this.head.getNextNode();
            boolean nodeInserted = false;

            while (temp != this.tail && !nodeInserted) {
                int compResult = newElement.compareTo(temp.getElement());
                if (compResult < 0 || compResult == 0) {
                    this.addBetween(temp.getPrevNode(), newElement, temp);
                    nodeInserted = true;
                }
                temp = temp.getNextNode();
            }

            if (!nodeInserted) {
                // At this point we're at the end of the list.
                // This means that the item is the new largest
                // to be inserted so far.

                // Insert between the the last item in the list and the tail.
                this.addBetween(this.tail.getPrevNode(), newElement, this.tail);
            }
            this.numNodes += 1;
        }

    }

    private T[] getAllData() {
        Node<T> temp = this.head.getNextNode();

        T[] arrayData = (T[]) new Comparable[this.numNodes];
        int cnt = 0;

        while (temp != this.tail) {
            arrayData[cnt] = temp.getElement();
            temp = temp.getNextNode();
            cnt += 1;
        }
        return arrayData;
    }

    private void addBetween(Node<T> prevNode, T element, Node<T> nextNode) {
        Node<T> newNode = new Node<>(prevNode, element, nextNode);
        prevNode.setNextNode(newNode);
        nextNode.setPrevNode(newNode);
    }

    public static <K extends Comparable<K>> LinkedList_207<K>
                mergeList(LinkedList_207<K> listA, LinkedList_207<K> listB) {
        LinkedList_207<K> mergedList = new LinkedList_207<>();

        // Let our merged list first contain all the data found
        // list A.

        K[] allListAData = listA.getAllData();
        for (K elem : allListAData) {
            mergedList.add(elem);
        }

        // We now insert all listB data into our merge list. We take
        // advantage of the implementation of 'add' to keep nodes in
        // list in order.

        K[] allListBData = listB.getAllData();
        for (K elem : allListBData) {
            mergedList.add(elem);
        }

        // Return list, which is a merge of list A and list B.
        return mergedList;
    }

    @Override
    public String toString() {
        ArrayList<T> listItems = new ArrayList<>();
        Node<T> temp = this.head.getNextNode();

        while (temp != this.tail) {
            listItems.add(temp.getElement());
            temp = temp.getNextNode();
        }

        return Arrays.toString(listItems.toArray());
    }
}

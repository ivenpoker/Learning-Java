package w3resource.basicPartTwo;

// ##########################################################################################
// #                                                                                        #
// #    Program Purpose: Deletes a specified node in the middle of a singly linked list.    #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                              #
// #    Creation Date  : January 08, 2019                                                   #
// #                                                                                        #
// ##########################################################################################

import java.security.SecureRandom;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Exercise_175 {

    private static SecureRandom random = new SecureRandom();
    private static Scanner scanner = new Scanner(System.in);

    private static class SingleLinkedList<T> {

        private class Node<T> {

            private T element;
            private Node<T> nextNode;

            public Node(T element, Node<T> nextNode) {
                this.setElement(element);
                this.setNextNode(nextNode);
            }
            private void setElement(T newElement) {
                this.element = newElement;
            }
            private T getElement() {
                return this.element;
            }
            private void setNextNode(Node<T> nextNode) {
                this.nextNode = nextNode;
            }
            private Node<T> getNextNode() {
                return this.nextNode;
            }
        }

        private Node<T> head;
        private Node<T> tail;

        public SingleLinkedList() {
            this.head = new Node<>(null, null);
            this.tail = new Node<>(null, null);
            this.head.setNextNode(this.tail);
        }

        // Add a node to list (add to the head
        public void add(T newElement) {
            Node<T> newNode = new Node<>(newElement, this.head.getNextNode());
            this.head.setNextNode(newNode);
        }

        // Check if list is empty
        public boolean isEmpty() {
            return this.head.getNextNode() == this.tail;
        }

        public boolean contains(T item) {
            if (this.isEmpty()) {
                return false;
            }
            // Linear search algorithm
            Node<T> temp = this.head.getNextNode();
            while (temp != this.tail) {
                if (temp.getElement().equals(item)) {
                    return true;
                }
                temp = temp.getNextNode();
            }
            return false;
        }

        public T remove(T item) {
            if (this.isEmpty()) {
                return null;
            }
            Node<T> temp = this.head;
            if (temp.getNextNode() == this.tail) {
                if (temp.getNextNode().equals(item)) {
                    Node<T> itemToDel = temp.getNextNode();     // track item to delete
                    T element = itemToDel.getElement();         // Get data stored in node
                    itemToDel = null;                           // release resources

                    return element;
                } else {
                    return null;
                }
            }
            while (temp.getNextNode() != this.tail) {
                // we've found item to remove. We'll just remove the first.
                // if we wan't to
                if (temp.getNextNode().getElement().equals(item)) {

                    Node<T> itemToDel = temp.getNextNode();     // keep track of item to be removed
                    temp.setNextNode(itemToDel.getNextNode());  // skip the item to delete, previous points to next.
                    T element = itemToDel.getElement();         // obtain nodes data
                    item = null;                                // release resources.

                    return element;                             // remove (or comment out) to remove ALL items in list.
                }
                temp = temp.getNextNode();
            }
            return null;
        }

        @Override
        public String toString() {
            if (this.isEmpty()) {
                return "[]";
            }
            Node<T> temp = this.head.getNextNode();
            StringBuilder build = new StringBuilder();
            build.append("[");
            while (temp != this.tail) {

                // Peek ahead to know how to format data
                if (temp.getNextNode() == this.tail) {
                    build.append(String.format("%s]", temp.getElement()));
                } else {
                    build.append(String.format("%s, ", temp.getElement()));
                }
                temp = temp.getNextNode();
            }
            return build.toString();
        }

    }

    private static SingleLinkedList<Integer> createList(int low, int high, int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Invalid size for new list. Must be > 0");
        }
        SingleLinkedList<Integer> newList = new SingleLinkedList<>();

        // Fill list with random data in range [low, high) with size -> 'size'
        for (int i = 0; i < size; i++) {
            newList.add(low + random.nextInt(high));
        }
        return newList;
    }

    private static void doRemovalProcessing(SingleLinkedList<Integer> mainList) {

        while (!mainList.isEmpty()) {
            try {
                System.out.printf("Main List: %s\n", mainList.toString());
                printLine('-', 70);

                System.out.print("Enter item to remove: ");
                int item = scanner.nextInt();

                printLine('-', 70);
                System.out.printf("Removing '%d' ... ", item);
                Integer result = mainList.remove(item);
                if (Objects.isNull(result)) {
                    System.out.println("[FAILED]");
                } else {
                    System.out.println("[SUCCESS]");
                }
            } catch (InputMismatchException inputExc) {
                System.err.println("[INPUT_ERROR]: Invalid input. Must be integer");
            }
            printLine('-', 70);
        }
        System.out.println("List is now EMPTY!");
        printLine('-', 70);
    }

    private static void printLine(char someChar, int times) {
        for (int i = 0; i < times; i++) {
            System.out.printf("%c", someChar);
        }
        System.out.println();
    }

    // Testing the class out
    public static void main(String[] args) {
        SingleLinkedList<Integer> newList = createList(0, 20, 15);
        doRemovalProcessing(newList);

    }
}

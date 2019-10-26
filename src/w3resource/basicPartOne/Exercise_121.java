package w3resource.basicPartOne;

// #######################################################################################################
// #                                                                                                     #
// #    Program Purpose: Reverses a linked list data.                                                    #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                           #
// #    Creation Date  : October 26, 2019                                                                #
// #                                                                                                     #
// #######################################################################################################

public class Exercise_121 {

    private static class TestLinkedList<T> {

        private static class Node<T> {
            private T element;
            private Node<T> nextNode;
            private Node<T> prevNode;

            public Node(Node<T> prevNode, T element, Node<T> nextNode) {
                this.setPrevNode(prevNode);
                this.setNextNode(nextNode);
                this.setElement(element);
            }

            public void setElement(T newElement) {
                this.element = newElement;
            }

            public void setNextNode(Node<T> newNextNode) {
                this.nextNode = newNextNode;
            }

            public void setPrevNode(Node<T> prevNode) {
                this.prevNode = prevNode;
            }

            public Node<T> getNextNode() {
                return this.nextNode;
            }

            public Node<T> getPrevNode() {
                return this.prevNode;
            }

            public T getElement() {
                return this.element;
            }

        }
        private Node<T> head = null;
        private Node<T> tail = null;

        public TestLinkedList() {
            this.head = new Node<>(null, null, null);
            this.tail = new Node<>(this.head, null, null);
            this.head.setNextNode(this.tail);
        }

        public void add(T element) {
            Node<T> newNode = new Node<>(this.head, element, this.head.getNextNode());
            this.head.getNextNode().setPrevNode(newNode);
            this.head.setNextNode(newNode);
        }

        public boolean isEmpty() {
            return this.head.getNextNode() == this.tail;
        }

        public static <T> TestLinkedList<T> reverse(TestLinkedList<T> someList) {
            TestLinkedList<T> reverseList = new TestLinkedList<>();
            Node<T> temp = someList.head.getNextNode();
            while (temp != someList.tail) {
                reverseList.add(temp.getElement());
                temp = temp.getNextNode();
            }
            return reverseList;
        }

        @Override
        public String toString() {
            StringBuilder build = new StringBuilder();
            build.append("[");
            Node<T> temp = this.head.getNextNode();
            while (temp != this.tail) {
                build.append(temp.getElement());
                temp = temp.getNextNode();
                if (temp != this.tail)
                    build.append(", ");
            }
            build.append("]");
            return build.toString();
        }

    }

    public static void main(String[] args) {
        TestLinkedList<Integer> testList = new TestLinkedList<>();
        for (int i = 0; i < 10; i++)
            testList.add(i);
        System.out.printf("   List data: %s\n", testList.toString());
        System.out.printf("Reverse data: %s\n", TestLinkedList.reverse(testList));
    }
}

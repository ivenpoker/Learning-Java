// #############################################################################
// #                                                                           #
// #      Program purpose: Solution to Exercise R-3.10 in Book                 #
// #      Program author : Happi Yvan <ivensteinpoker@gmail.com>               #
// #      Program Date   : 19/06/2019                                          #
// #                                                                           #
// #############################################################################

package books.DataStructuresAndAlgorithms_6thEd.chapter_3.R_Exercises;

public class Exercise_R_3_10 {

    public static class CircularlyLinkedList<E> {

        private static class Node<E> {
            private E _element;
            private Node<E> _next;

            public Node(E element, Node<E> next) {
                this._element = element;
                this._next = next;
            }

            public E getElement() {
                return this._element;
            }

            public Node<E> getNext() {
                return this._next;
            }

            public void setNext(Node<E> next) {
                this._next = next;
            }
        }

        private Node<E> _tail = null;
        private int _size = 0;
        private CircularlyLinkedList() {
            // create an empty linked list.
        }

        public int size() {
            return this.size();
        }

        public boolean isEmpty() {
            return this._size == 0;
        }

        public E first() {
            if (this.isEmpty()) return null;
            return this._tail.getNext().getElement();
        }

        public E last() {
            if (this.isEmpty()) return null;
            return this._tail.getElement();
        }

        public void rotate() {
            if (this._tail != null)
                this._tail = this._tail.getNext();
        }

        public void addFirst(E element) {
            if (this._size == 0) {
                this._tail = new Node<>(element, null);
                this._tail.setNext(this._tail);
            } else {
                Node<E> newest = new Node<>(element, this._tail.getNext());
                this._tail.setNext(newest);
            }
            this._size++;
        }

        public void addLast(E element) {
            this.addFirst(element);
            this._tail = this._tail.getNext();
        }

        // ##################### NEW METHOD TO GET LIST SIZE WITHOUT USING THE 'size' DATA MEMBER ##################
        public int getSize() {
            if (this._tail == null) return 0;
            int cnt = 1;        // because tail is not null, it points to at least one node

            Node<E> tmp = this._tail.getNext();
            while (tmp != this._tail) {
                ++cnt;
                tmp = tmp.getNext();
            }
            return cnt;
        }

        public E removeFirst() {
            if (this.isEmpty()) return null;
            Node<E> head = this._tail.getNext();
            if (head == this._tail)
                this._tail = null;
            else
                this._tail.setNext(head.getNext());
            this._size--;
            return head.getElement();
        }
    }

    public static void main(String[] args) {
        CircularlyLinkedList<Integer> list = new CircularlyLinkedList<>();

        // add 10 integers to the list
        for (int i = 1; i <= 10; i++)
            list.addFirst(i);

        System.out.printf("Size of list: %d\n", list.getSize());
    }
}

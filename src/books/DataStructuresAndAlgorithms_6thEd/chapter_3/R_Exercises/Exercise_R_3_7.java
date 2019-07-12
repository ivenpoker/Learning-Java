// #############################################################################
// #                                                                           #
// #      Program purpose: Solution to Exercise R-3.7 in Book                  #
// #      Program author : Happi Yvan <ivensteinpoker@gmail.com>               #
// #      Program Date   : 19/06/2019                                          #
// #                                                                           #
// #############################################################################

package books.DataStructuresAndAlgorithms_6thEd.chapter_3.R_Exercises;

public class Exercise_R_3_7 {

    public static class CircularyLinkedList<E> {

        private static class Node<E> {
            private E element;
            private Node<E> next;
            private Node(E element, Node<E> next) {
                this.element = element;
                this.next    = next;
            }
            public E getElement() {
                return this.element;
            }
            public Node<E> getNext() {
                return this.next;
            }
            public void setNext(Node<E> next) {
                this.next = next;
            }
        }

        private Node<E> tail = null;
        private int size = 0;

        public CircularyLinkedList() {
            // empty body for circularly linked list.
        }

        public int size() {
            return this.size;
        }

        public boolean isEmpty() {
            return this.size == 0;
        }

        public E first() {
            if (this.isEmpty()) return null;
            return tail.getNext().getElement();
        }

        public E last() {
            if (this.isEmpty()) return null;
            return this.tail.getElement();
        }

        public void rotate() {
            if (this.tail != null)
                this.tail = this.tail.getNext();
        }

        public void addFirst(E elem) {
            if (this.size == 0) {
                this.tail = new Node<>(elem, null);
                this.tail.setNext(this.tail);
            } else {
                // moved the node creation inside the 'setNext' argument space.
                this.tail.setNext(new Node<>(elem, this.tail.getNext()));
            }
            this.size++;
        }

        public void addLast(E elem) {
            this.addFirst(elem);
            this.tail = this.tail.getNext();
        }

        public E removeFirst() {
            if (this.isEmpty()) return null;
            Node<E> head = this.tail.getNext();
            if (head == this.tail)
                this.tail = null;
            else
                this.tail.setNext(head.getNext());
            size--;
            return head.getElement();
        }
    }
}






























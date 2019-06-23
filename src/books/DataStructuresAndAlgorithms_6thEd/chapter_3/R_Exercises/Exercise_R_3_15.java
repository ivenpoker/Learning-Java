// #############################################################################
// #                                                                           #
// #      Program purpose: Solution to Exercise R-3.15 in Book                 #
// #      Program author : Happi Yvan <ivensteinpoker@gmail.com>               #
// #      Program Date   : 19/06/2019                                          #
// #                                                                           #
// #############################################################################

package books.DataStructuresAndAlgorithms_6thEd.chapter_3.R_Exercises;

public class Exercise_R_3_15 {

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
            return this._size;
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

        @Override
        public boolean equals(Object obj) {
            if (obj == null) return false;
            if (this.getClass() != obj.getClass()) return false;
            CircularlyLinkedList<E> other = (CircularlyLinkedList) obj;

            if (this.size() != other.size()) return false;
            Node<E> walkA = this._tail.getNext(); // first node of this current object
            Node<E> walkB = other._tail.getNext(); // first node of 'other'

            while (walkA != this._tail) {
                if (!walkA.getElement().equals(walkB.getElement()))
                    return false;
                walkA = walkA.getNext();
                walkB = walkB.getNext();
            }
            return true;
        }

        @Override
        public String toString() {
            StringBuilder tmp = new StringBuilder();
            tmp.append("[");
            Node<E> node = this._tail.getNext();
            for (int i = 0; i < this.size()-1; i++) {
                tmp.append(String.format("%s, ", node.getElement()));
                node = node.getNext();
            }
            tmp.append(String.format("%s]", node.getElement()));

            return tmp.toString();
        }
    }

    // ########################## TESTING THE 'equals' METHOD ###############################

    public static boolean inRange(int low, int val, int high) {
        return low <= val && val <= high;
    }

    public static void main(String[] args) {
       Integer[] dataA = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
       Integer[] dataB = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
       Integer[] dataC = new Integer[] {1, 2, 3, 4, 5};

       CircularlyLinkedList<Integer> listA = new CircularlyLinkedList<>();
       CircularlyLinkedList<Integer> listB = new CircularlyLinkedList<>();
       CircularlyLinkedList<Integer> listC = new CircularlyLinkedList<>();

       for (int i = 0; i < dataA.length; i++) {
           listA.addFirst(dataA[i]);
           listB.addFirst(dataB[i]);
           if (inRange(0, i,dataC.length-1))
               listC.addFirst(dataC[i]);
       }

        System.out.printf("ListA: %s\n", listA);
        System.out.printf("ListB: %s\n", listB);
        System.out.printf("ListC: %s\n", listC);

        System.out.printf("ListA == listB ?: %s\n", listA.equals(listB));
        System.out.printf("ListB == listC ?: %s\n", listB.equals(listC));


    }
}

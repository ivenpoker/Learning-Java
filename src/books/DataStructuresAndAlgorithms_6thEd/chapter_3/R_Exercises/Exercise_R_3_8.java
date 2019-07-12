// #############################################################################
// #                                                                           #
// #      Program purpose: Solution to Exercise R-3.8 in Book                  #
// #      Program author : Happi Yvan <ivensteinpoker@gmail.com>               #
// #      Program Date   : 19/06/2019                                          #
// #                                                                           #
// #############################################################################

package books.DataStructuresAndAlgorithms_6thEd.chapter_3.R_Exercises;

public class Exercise_R_3_8 {

    public static class DoublyLinkedList<E> {

        private static class Node<E> {
            private E _element;
            private Node<E> _prev;
            private Node<E> _next;

            public Node(E element, Node<E> prev, Node<E> next) {
                this._element = element;
                this._prev = prev;
                this._next = next;
            }
            public E getElement() {
                return this._element;
            }
            public Node<E> getPrev() {
                return this._prev;
            }
            public Node<E> getNext() {
                return this._next;
            }
            public void setNext(Node<E> newNext) {
                this._next = newNext;
            }
            public void setPrev(Node<E> newPrev) {
                this._prev = newPrev;
            }
        }
        private Node<E> _header;
        private Node<E> _trailer;
        private int _size = 0;

        public DoublyLinkedList() {
            this._header = new Node<>(null, null,null);
            this._trailer = new Node<>(null, this._header,null);
            this._header.setNext(this._trailer);
        }

        public int size() {
            return this._size;
        }

        public boolean isEmpty() {
            return this.size() == 0;
        }

        public E first() {
            if (this.isEmpty())
                return null;
            return this._header.getNext().getElement();
        }

        public E last() {
            if (this.isEmpty())
                return null;
            return this._trailer.getPrev().getElement();
        }

        public void addFirst(E element) {
            this.addBetween(element, this._header, this._header.getNext());
        }

        public void addLast(E element) {
            this.addBetween(element, this._trailer.getPrev(), this._trailer);
        }

        public E removeFirst() {
            if (this.isEmpty())
                return null;
            return this.remove(this._header.getNext());
        }

        public E removeLast() {
            if (this.isEmpty())
                return null;
            return this.remove(this._trailer.getPrev());
        }

        public void addBetween(E element, Node<E> predecessor, Node<E> successor) {
            // create and link a new node
            Node<E> newest = new Node<>(element, predecessor, successor);
            predecessor.setNext(newest);
            successor.setPrev(newest);
            this._size++;
        }

        private E remove(Node<E> node) {
            Node<E> predecessor = node.getPrev();
            Node<E> successor = node.getNext();
            predecessor.setNext(successor);
            successor.setNext(predecessor);
            this._size--;

            return node.getElement();
        }

        public E middleElement() {
            if (this.isEmpty()) return null;

            int cnt = 0; // to store the number of nodes in the list
            Node<E> tmp = this._header;

            // count number of elements in list. O(n) time [n = number of element in list]
            while (tmp != null) {
                cnt++;
                tmp = tmp.getNext();
            }
            int midd = (cnt % 2 == 0) ? cnt / 2 : (cnt / 2) + 1;
            tmp = this._header;

            // find middle element [at most O(n/2), 'n' being the number elements in list]
            while (midd-- > 0)
                tmp = tmp.getNext();

            // Total time approximates to O(n) + O(n/2)
            return tmp.getElement();
        }
    }


    // ##################### TEST CODE ############################

    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        // add 10 integer to the list
        for (int i = 1; i <= 15; i++)
            list.addFirst(i);

        // middle element is suppose to be 7
        System.out.printf("Middle element: %d\n",  list.middleElement());
    }



}

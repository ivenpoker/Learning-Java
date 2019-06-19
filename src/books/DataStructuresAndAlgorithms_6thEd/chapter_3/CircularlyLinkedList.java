package books.DataStructuresAndAlgorithms_6thEd.chapter_3;

public class CircularlyLinkedList<E> {

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

package books.DataStructuresAndAlgorithms_6thEd.chapter_3;

public class DoublyLinkedList<E> {

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
}

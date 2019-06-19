package books.DataStructuresAndAlgorithms_6thEd.chapter_3;

public class SinglyLinkedList<E> implements Cloneable {

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

    private Node<E> _head = null;
    private Node<E> _tail = null;
    private int _size = 0;

    public SinglyLinkedList() {
        // some code here...
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
        return this._head.getElement();
    }

    public E last() {
        if (this.isEmpty())
            return null;
        return this._tail.getElement();
    }

    public void addFirst(E element) {
        this._head = new Node<>(element, this._head);
        if (this.size() == 0)
            this._tail = this._head;
        this._size++;
    }

    public void addLast(E element) {
        Node<E> newest = new Node<>(element, null);
        if (this.isEmpty())
            this._head = newest;
        else
            this._tail.setNext(newest);
        this._tail = newest;
        this._size++;
    }

    public E removeFirst() {
        if (this.isEmpty()) return null;
        E answer = this._head.getElement();
        this._head = this._head.getNext();
        this._size--;
        if (this._size == 0)
            this._tail = null;
        return answer;
    }

    public SinglyLinkedList<E> clone() throws CloneNotSupportedException {
        SinglyLinkedList<E> other = (SinglyLinkedList<E>) super.clone();
        if (this._size == 0) {
            other._head = new Node<>(_head.getElement(), null);
            Node<E> walk = this._head.getNext();
            Node<E> otherTail = other._head;
            while (walk != null) {
                Node<E> newest = new Node<E>(walk.getElement(), null);
                otherTail.setNext(newest);
                otherTail = newest;
                walk = walk.getNext();
            }
        }
        return other;
    }

    public boolean equals(Object obj) {
        if (obj == null)
            return false;

        if (this.getClass() != obj.getClass())
            return false;

        SinglyLinkedList other = (SinglyLinkedList) obj;
        if (this.size() != other.size())
            return false;

        Node walkA = this._head;
        Node walkB = other._head;

        while (walkA != null) {
            if (!walkA.getElement().equals(walkB.getElement()))
                return false;
            walkA = walkA.getNext();
            walkB = walkB.getNext();
        }
        return true;
    }

}



























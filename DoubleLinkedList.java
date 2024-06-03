package iterator_comparator;

import java.util.NoSuchElementException;

public class DoubleLinkedList<T> {

    private DoubleLinkedListNode<T> head;
    private DoubleLinkedListNode<T> tail;
    private int size;

    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addFirst(T data) {
        DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<>() {
            @Override
            public void setNext(DoubleLinkedListNode<T> head) {

            }

            @Override
            public void setPrevious(DoubleLinkedListNode<T> newNode) {

            }

            @Override
            public T getData() {
                return null;
            }

            @Override
            public DoubleLinkedListNode<T> getNext() {
                return null;
            }

            @Override
            public DoubleLinkedListNode<T> getPrevious() {
                return null;
            }
        };

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head);
            head.setPrevious(newNode);
            head = newNode;
        }

        size++;
    }

    public void addLast(T data) {
        DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<>() {
            @Override
            public void setNext(DoubleLinkedListNode<T> head) {

            }

            @Override
            public void setPrevious(DoubleLinkedListNode<T> newNode) {

            }

            @Override
            public T getData() {
                return null;
            }

            @Override
            public DoubleLinkedListNode<T> getNext() {
                return null;
            }

            @Override
            public DoubleLinkedListNode<T> getPrevious() {
                return null;
            }
        };

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrevious(tail);
            tail = newNode;
        }

        size++;
    }

    public T removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }

        T data = head.getData();
        head = head.getNext();

        if (head != null) {
            head.setPrevious(null);
        } else {
            tail = null;
        }

        size--;
        return data;
    }

    public T removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }

        T data = tail.getData();
        tail = tail.getPrevious();

        if (tail != null) {
            tail.setNext(null);
        } else {
            head = null;
        }

        size--;
        return data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        DoubleLinkedListNode<T> current = head;

        while (current != null) {
            sb.append(current.getData());

            if (current.getNext() != null) {
                sb.append(", ");
            }

            current = current.getNext();
        }

        sb.append("]");
        return sb.toString();
    }

    public DoubleLinkedListNode<T> getHead() {
        return null;
    }

    public void setHead(DoubleLinkedListNode<T> next) {
    }

    public void setTail(DoubleLinkedListNode<T> previous) {
    }

    public DoubleLinkedListNode<T> getTail() {
        return null;
    }
}

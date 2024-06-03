package iterator_comparator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleLinkedListIterator<T> implements Iterator<T> {
    private DoubleLinkedListNode<T> current;
    private DoubleLinkedList<T> list;

    public DoubleLinkedListIterator(DoubleLinkedList<T> list) {
        this.list = list;
        this.current = list.getHead();
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        T data = current.getData();
        current = current.getNext();
        return data;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Remove operation is not supported");
    }
}

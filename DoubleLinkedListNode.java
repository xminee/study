package iterator_comparator;

public interface DoubleLinkedListNode<T> {
    void setNext(DoubleLinkedListNode<T> head);

    void setPrevious(DoubleLinkedListNode<T> newNode);

    T getData();

    DoubleLinkedListNode<T> getNext();

    DoubleLinkedListNode<T> getPrevious();
}

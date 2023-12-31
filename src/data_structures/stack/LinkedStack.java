package data_structures.stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

import data_structures.linked_list.iterators.SLLForwardIterator;
import data_structures.linked_list.nodes.SLLNode;

public class LinkedStack<T> implements Stack<T> {
    private SLLNode<T> head;
    private int size = 0;

    @Override
    public void push(T t) {
        if (t == null)
            throw new IllegalArgumentException();
        SLLNode<T> oldHead = head;
        head = new SLLNode<T>();
        head.data = t;
        head.next = oldHead;
        size++;
    }

    @Override
    public T pop() {
        if (isEmpty())
            throw new NoSuchElementException();
        T t = head.data;
        head = head.next;
        size--;
        return t;
    }

    @Override
    public T peek() {
        if (isEmpty())
            throw new NoSuchElementException();
        return head.data;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new SLLForwardIterator<>(head);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        SLLNode<T> curr = head;
        for (int i = 0; i < size; i++) {
            builder.append(curr.data);
            builder.append(", ");
            curr = curr.next;
        }
        builder.setLength(builder.length() - 2);
        return builder.toString();
    }
}

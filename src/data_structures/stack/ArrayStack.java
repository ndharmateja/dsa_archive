package data_structures.stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

import data_structures.array.iterators.ReverseArrayIterator;

@SuppressWarnings("unchecked")
public class ArrayStack<T> implements Stack<T> {
    private T[] s;
    private int size = 0;

    public ArrayStack() {
        s = (T[]) new Object[1];
    }

    private void resize(int capacity) {
        T[] copy = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            copy[i] = s[i];
        }
        s = copy;
    }

    @Override
    public void push(T t) {
        if (t == null)
            throw new IllegalArgumentException();

        if (size == s.length)
            resize(s.length * 2);

        s[size++] = t;
    }

    @Override
    public T pop() {
        if (isEmpty())
            throw new NoSuchElementException();
        T t = s[--size];
        s[size] = null;
        return t;
    }

    @Override
    public T peek() {
        if (isEmpty())
            throw new NoSuchElementException();
        return s[size - 1];
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
        return new ReverseArrayIterator<>(s, size, size);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = size - 1; i >= 0; i--) {
            builder.append(s[i]);
            builder.append(", ");
        }
        builder.setLength(builder.length() - 2);
        return builder.toString();
    }
}

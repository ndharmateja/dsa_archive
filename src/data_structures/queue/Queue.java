package data_structures.queue;

public interface Queue<T> extends Iterable<T> {
    public void enqueue(T t);

    public T dequeue();

    public T peek();

    public boolean isEmpty();

    public int size();
}

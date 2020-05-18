package migu.algorithm.study.queue;

public abstract class Queue<T> {
    abstract void enqueue(T data);
    abstract T dequeue();
    abstract T peek();
    abstract boolean isEmpty();
    boolean isFull() { return false;};
}

package migu.algorithm.study.stack;

public abstract class Stack<T> {
    abstract void push(T data);
    abstract T pop();
    abstract T peek();
    abstract boolean isEmpty();
}

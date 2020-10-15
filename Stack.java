package datastructure;

public interface Stack<E>{
    public E peek();
    public E pop();
    public void push(E e);
    public int size();
    public boolean isEmpty();
}
